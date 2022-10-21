

//ovo ce biti abstraktna klasa koja ce da pamti odakle su dosli avioni, da li su sleteli, poleteli

//moji avioni ce moci samo da se vracaju odakle su dosli
package projekat;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public abstract class Hangar{
    
    
    //abstraktne metode koje se koriste u klasi kontrolni toranj
    
    
    //ova metoda ce da doda avion u vec postojacu listu
    abstract public void sleceAvion(Avion avionce);
    
    //ova metoda ce da skloni avion iz vec postojace liste
    abstract public void poleceAvion(Avion avionce);
    
     
    
    
    //ova metoda se zove iz klase KontrolniToranj kada avion slece
    //sluzi da ubaci avion u datoteku hangar.txt
    public void zapisiAvione(ArrayList<Avion> avioni)
    {   
//        System.out.println("Zapisi avione se pokrenuo s avionima: ");
//        for(int i=0;i<avioni.size();i++)
//        {
//            System.out.println(avioni.get(i).toString());
//        }
        final String pamti="hangar.txt";
        
        
         JSONArray jsonAvioni=new JSONArray();
        PrintWriter pw = null;
        for (Avion avion : avioni) {
            JSONObject obj = new JSONObject();
            obj.put("oznakaAviona", avion.getOznakaAviona());
            obj.put("klasa",avion.getKlasa());
            obj.put("brojPutnika", avion.getBrojPutnika());//u slucaju da je avion sleteo svi putnici ce izaci
            obj.put("brojOsoblja", avion.getBrojOsoblja());
            obj.put("tezinaPrtljaga", avion.getTezinaPrtljaga()); //takodje prtljazi ce se isprazniti
            obj.put("tezinaTereta", avion.getTezinaTereta()); //teret ne mora da se iznese na ovom Aerodromu
            
            jsonAvioni.add(obj);
        }
        try {
            pw=new PrintWriter(pamti);
            pw.write(jsonAvioni.toJSONString());
        } catch (FileNotFoundException ex) {
            System.out.println("Greska prilikom upisa!\n"+ex.getMessage());
        }
        finally{
            if(pw != null)
                pw.close();
        }
    }
    
  
     //ova metoda se zove iz klase KontrolniToranj kada avion polece
    //sluzi da izbaci avion zi datoteke hangar.txt
    public void izbrisiAvione(Avion avionce)throws Exception
    {
        System.out.println("Metoda se pokrenula");
        ArrayList<Avion> avioni2 = new ArrayList<>();
        final String pamti="hangar.txt";
        
        
        JSONArray jsonAvioni=(JSONArray) new JSONParser().parse(new FileReader(pamti));
        for(Object o: jsonAvioni){
            JSONObject obj=(JSONObject) o;
            String oznakaAviona=obj.get("oznakaAviona").toString();
            String klasa=obj.get("klasa").toString();
            int brojPutnika=Integer.parseInt(obj.get("brojPutnika").toString());
            int brojOsoblja=Integer.parseInt(obj.get("brojOsoblja").toString());
            double tezinaPrtljaga=Double.parseDouble(obj.get("tezinaPrtljaga").toString());
            double tezinaTereta=Double.parseDouble(obj.get("tezinaTereta").toString());
            
            
            avioni2.add(new Avion(oznakaAviona, klasa, brojPutnika, brojOsoblja, tezinaPrtljaga,tezinaTereta));
        }
        
        //iz liste ce izbaciti taj avion i onda zapamtiti novi sadrzaj liste
        for(int i=0;i<avioni2.size();i++)
        {   
            if(avioni2.get(i).getOznakaAviona().toLowerCase().equals(avionce.getOznakaAviona().toLowerCase()))
            {
                avioni2.remove(i);
            }
             
        }
        
        //ovde samo pozivam prvu metodu gde smo pamtili avione u datoteci hangar.txt
        zapisiAvione(avioni2);
    }
    
     //ova metoda se zove iz klase KontrolniToranj kada zelimo da izlistamo sve avione koji su u hangaru
    //sluzi da procita sadrzaj iz datoteke hangar.txt
    public void vidiHangar()throws Exception
    {
        ArrayList<Avion> avioni2 = new ArrayList<>();
        final String pamti="hangar.txt";
        
        
        JSONArray jsonAvioni=(JSONArray) new JSONParser().parse(new FileReader(pamti));
        for(Object o: jsonAvioni){
            JSONObject obj=(JSONObject) o;
            String oznakaAviona=obj.get("oznakaAviona").toString();
            String klasa=obj.get("klasa").toString();
            int brojPutnika=Integer.parseInt(obj.get("brojPutnika").toString());
            int brojOsoblja=Integer.parseInt(obj.get("brojOsoblja").toString());
            double tezinaPrtljaga=Double.parseDouble(obj.get("tezinaPrtljaga").toString());
            double tezinaTereta=Double.parseDouble(obj.get("tezinaTereta").toString());
            
            
            avioni2.add(new Avion(oznakaAviona, klasa, brojPutnika, brojOsoblja, tezinaPrtljaga,tezinaTereta));
        }
        
        //ovde se ispisuju svi avioni
        System.out.println("U hangaru su avioni: ");
        for(int i=0;i<avioni2.size();i++)
        {
            System.out.print((i+1)+": ");
            System.out.println(avioni2.get(i).toString());
        }
        
        
        
    }
    
    //ova metoda se poziva iz klase KontrolniToranj,
    //sluzi kada se iz klase Terminal kupi karta ovde ce se promeniti broj ptunika u datoteci hangar.txt
    public void izmeni(Avion avionce,int brojOsoba,double prtljag)throws Exception
    {
               
        ArrayList<Avion> avioni2 = new ArrayList<>();
        final String pamti="hangar.txt";
        
        
        JSONArray jsonAvioni=(JSONArray) new JSONParser().parse(new FileReader(pamti));
        for(Object o: jsonAvioni){
            JSONObject obj=(JSONObject) o;
            String oznakaAviona=obj.get("oznakaAviona").toString();
            String klasa=obj.get("klasa").toString();
            int brojPutnika=Integer.parseInt(obj.get("brojPutnika").toString());
            int brojOsoblja=Integer.parseInt(obj.get("brojOsoblja").toString());
            double tezinaPrtljaga=Double.parseDouble(obj.get("tezinaPrtljaga").toString());
            double tezinaTereta=Double.parseDouble(obj.get("tezinaTereta").toString());
            
            
            avioni2.add(new Avion(oznakaAviona, klasa, brojPutnika, brojOsoblja, tezinaPrtljaga,tezinaTereta));
        }
        
        //iz liste ce izbaciti taj avion i onda zapisati novi sadrzaj;
        for(int i=0;i<avioni2.size();i++)
        {   
            if(avioni2.get(i).getOznakaAviona().toLowerCase().equals(avionce.getOznakaAviona().toLowerCase()))
            {
                System.out.println("U metodi vidi u klasi Hangar se nasao avion");
                System.out.println("Unet broj osoba je ="+brojOsoba+"a tezina prtljaga je="+prtljag);
                avioni2.get(i).setBrojPutnika(brojOsoba);
                avioni2.get(i).setTezinaPrtljaga(prtljag);
            }
             
        }
        
        zapisiAvione(avioni2);
    }
   
}
