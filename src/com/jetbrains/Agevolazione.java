package com.jetbrains;

import java.io.Serializable;
import java.util.Objects;

public class Agevolazione implements Serializable {
    private String descrizione;
    private int sconto;



    public Agevolazione() {
    }


    public Agevolazione(String descrizione, int sconto) {
        this.descrizione = descrizione;
        this.sconto = sconto;
    }


    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agevolazione that = (Agevolazione) o;
        return sconto == that.sconto &&
                Objects.equals(descrizione, that.descrizione);
    }

    @Override
    public int hashCode() {

        return Objects.hash(descrizione, sconto);
    }

    @Override
    public String toString() {
        return
                "descrizione: " + descrizione +
                ", sconto: " + sconto + "%\n";
    }
}
