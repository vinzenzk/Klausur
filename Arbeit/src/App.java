import java.util.ArrayList;

public class App {
    
    public static ArrayList<Buchung> buchungen = new ArrayList<>();
    public static ArrayList<Medien> alleMedien = new ArrayList<>();
    public static ArrayList<Schallplatte> alleSchallplatten = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        
    }
    
    public static void demoTest(){
        Kunde k1 = new Kunde("Max", "Mustermann", 20, 12345);
        Kunde k2 = new Kunde("Hans", "Münster", 15, 15);
        BluRay br1 = new BluRay("Avatar", 6, 120, false, true);
        DVD d1 = new DVD("Tribute von Panem", 16, 100, true, false);

        buchungen.add(new Buchung(k2, d1));
        buchungen.add(new Buchung(k2, br1));
        buchungen.add(new Buchung(k1, d1));
        buchungen.add(new Buchung(k1, br1));


        int index = 0;
        for(Buchung alleBuchungen : buchungen){
            
            if(alleBuchungen.getKunde().getAlter() < alleBuchungen.getMedium().getFSK()){
                System.out.println("Vorgang konnte nicht durchgeführt werden, da as Alter nicht ausreicht.");
                buchungen.remove(index);
            }
            else{
                if(alleBuchungen.getKunde().getAusleihen().length > 5){
                    System.out.println("Vorgang konnte nicht durchgeführt werden, da der zu viele Medien ausgeliehen sind.");
                    buchungen.remove(index);
                }
                else{
                    System.out.println("Buchvorgang wurde erfolgreich durcheführt.");
                }
            }
            index++;
        }
    }
    public static void testWarnungen(){
        Kunde k1 = new Kunde("Max", "Mustermann", 20, 12345);
        Kunde k2 = new Kunde("Hans", "Münster", 15, 15);
        BluRay br1 = new BluRay("Avatar", 6, 120, false, true);
        DVD d1 = new DVD("Tribute von Panem", 16, 100, true, false);

        buchungen.add(new Buchung(k2, d1));
        buchungen.add(new Buchung(k2, br1));
        buchungen.add(new Buchung(k1, d1));
        buchungen.add(new Buchung(k1, br1));

        Verwarnung v1 = new Verwarnung("1.1.22", "ZU spät");
        Verwarnung v2 = new Verwarnung("2.2.21", "Beschädigt");
        Verwarnung v3 = new Verwarnung("3.2.21", "Beschädigt");
        Verwarnung v4 = new Verwarnung("5.2.21", "Beschädigt");
        Verwarnung v5 = new Verwarnung("18.2.21", "Beschädigt");
        k1.getVerwarnungen().add(v2);
        k1.getVerwarnungen().add(v1);
        k1.getVerwarnungen().add(v3);
        k1.getVerwarnungen().add(v4);
        k1.getVerwarnungen().add(v5);

        int index = 0;
        for(Buchung alleBuchungen : buchungen){
            index++;
            if(alleBuchungen.getKunde().getAlter() < alleBuchungen.getMedium().getFSK()){
                System.out.println("Vorgang konnte nicht durchgeführt werden, da as Alter nicht ausreicht.");
                buchungen.remove(index);
            }
            else{
                if(alleBuchungen.getKunde().getAusleihen().length > 5){
                    System.out.println("Vorgang konnte nicht durchgeführt werden, da der zu viele Medien ausgeliehen sind.");
                    buchungen.remove(index);
                }
                else{
                    if(alleBuchungen.getKunde().getVerwarnungen().size() >= 5){
                        System.out.println("Der Kunde hat zu viele Verwarnungen.");
                        buchungen.remove(index);
                    }
                    else{
                    System.out.println("Buchvorgang wurde erfolgreich durcheführt.");
                    }
                }
            }
        }
    }
    public static void zeigeMedien(){
        BluRay br1 = new BluRay("Avatar", 6, 120, false, true);
        DVD d1 = new DVD("Tribute von Panem", 16, 100, true, false);
        alleMedien.add(d1);
        alleMedien.add(br1);

        int i = 1;
        for(Medien mediens : alleMedien){
            System.out.println(i);
            mediens.zeigeDaten();
            i++;
        }
    }

    public static void ueberschreibeAusleihe(){
        for(Medien mediens : alleMedien){
            if(mediens.getVerliehen() == true){
                mediens.setVerliehen(false);
            }
            else{
                mediens.setVerliehen(true);
            }
        System.out.println("Ausleihe wurde überschrieben");
        }
    }
    public static void aendereSchallplatten(){
        for(Schallplatte mediens : alleSchallplatten){
            if(mediens.getDarfVerliehenwerden() == true){
                mediens.setDarfVerliehenwerden(false);
            }
            else{
                mediens.setDarfVerliehenwerden(true);;
            }
        System.out.println("Schallplatte wurde überschrieben");
        }
    }

}

