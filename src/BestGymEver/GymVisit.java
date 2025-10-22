package BestGymEver;

import java.time.LocalDate;

public class GymVisit {
    private final String memberName;
    private final String personnummer;
    private final String membershipType;
    private final LocalDate visitDate;

    public GymVisit(String memberName, String membershipType, String personnummer, LocalDate visitDate) {
        this.memberName = memberName;
        this.membershipType = membershipType;
        this.personnummer = personnummer;
        this.visitDate = visitDate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }
}