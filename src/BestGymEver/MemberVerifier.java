package BestGymEver;

import java.util.List;

public class MemberVerifier {

    private List<Member> members;

    public MemberVerifier(List<Member> members) {
        this.members = members;
    }

    // Sök personnummer
    public Member findMember(String personNummer) {
        if (personNummer == null) return null;

        for (Member member : members) {
            if (personNummer.equals(member.getPersonnummer())) {
                return member;
            }
        }
        return null; // medlem finns inte
    }

    // Sök namn
    public Member findMember(String firstName, String lastName) {
        if (firstName == null || lastName == null) return null;

        String fullName = firstName + " " + lastName;
        for (Member member : members) { // <-- här var felet
            if (fullName.equalsIgnoreCase(member.getNamn())) {
                return member;
            }
        }
        return null; // medlem finns inte
    }


}