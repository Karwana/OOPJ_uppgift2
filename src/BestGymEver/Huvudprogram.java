package BestGymEver;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Huvudprogram {
    void main() {

        IO.println("BestGymEver Member Verifier");
        Scanner sc = new Scanner(System.in);

        //ladda in lista
        MemberFileReader reader = new MemberFileReader();
        Path memberFile = Path.of("src/BestGymEver/gym_medlemmar.txt");
        List<Member> members = reader.read(memberFile);

        if (members == null) {
            IO.println("Kunde inte läsa medlemsfilen. Avslutar.");
            return;
        }

        MemberVerifier verifier = new MemberVerifier(members);
        GymVisitWriter writer = new GymVisitWriter();

        try {
            IO.println("Skriv personnummer (YYYYMMDD-XXXX) eller namn (FÖRNAMN EFTERNAMN)");
            String input = sc.nextLine().trim();

            Member member = null;

            // Kolla om input är personnummer eller namn
            if (input.contains("-")) {
                member = verifier.findMember(input);
            } else {
                String[] nameParts = input.split(" ", 2);
                if (nameParts.length == 2) {
                    member = verifier.findMember(nameParts[0], nameParts[1]);
                }
            }

            // Visa status
            String status = verifier.verifyMemberStatus(member);
            IO.println(status);

            // Spara besök om nuvarande medlem
            if (member != null && member.isActiveMember()) {
                GymVisit visit = new GymVisit(member.getNamn(), member.getMemberType(),
                        member.getPersonnummer(), LocalDate.now());
                writer.writeVisit(visit);
                IO.println("Besök registrerat!");
            }

        } catch (Exception e) {
            IO.println("Något gick fel: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}