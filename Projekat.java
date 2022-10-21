package projekat;

import java.util.ArrayList;
import java.util.Scanner;

public class Projekat {
    public static void main(String[] args) {
        Terminal terminal = new Terminal(); //ovo nam je terminal
        KontrolniToranj toranj=new KontrolniToranj(); //ovo nam je kontolni toranj
        ArrayList<Avion> avioni=new ArrayList<>(); //ovo su nam avioni na raspolaganju
        Scanner skener = new Scanner(System.in);
        
        //dokaz da radi nasledjivanje za vojni avion
        Vojni vojni = new Vojni(2,38.06,"MIG-29","vojni lovacki",0,2,6.20,0); //samo da dokazem da radi nasledjivanje klase
        System.out.println(vojni.toString());
        //vraca recima sta koji stepen naorusanja radi
        vojni.naoruzanje();
        
        
       //lista aviona koje cu da koristim
       avioni.add(new Avion("SAB-340","putnicki",60,6,120,500.45));
       avioni.add(new Avion("BOING-757","putnicki",120,10,400,1230.50)); 
       avioni.add(new Avion("BOING-747","teretni-putnicki",120,12,530,200.787));
        
       //testiranje progama
       int a=0,b;
       int indeks;
       while(true) //beskonacna petlja u kojoj ce
       {
           System.out.println(".....................................................");
           System.out.print("Izaberite 0(EXIT), 1(KONTROLNI TORANJ), 2(TERMINAL): ");
           a=skener.nextInt();
           System.out.println(".....................................................");
           
           //petlja koja proverava da li je unet ispravan broj
           do
           {
               if(a<0 || a>3) 
               {
                   System.out.println("ERROR: Niste uneli ispravan broj, probajte ponovo!");
                   System.out.print("Izaberite 0(EXIT), 1(KONTROLNI TORANJ), 2(TERMINAL): ");
                   a=skener.nextInt();
               }
           }while(a<0 || a>3);
           
           if(a==0) break; //u koliko je izabrana 0 program ce se zavrsiti
           else if(a==1) //u slucaju da je izabran kontrolni toranj
           {
               System.out.println("Da li avion polece ili slece?");
               System.out.print("1(polece); 2(slece); 3(HANGAR): ");
               b=skener.nextInt();
               do
           {
               if(b<1 || b>3) 
               {
                   System.out.println("ERROR: Niste uneli ispravan broj, probajte ponovo!");
                   System.out.print("1(polece); 2(slece); 3(HANGAR): ");
                   b=skener.nextInt();
               }
           }while(b<1 || b>3);
               
               switch(b)
               {
                   //polece avion
                   case(1):
                       System.out.println("U hagngaru: ");
                       toranj.izlistaj();
                       
                       System.out.println("Izaberite indeks aviona: ");
                       for(int i=0;i<avioni.size();i++)
                       {
                       System.out.println(i+":" + avioni.get(i).toString() + ";");
                       }
                       System.out.print("INDEKS: ");
                       indeks=skener.nextInt();
                       
                       for(int i=0;i<avioni.size();i++)
                       {
                           if(indeks==i)toranj.poleceAvion(avioni.get(i));
                       }
                       break;
                   //slece avion
                   case(2):
                       System.out.println("Izaberite indeks aviona: ");
                       for(int i=0;i<avioni.size();i++)
                       {
                       System.out.println(i+":" + avioni.get(i).toString() + ";");
                       }
                       System.out.print("INDEKS: ");
                       indeks=skener.nextInt();
                       
                       for(int i=0;i<avioni.size();i++)
                       {
                           if(indeks==i)toranj.sleceAvion(avioni.get(i));
                       }
                       break;
                   case(3):
                       toranj.izlistaj();
                       break;
               }
           }
           else if(a==2)
           {
               terminal.prodajKartu(toranj); //bukvalo ce samo pokrenuti metodu iz klase Terminal koja ce automatski sve da uradi
           }
               
       }
    }
    
}
