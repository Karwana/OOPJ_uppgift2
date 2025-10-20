package BestGymEver;

public class Person {
    private String namn;
    private String adress;
    private String mailadress;
    private String personnummer;

    Person(){}
    Person(String namn, String adress, String mailadress, String personnummer) {
        this.namn = namn;
        this.adress = adress;
        this.mailadress = mailadress;
        this.personnummer = personnummer;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMailadress() {
        return mailadress;
    }

    public void setMailadress(String mailadress) {
        this.mailadress = mailadress;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }
}
