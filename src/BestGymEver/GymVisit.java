package BestGymEver;

import java.time.LocalDate;

public class GymVisit {
    private String memberName;
    private String personnummer;
    private LocalDate visitDate;

    public GymVisit(String memberName, String personnummer, LocalDate visitDate) {
        this.memberName = memberName;
        this.personnummer = personnummer;
        this.visitDate = visitDate;
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
