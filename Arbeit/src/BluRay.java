public class BluRay extends Medien {
    // Unterklasse CD der Oberklasse Medien
    boolean is3D;

    public BluRay(String titel, int FSK, int laenge, boolean verliehen,  boolean is3d){
        super(titel, FSK, laenge, verliehen);
        setIs3D(is3d);
    }
    public void setIs3D(boolean is3d) {
        is3D = is3d;
    }
    public boolean getIs3d(){
        return is3D;
    }

    //shdshd

    // Methode zeigeDaten gibt, wenn aufgerufen, alle gegebenen Daten aus, inlusive der jeweiligen unterschiedlichen Eigenschaften
    public void zeigeDaten(){
        System.out.println(getTitel() + " " + getFSK() + " " + getLaenge() + " " + " " + getIs3d());
    }
    
}
