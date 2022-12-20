public class DVD extends Medien{
    // Unterklasse DVD der Oberklasse Medien
    boolean isFullHD;

    public DVD(String titel, int FSK, int laenge, boolean verliehen, boolean isFullHD){
        super(titel, FSK, laenge, verliehen);
        setFullHD(isFullHD);
    }
    public void setFullHD(boolean isFullHD) {
        this.isFullHD = isFullHD;
    }
    public boolean getIsFullHD(){
        return isFullHD;
    }

    // Methode zeigeDaten gibt, wenn aufgerufen, alle gegebenen Daten aus, inlusive der jeweiligen unterschiedlichen Eigenschaften
    public void zeigeDaten(){
        System.out.println(getTitel() + " " + getFSK() + " " + getLaenge() + " " + " " + getIsFullHD());
    }

}
