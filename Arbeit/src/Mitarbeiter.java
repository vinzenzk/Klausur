public class Mitarbeiter extends Mensch{
    // Die Unterklasse Mitarbeiter erweitert die Oberklasse Mensch
    int mitarbeiternummer;

    public Mitarbeiter(String vorname, String nachname, int mitarbeiternummer){
        super(vorname, nachname);
        setMitarbeiternummer(mitarbeiternummer);
    }
    public void setMitarbeiternummer(int mitarbeiternummer) {
        this.mitarbeiternummer = mitarbeiternummer;
    }
    public int getMitarbeiternummer() {
        return mitarbeiternummer;
    }
}
