package projekat;

import java.util.Scanner;

public class Vojni extends Avion{    
    private int stepenNaoruzanja;
    private double povrsinaKrila;
    Scanner skener=new Scanner(System.in);
    
    public Vojni(int stepenNaoruzanja, double povrsinaAviona, String oznakaAviona, String klasa, int brojPutnika, int brojOsoblja, double tezinaPrtljaga, double tezinaTereta) {
        super(oznakaAviona, klasa, brojPutnika, brojOsoblja, tezinaPrtljaga, tezinaTereta);
        
        //ukoliko je unet pogresni stepen naoruzanja, videcu da li cu da koristim ovo?
//        if(stepenNaoruzanja==0 || stepenNaoruzanja==1 || stepenNaoruzanja==2){
//        this.stepenNaoruzanja = stepenNaoruzanja;}
//        else
//        {
//            do{
//            System.out.println("Niste uneli ispravan stepen naoruzanja za avion = " +oznakaAviona);
//            System.out.print("Unesite opet, stepen naoruzanja = ");
//            stepenNaoruzanja=skener.nextInt();
//                    }while(stepenNaoruzanja<0 || stepenNaoruzanja>2);
//            this.stepenNaoruzanja=stepenNaoruzanja;
//        }
        this.stepenNaoruzanja=stepenNaoruzanja;
        this.povrsinaKrila = povrsinaKrila;
    }

    public int getStepenNaoruzanja() {
        return stepenNaoruzanja;
    }

    public void setStepenNaoruzanja(int stepenNaoruzanja) {
        this.stepenNaoruzanja = stepenNaoruzanja;
    }

    public double getPovrsinaKrila() {
        return povrsinaKrila;
    }

    public void setPovrsinaKrila(double povrsinaKrila) {
        this.povrsinaKrila = povrsinaKrila;
    }
    
    //ova metoda ce nam reci sta znaci koji stepen naoruzanja
    public void naoruzanje()
    {
        switch(stepenNaoruzanja)
        {
            case 0:
                System.out.println("Ovo je putnicki vojni avion bez naoruzanja.");
                break;
            case 1:
                System.out.println("Vojni avion s mitraljezom,");
                break;
            case 2:
                System.out.println("Vojni avion s mitraljezom, i spoljnim raketama.");
                break;
            default:
                System.out.println("Vojni avion s nepoznatim stepenom naoruzanja.");
                break;
        }
                
    }

    @Override
    public String toString() {
        return super.toString()+" ,stepen naoruzanja = " +stepenNaoruzanja+ " , povrsina krila = " +povrsinaKrila;
    }
    
    
    
    
}
