package BestGymEver;

import java.time.LocalDate;
import java.time.LocalTime;

public class GymVisit {
    private String memberName;
    private String personnummer;
    private LocalDate visitDate;
    private LocalTime visitTime;

    public GymVisit(String memberName, String personnummer, LocalDate visitDate) {
        this.memberName = memberName;
        this.personnummer = personnummer;
        this.visitDate = visitDate;
        this.visitTime = LocalTime.now();
    }

    public LocalTime getVisitTime() {
        return visitTime;
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
