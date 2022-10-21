//Prijam putnika i prodaja karata
package projekat;

import java.util.Scanner;

public class Terminal implements TerminalInterfejs{
    public void prodajKartu(KontrolniToranj toranj)
    {
        Scanner skener = new Scanner(System.in);
        int brojKarata;
        double prtljag;
        String oznaka;
        System.out.print("Ukupan broj karata=");
        brojKarata=skener.nextInt();
        skener.nextLine();
        System.out.println("");
        
        System.out.print("Tezina prtljaga=");
        prtljag=skener.nextDouble();
        skener.nextLine();
        toranj.izlistaj();
        
       System.out.println("Izaberite oznaku aviona: ");
       oznaka=skener.nextLine();
       
       toranj.dodajKarte(brojKarata, oznaka,prtljag);
    }

    //samo prazan konstruktor
    public Terminal() {
    }
    
}
