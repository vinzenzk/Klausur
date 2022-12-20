import java.util.ArrayList;

public class App {
    
    // Alle statischen Arraylists, die benötigt werden
    public static ArrayList<Buchung> buchungen = new ArrayList<>();
    public static ArrayList<Medien> alleMedien = new ArrayList<>();
    public static ArrayList<Schallplatte> alleSchallplatten = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        // In der main-Methode werden nur die anderen Methoden ausgeführt
        
    }
    
    // Aufgabe 1
    public static void demoTest(){
        // Demodaten
        Kunde k1 = new Kunde("Max", "Mustermann", 20, 12345);
        Kunde k2 = new Kunde("Hans", "Münster", 15, 15);
        BluRay br1 = new BluRay("Avatar", 6, 120, false, true);
        DVD d1 = new DVD("Tribute von Panem", 16, 100, true, false);

        buchungen.add(new Buchung(k2, d1));
        buchungen.add(new Buchung(k2, br1));
        buchungen.add(new Buchung(k1, d1));
        buchungen.add(new Buchung(k1, br1));


        // Da alle Buchungen direkt gespeichert werden, geht diese for-each Schleife alle enthaltenen Buchungen durch und überprüft jede, ob sie durchgeführt werden kann, löscht sie falls dies nicht der Fall ist und gibt in jedem Fall eine passende Information im Terminal aus
        int index = 0;
        for(Buchung buchung : buchungen){
            
            // Prüfung nach Altersbeschränkung
            if(buchung.getKunde().getAlter() < buchung.getMedium().getFSK()){
                System.out.println("Vorgang konnte nicht durchgeführt werden, da as Alter nicht ausreicht.");
                buchungen.remove(index);
            }
            else{
                // Prüfung, ob der Kunde zu viele Medien bereits ausgeliehen hat
                if(buchung.getKunde().getAusleihen().length > 5){
                    System.out.println("Vorgang konnte nicht durchgeführt werden, da der zu viele Medien ausgeliehen sind.");
                    buchungen.remove(index);
                }
                else{
                    // Abgeschlossene Prüfung, ausgeliehenes Medium wird erst hier der Liste an Medien für den Kunden hinzugefügt
                    System.out.println("Buchvorgang wurde erfolgreich durchgeführt.");
                    buchung.getKunde().ausleihen[buchung.getKunde().getAusleihen().length] = buchung.getMedium();
                }
            }
            index++;
        }
    }

    // Aufgabe 2
    public static void testWarnungen(){
        // Demodaten
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
        // Gleiches Prüfungsverfahren wie in Aufgabe 1, nur die Verwarnungen werden nun zusätzlich überprüft
        for(Buchung buchung : buchungen){
            index++;
            if(buchung.getKunde().getAlter() < buchung.getMedium().getFSK()){
                System.out.println("Vorgang konnte nicht durchgeführt werden, da as Alter nicht ausreicht.");
                buchungen.remove(index);
            }
            else{
                if(buchung.getKunde().getAusleihen().length > 5){
                    System.out.println("Vorgang konnte nicht durchgeführt werden, da der zu viele Medien ausgeliehen sind.");
                    buchungen.remove(index);
                }
                else{
                    if(buchung.getKunde().getVerwarnungen().size() >= 5){
                        System.out.println("Der Kunde hat zu viele Verwarnungen.");
                        buchungen.remove(index);
                    }
                    else{
                    System.out.println("Buchvorgang wurde erfolgreich durcheführt.");
                    buchung.getKunde().ausleihen[buchung.getKunde().getAusleihen().length] = buchung.getMedium();
                    }
                }
            }
        }
    }
    // Aufgabe 3
    public static void zeigeMedien(){
        BluRay br1 = new BluRay("Avatar", 6, 120, false, true);
        DVD d1 = new DVD("Tribute von Panem", 16, 100, true, false);
        alleMedien.add(d1);
        alleMedien.add(br1);

        int i = 1;
        for(Medien mediens : alleMedien){
            // Die abstrakte Methode wird genutzt, welche alle Daten der Unterklassen von Medien ausgiebt
            System.out.println(i);
            mediens.zeigeDaten();
            i++;
        }
    }

    // Aufgabe 4
    public static void ueberschreibeAusleihe(){
        // In der for-each Schleife wird für jedes Objekt aus den Unterklassen von Medien der Wert zum Gegenteil geändert
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

    // Aufgabe 5
    public static void aendereSchallplatten(){
        // Die Eigenschaft darfVerliehenwerden für alle Objekte aus der Klasse Schallplatte wird geswitched
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

