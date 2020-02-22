package com.jetbrains;

import java.io.Serializable;
import java.util.HashMap;

public class Ordine implements Serializable {
    private int id;
    private String data;
    private double totale;
    private char euro = '\u20ac';
    private HashMap<Articolo,Integer> ArtOrd;

    public Ordine() {
        ArtOrd = new HashMap<>();
        totale = 0;
    }

    public Ordine(int id, String data, HashMap<Articolo, Integer> artOrd) {
        this.id = id;
        this.data = data;
        ArtOrd = artOrd;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public HashMap<Articolo, Integer> getArtOrd() {
        return ArtOrd;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }



    public void setArtOrd(HashMap<Articolo, Integer> artOrd) {
        ArtOrd = artOrd;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", data=" + data +
                ", totale ordine=" + totale + euro +
                "\nArticoli ordinati=" + ArtOrd +
                '}'+"\n";
    }
}
