package com.jetbrains;

import java.io.Serializable;

public class Giacenza implements Serializable {
    private int giacenza;


    public Giacenza() {
    }


    public Giacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }





    @Override
    public String toString() {
        return
                "giacenza=" + giacenza
                ;
    }
}
