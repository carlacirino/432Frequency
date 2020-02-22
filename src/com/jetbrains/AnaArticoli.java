package com.jetbrains;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnaArticoli implements Serializable {

    private HashMap<String,Articolo> anagrafica;
    //private Random r= new Random();
    //Iterator it;

    public AnaArticoli(){
        anagrafica = new HashMap<>();
    }


    public Articolo RicercaArticoloAna(String k)  {
        return anagrafica.getOrDefault(k, null);
    }

    public void InserisciArticoloAna(Articolo a)  {
        /*CD cd = new CD();
        cd = (CD) cd.InserisciArticolo();*/
        if(anagrafica.containsKey(a.getSeriale())){
            System.out.println("\nArticolo presente in Anagrafica articoli!\n");
            return;
        }
        String key=a.getSeriale();
        anagrafica.put(key,a);
        System.out.println("\nArticolo inserito con successo!\n");
    }
    public HashMap<String, Articolo> RicercaArtbyName(String n){
        HashMap<String, Articolo> returnArt = new HashMap<>();
        //LinkedList<Articolo> returnArt = new LinkedList<>();
        Iterator it = anagrafica.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry= (Map.Entry) it.next();
            if(anagrafica.get(entry.getKey()).getLabel().contains(n)||anagrafica.get(entry.getKey()).getCat().getDescrizione().contains(n)){
                returnArt.put((String)entry.getKey(),(Articolo) entry.getValue());

            }
        }
        return returnArt;
    }

    public String EliminaArticoloAna(String k)  {
        Articolo ar;
        String stampa;
        ar=RicercaArticoloAna(k);
        if(ar==null){
            stampa="\nArticolo non presente in Anagrafica Articoli\n";
            return stampa;
        }
        else{
            anagrafica.remove(k);
            //mgz.remove(k); //Rimuovendo l'articolo dall'anagrafica articoli, lo rimuoviamo anche dal magazzino
            stampa="\nArticolo rimosso con successo\n";
            return stampa;
        }
    }



    public String StampaArticoli()  {
        Iterator it;
        StringBuilder stampa = new StringBuilder();
        if(anagrafica.isEmpty()){
            stampa = new StringBuilder("\nAnagrafica articoli vuota\n");
            return stampa.toString();
        }
        it = anagrafica.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            stampa.append("Codice: ").append(entry.getKey()).append("; Prodotto: ").append(entry.getValue()).append("\n");
        }
        return stampa.toString();
    }
    @Override
    public String toString() {
        return "Anagrafica Articoli\n" + anagrafica+"\n";
    }

    public HashMap<String, Articolo> getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(HashMap<String, Articolo> anagrafica) {
        this.anagrafica = anagrafica;
    }




}
