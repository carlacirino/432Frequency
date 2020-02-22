package com.jetbrains;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Fornitore implements Serializable {
    private String nomeSocieta;
    private String indirizzo;
    private String p_iva;

    public Fornitore() {
    }

    public Fornitore(String nomeSocieta, String indirizzo, String p_iva) {
        this.nomeSocieta = nomeSocieta;
        this.indirizzo = indirizzo;
        this.p_iva = p_iva;
    }

    public String getNomeSocieta() {
        return nomeSocieta;
    }

    public void setNomeSocieta(String nomeSocieta) {
        this.nomeSocieta = nomeSocieta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getP_iva() {
        return p_iva;
    }

    public void setP_iva(String p_iva) {
        this.p_iva = p_iva;
    }

    @Override
    public boolean equals(Object o) {
 /*       if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;*/
        Fornitore fornitore = (Fornitore) o;
        return /*Objects.equals(nomeSocieta, fornitore.nomeSocieta) &&
                Objects.equals(indirizzo, fornitore.indirizzo) &&*/
                Objects.equals(this.getP_iva(), fornitore.getP_iva());
    }

    @Override
    public int hashCode() {

        return Objects.hash(nomeSocieta, indirizzo, p_iva);
    }

    public Fornitore InserisciF() {
        Fornitore forn= new Fornitore();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNome società: ");
        forn.setNomeSocieta(sc.nextLine());
        System.out.print("\nIndirizzo: ");
        forn.setIndirizzo(sc.nextLine());
        System.out.print("\nPartita IVA: ");
        forn.setP_iva(sc.nextLine());

        return forn;
    }

    @Override
    public String toString() {
        return "Fornitore{" +
                "nomeSocieta='" + nomeSocieta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", p_iva='" + p_iva + '\'' +
                '}'+"\n";
    }
}
