package BestGymEver;

import java.time.LocalDate;

public class Member {
    private String namn;
    private String adress;
    private String mailadress;
    private String personnummer;
    private LocalDate memberStartDate;
    private LocalDate memberLatestUpdateDate;
    private String memberType;


    Member() {}
    Member(String namn, String adress, String mailadress, String personnummer, LocalDate memberStartDate, LocalDate memberLatestUpdateDate, String memberType) {
        this.namn = namn;
        this.adress = adress;
        this.mailadress = mailadress;
        this.personnummer = personnummer;
        this.memberStartDate = memberStartDate;
        this.memberLatestUpdateDate = memberLatestUpdateDate;
        this.memberType = memberType;
    }

    public boolean isActiveMember() {
        return memberLatestUpdateDate.isAfter(LocalDate.now().minusYears(1));
        // Medlem aktiv om senaste betalning var mindre än 1 år sedan

    }

    public String getNamn() {
        return namn;
    }

    public String getAdress() {
        return adress;
    }

    public String getMailadress() {
        return mailadress;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public LocalDate getMemberStartDate() {
        return memberStartDate;
    }


    public LocalDate getMemberLatestUpdateDate() {
        return memberLatestUpdateDate;
    }


    public String getMemberType() {
        return memberType;
    }

}
