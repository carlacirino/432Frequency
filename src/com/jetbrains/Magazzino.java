package com.jetbrains;

import java.io.Serializable;
import java.util.HashMap;

public class Magazzino implements Serializable {
    private AnaArticoli a;
    private Giacenza giacenza;
    private HashMap<Articolo, Giacenza> mgz; //hashmap<seriale, giacenza>



    public Magazzino() {
        mgz = new HashMap<>();

    }


    public Magazzino(AnaArticoli a, Giacenza giacenza, HashMap<Articolo, Giacenza> mgz) {
        this.a = a;
        this.giacenza = giacenza;
        this.mgz = mgz;
    }


    public void CaricaMagazzino(Articolo seriale, int gia) {
        if (gia > 0) {
            Giacenza gnew = new Giacenza();
            Giacenza gold = getMgz().get(seriale);
            if (getMgz().containsKey(seriale)) {
                gnew.setGiacenza(gia + gold.getGiacenza());
                getMgz().replace(seriale, gnew);
            } else {
                gnew.setGiacenza(gia);
                getMgz().put(seriale, gnew);
            }
        } else
            System.out.println("Inserire una quantità positiva per caricare in magazzino\n");
    }




    public String ScaricoMagazzino(Articolo seriale, int gia)  {
        Giacenza g=new Giacenza();
        g.setGiacenza(gia);
        getMgz().get(seriale).setGiacenza(getMgz().get(seriale).getGiacenza()-gia);
        return "\nScarico effettuato, giacenza aggiornata\n";
    }

    public Giacenza RicercaArticoloMag(String k)  {
        return mgz.getOrDefault(k, null);
    }

    public AnaArticoli getA() {
        return a;
    }

    public void setA(AnaArticoli a) {
        this.a = a;
    }

    public Giacenza getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(Giacenza giacenza) {
        this.giacenza = giacenza;
    }

    public HashMap<Articolo, Giacenza> getMgz() {
        return mgz;
    }

    public void setMgz(HashMap<Articolo, Giacenza> mgz) {
        this.mgz = mgz;
    }


    @Override
    public String toString() {
        return "Magazzino{" +
                ", giacenza=" + giacenza +
                ", mgz=" + mgz +
                '}';
    }
}


