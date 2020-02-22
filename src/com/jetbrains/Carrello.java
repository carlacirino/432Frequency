package com.jetbrains;
import java.io.Serializable;
import java.util.*;

public class Carrello implements Serializable {
    private HashMap<Articolo,Integer> carrello;
    private double totale;
    final char euro = '\u20ac';

    public Carrello() {
        carrello = new HashMap<>();
        totale = 0;
    }

    public Carrello(HashMap<Articolo, Integer> carrello) {
        this.carrello = carrello;
    }

    public HashMap<Articolo, Integer> getCarrello() {
        return carrello;
    }

    public void setCarrello(HashMap<Articolo, Integer> carrello) {
        this.carrello = carrello;
    }

    public void stampaCarrello() {
        Iterator it = carrello.entrySet().iterator();
        StringBuilder stampa = new StringBuilder();
        if (carrello.isEmpty()) {
            System.out.println("\nCarrello vuoto!\n");
        } else {
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                stampa.append("Articolo: ").append(entry.getKey()).append("; Quantità: ").append(entry.getValue()+"\n");

                //stampa.append("Codice: ").append(entry.getKey()).append("; Articolo: ").append(entry.getValue()).append("; Quantità: ").append(qArticolo.get(entry.getKey())).append("\n");
            }
            stampa.append("\nTotale carrello: ").append(getTotale()).append(euro);
            System.out.println((stampa.toString()));

        }
    }

    public void InserisciArtCarrello(Articolo a, int q) {
        if (q > 0) {
            carrello.put(a, q);

            setTotale(getTotale() + q * a.getPrezzo());
        } else
            System.out.println("Impossibile aggiungere una quantità nulla o negativa\n");
    }

    public void SvuotaCarrello(){
        carrello.clear();
        setTotale(0);
    }

    public Articolo ricercaNelCarrello(String seriale){
        Articolo a;
        for (Object o : carrello.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            a = (Articolo)entry.getKey();
            if (a.getSeriale().equals(seriale)) {
                return (Articolo) entry.getKey();
            }
        }
        return null;
    }

    public void rimuoviDalCarrello(String seriale){
        Articolo art;
        art=ricercaNelCarrello(seriale);
        if(art==null){
            System.out.println("\nArticolo non presente nel tuo carrello\n") ;
        }
        else{
            int quantita = carrello.get(art);
            setTotale(getTotale()-quantita*art.getPrezzo());
            carrello.remove(art);
            System.out.println("\nArticolo rimosso dal tuo carrello\n");
        }
    }

    public void modificaQArticolo(String seriale){
        Articolo art;
        Scanner input = new Scanner(System.in);
        int q;
        art = ricercaNelCarrello(seriale);
        if (art==null){
            System.out.println("\nArticolo non presente nel tuo carrello\n") ;
        }
        else{
            int quantita = carrello.get(art);
            setTotale(getTotale()-quantita*art.getPrezzo());
            System.out.println("\nInserire la nuova quantità dell'articolo\n");
            q = input.nextInt();
            carrello.put(art,q);
            System.out.println("\nQuantità dell'articolo: "+art.getSeriale()+" "+ art.getLabel()+ " aggiornata\n");
            setTotale(getTotale()+q*art.getPrezzo());
        }
    }


    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrello carrello1 = (Carrello) o;
        return Double.compare(carrello1.totale, totale) == 0 &&
                Objects.equals(carrello, carrello1.carrello);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carrello, totale);
    }
}
