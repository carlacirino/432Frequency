package com.jetbrains;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class CD extends Articolo implements Serializable {
    private String titolo;
    private String artista;
    private int anno;
    private char euro = '\u20ac';

    public CD(){
    }

    public CD(String titolo, String artista, int anno) {
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(String seriale, double prezzo, String titolo, String artista, int anno) {
        super(seriale, prezzo);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(String seriale, String titolo, String artista, int anno) {
        super(seriale);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(double prezzo, String titolo, String artista, int anno) {
        super(prezzo);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(String seriale, double prezzo, Categoria cat, String titolo, String artista, int anno) {
        super(seriale, prezzo, cat);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(Categoria cat, String titolo, String artista, int anno) {
        super(cat);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(String seriale, double prezzo, Categoria cat, String label, String titolo, String artista, int anno) {
        super(seriale, prezzo, cat, label);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

  /*  public CD(String titolo, String artista, int anno) {
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(String seriale, double prezzo, String titolo, String artista, int anno) {
        super(seriale, prezzo);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(String seriale, String titolo, String artista, int anno) {
        super(seriale);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(double prezzo, String titolo, String artista, int anno) {
        super(prezzo);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(String seriale, double prezzo, Categoria cat, String titolo, String artista, int anno) {
        super(seriale, prezzo, cat);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(Categoria cat, String titolo, String artista, int anno) {
        super(cat);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
    }

    public CD(String titolo) {
        this.titolo = titolo;
    }

    public CD(String titolo, String artista, int anno, char euro) {
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
        this.euro = euro;
    }

    public CD(String seriale, double prezzo, String titolo, String artista, int anno, char euro) {
        super(seriale, prezzo);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
        this.euro = euro;
    }

    public CD(String seriale, String titolo, String artista, int anno, char euro) {
        super(seriale);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
        this.euro = euro;
    }

    public CD(double prezzo, String titolo, String artista, int anno, char euro) {
        super(prezzo);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
        this.euro = euro;
    }

    public CD(String seriale, double prezzo, Categoria cat, String titolo, String artista, int anno, char euro) {
        super(seriale, prezzo, cat);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
        this.euro = euro;
    }

    public CD(Categoria cat, String titolo, String artista, int anno, char euro) {
        super(cat);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
        this.euro = euro;
    }

    public CD(String seriale, double prezzo, Categoria cat, String label, String titolo, String artista, int anno, char euro) {
        super(seriale, prezzo, cat, label);
        this.titolo = titolo;
        this.artista = artista;
        this.anno = anno;
        this.euro = euro;
    }*/

    @Override
    public Categoria getCat() {
        return super.getCat();
    }

    @Override
    public void setCat(Categoria cat) {
        super.setCat(cat);
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(label);
    }

/*
    public CD(String seriale, double prezzo, String titolo) {
        super(seriale, prezzo);
        this.titolo = titolo;
    }

    public CD(String seriale, String titolo) {
        super(seriale);
        this.titolo = titolo;
    }

    public CD(double prezzo, String titolo) {
        super(prezzo);
        this.titolo = titolo;
    }

    public CD(String seriale, double prezzo, Categoria cat, String titolo) {
        super(seriale, prezzo, cat);
        this.titolo = titolo;
    }

    public CD(Categoria cat, String titolo) {
        super(cat);
        this.titolo = titolo;
    }
*/

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "CD: "+ super.getSeriale()+ ", "+
                "titolo: " + titolo + ", "+
                "artista: " + artista + ", " +
                "categoria: "+super.getCat()+ ", "+
                "anno: " + anno + ", "+
                "prezzo: "+super.getPrezzo()+ euro + ", "+
                "descrizione: "+ super.getLabel()+"\n";
    }

    @Override
    public Articolo InserisciArticolo() {
        CD cd= new CD();
        Categoria cat = new Categoria();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSeriale: ");
        cd.setSeriale(sc.nextLine());
        System.out.print("\nTitolo CD: ");
        cd.setTitolo(sc.nextLine());
        System.out.print("\nArtista: ");
        cd.setArtista(sc.nextLine());
        System.out.print("\nCategoria: ");
        cat.setDescrizione(sc.nextLine());
        cd.setCat(cat);
        System.out.print("\nDescrizione: ");
        cd.setLabel(sc.nextLine());
        System.out.print("\nAnno: ");
        cd.setAnno(sc.nextInt());
        System.out.print("\nPrezzo: ");
        cd.setPrezzo(sc.nextDouble());

        return cd;
    }


    public boolean equals(Object o) {
      if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return Objects.equals(super.getSeriale(),cd.getSeriale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());

    }


}