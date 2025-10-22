package BestGymEver;

import java.util.List;

public class MemberVerifier {

    private List<Member> members;
    public MemberVerifier(List<Member> allMembers) {
        this.members = allMembers;
    }

    // Sök personnummer
    public Member findMember(String personNummer) {
        if (personNummer == null) return null;

        for (Member currentMember : members) {
            if (personNummer.equals(currentMember.getPersonnummer())) {
                return currentMember;
            }
        }
        return null; // medlem finns inte
    }

    // Sök namn
    public Member findMember(String firstName, String lastName) {
        if (firstName == null || lastName == null) return null;

        String fullName = firstName + " " + lastName;
        for (Member currentMember : members) { // <-- här var felet
            if (fullName.equalsIgnoreCase(currentMember.getNamn())) {
                return currentMember;
            }
        }
        return null; // medlem finns inte
    }

    // Kolla medlemsstatus
    public String verifyMemberStatus(Member m) {
        if (m == null) return "Obehörig!";
        if (m.isActiveMember()) return "Nuvarande medlem: " + m.getMemberType();
        return "Före detta kund";
    }


}