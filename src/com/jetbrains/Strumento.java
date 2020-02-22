package com.jetbrains;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Strumento extends Articolo implements Serializable {
    private String nome;
    private String marca;
    private int anno_prod;
    private char euro = '\u20ac';

    public Strumento(){
    }

    public Strumento(String nome, String marca, int anno_prod) {
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(String seriale, double prezzo, String nome, String marca, int anno_prod) {
        super(seriale, prezzo);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(String seriale, String nome, String marca, int anno_prod) {
        super(seriale);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(double prezzo, String nome, String marca, int anno_prod) {
        super(prezzo);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(String seriale, double prezzo, Categoria cat, String nome, String marca, int anno_prod) {
        super(seriale, prezzo, cat);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(Categoria cat, String nome, String marca, int anno_prod) {
        super(cat);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(String seriale, double prezzo, Categoria cat, String label, String nome, String marca, int anno_prod) {
        super(seriale, prezzo, cat, label);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }



    /*public Strumento(String nome, String marca, int anno_prod) {
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(String seriale, double prezzo, String nome, String marca, int anno_prod) {
        super(seriale, prezzo);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(String seriale, String nome, String marca, int anno_prod) {
        super(seriale);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(double prezzo, String nome, String marca, int anno_prod) {
        super(prezzo);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(String seriale, double prezzo, Categoria cat, String nome, String marca, int anno_prod) {
        super(seriale, prezzo, cat);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }

    public Strumento(Categoria cat, String nome, String marca, int anno_prod) {
        super(cat);
        this.nome = nome;
        this.marca = marca;
        this.anno_prod = anno_prod;
    }*/

    @Override
    public String getLabel() {
        return super.getLabel();
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(label);
    }

    @Override
    public Articolo InserisciArticolo() {
        Strumento str= new Strumento();
        Categoria cat = new Categoria();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSeriale: ");
        str.setSeriale(sc.nextLine());
        System.out.print("\nNome: ");
        str.setNome(sc.nextLine());
        System.out.print("\nMarca: ");
        str.setMarca(sc.nextLine());
        System.out.print("\nCategoria strumento: ");
        cat.setDescrizione(sc.nextLine());
        str.setCat(cat);
        System.out.print("\nDescrizione: ");
        str.setLabel(sc.nextLine());
        System.out.print("\nAnno di produzione: ");
        str.setAnno_prod(sc.nextInt());
        System.out.print("\nPrezzo: ");
        str.setPrezzo(sc.nextDouble());

        return str;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnno_prod() {
        return anno_prod;
    }

    public void setAnno_prod(int anno_prod) {
        this.anno_prod = anno_prod;
    }




    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode());
    }


    @Override
    public String toString() {
        return "Strumento musicale: " +
                 super.getSeriale()+" "+
                "nome: " + nome  +", "+
                "marca: " + marca +", "+
                "categoria: "+ super.getCat()+", "+
                "anno_prod: " + anno_prod+", "+
                "descrizione: "+ super.getLabel()+", "+
                "prezzo: "+super.getPrezzo()+euro+"\n";
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Strumento str = (Strumento) o;
       return Objects.equals(super.getSeriale(),str.getSeriale());
    }
}
