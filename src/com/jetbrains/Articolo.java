package com.jetbrains;

import java.io.Serializable;
import java.util.Objects;

public abstract class Articolo implements Serializable {
    private String seriale;
    private double prezzo;
    private Categoria cat;
    private String label;
    private char euro = '\u20ac';

    public Articolo() {
    }

    public Articolo(String seriale, double prezzo) {
        this.seriale = seriale;
        this.prezzo = prezzo;
    }

    public Articolo(String seriale) {
        this.seriale = seriale;
    }

    public Articolo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Articolo(String seriale, double prezzo, Categoria cat) {
        this.seriale = seriale;
        this.prezzo = prezzo;
        this.cat = cat;
    }

    public Articolo(Categoria cat) {
        this.cat = cat;
    }

    public Articolo(String seriale, double prezzo, Categoria cat, String label) {
        this.seriale = seriale;
        this.prezzo = prezzo;
        this.cat = cat;
        this.label = label;
    }

    public String getSeriale() {
        return seriale;
    }

    public void setSeriale(String seriale) {
        this.seriale = seriale;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }



    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Articolo{" +
                "seriale='" + seriale + '\'' +
                ", prezzo=" + prezzo + euro +
                ", categoria=" + cat +
                ", descrizione="+label+
                '}';
    }

    public Articolo InserisciArticolo(){
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articolo articolo = (Articolo) o;
        /*return Double.compare(articolo.prezzo, prezzo) == 0 &&
                Objects.equals(seriale, articolo.seriale) &&
                Objects.equals(cat, articolo.cat);*/
        return Objects.equals(this.getSeriale(),articolo.getSeriale());
    }


    @Override
    public int hashCode() {

        return Objects.hash(seriale);
    }
}


