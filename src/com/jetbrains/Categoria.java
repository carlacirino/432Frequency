package com.jetbrains;

import java.io.Serializable;

public class Categoria implements Serializable {
    private String descrizione;


    public Categoria(String descrizione) {
        this.descrizione = descrizione;
    }

    public Categoria() {
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return
                descrizione + " ";
    }
}
