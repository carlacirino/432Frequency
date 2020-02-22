package com.jetbrains;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    private String nome;
    private String cognome;
    private String indirizzo;
    private String cf;
    private String username;
    private String password;
    private Carrello carrello;
    private int id;

    public Cliente(){
        carrello = new Carrello();
    }

    public Cliente(String nome, String cognome, String indirizzo, String cf, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.cf = cf;
        this.username = username;
        this.password = password;
        carrello = new Carrello();
    }

    public Cliente(String cf) {
        this.cf = cf;
    }

    public Cliente(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", cf='" + cf + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ID: "+id+
                '}'+ "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cf, cliente.cf);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cf);
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //carrelloù



}
