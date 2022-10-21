//kontrolni toranj ce da javlja koji avion je poleteo, doleteo, da li ima potvrdu za sletenje, odakle dolazi, i gde ide
package projekat;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


//NAGLASI GRESKUUUUU, PRE BILO KAKVOG POKRETANJA Hangra.txt mora da se obrise
class KontrolniToranj extends Hangar{
    private ArrayList<Avion> avioni;
    
    public KontrolniToranj(){
        avioni= new ArrayList<>();
        final String pamti="hangar.txt";
        
        
         JSONArray jsonAvioni=new JSONArray();
        PrintWriter pw = null;
        for (Avion avion : avioni) {
            JSONObject obj = new JSONObject();
            obj.put("oznakaAviona", avion.getOznakaAviona());
            obj.put("klasa",avion.getKlasa());
            obj.put("brojPutnika", 0);//u slucaju da je avion sleteo svi putnici ce izaci
            obj.put("brojOsoblja", avion.getBrojOsoblja());
            obj.put("tezinaPrtljaga", 0); //takodje prtljazi ce se isprazniti
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
    
    @Override
    public void sleceAvion(Avion avionce)
    {
        avionce.setBrojPutnika(0);
        avionce.setTezinaPrtljaga(0);
        
        avioni.add(avionce);
        zapisiAvione(avioni);
    }
    
    @Override
    public void poleceAvion(Avion avionce)
    {
        try{
            izbrisiAvione(avionce);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        avioni.remove(avionce);
    }
    
    public void izlistaj()
    {
        try{
        vidiHangar();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void dodajKarte(int brojKarata, String oznakaAviona,double tezinaPrtljaga)
    {
        int i;
        int ukupanBroj=0;
        double ukupnaTezinaPrtljaga=0;
        for(i=0;i<avioni.size();i++)
        {
        if(avioni.get(i).getOznakaAviona().toLowerCase().equals(oznakaAviona.toLowerCase()))
        {
            System.out.println("Nasli smo podudarnost");
            ukupanBroj=avioni.get(i).getBrojPutnika();
            ukupanBroj+=brojKarata;
            avioni.get(i).setBrojPutnika(ukupanBroj);
            ukupnaTezinaPrtljaga=avioni.get(i).getTezinaPrtljaga();
            ukupnaTezinaPrtljaga+=tezinaPrtljaga;
            avioni.get(i).setTezinaPrtljaga(ukupnaTezinaPrtljaga);
        try
        {
            izmeni(avioni.get(i),ukupanBroj,ukupnaTezinaPrtljaga);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        }
        }
    }
    


}
