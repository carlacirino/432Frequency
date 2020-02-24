package com.jetbrains;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MagazzinoTest {

    @Test
    void caricaMagazzinoTest() {
        Magazzino mgz = new Magazzino();
        CD cd = new CD("1234",21,new Categoria("pop"),"album nuovo", "the best of","jovanotti", 2018);
        int quantita = 0;
        mgz.CaricaMagazzino(cd,quantita);
        int expected = 0;
        assertEquals(expected, mgz.getMgz().size(), "Carico non avvenuto in quanto la quantità è nulla");
        //mgz.CaricaMagazzino(str,2);
        //assertEquals(2, mgz.getMgz().get(str).getGiacenza());
        //mgz.CaricaMagazzino(str,4); //non sto caricando un nuovo articolo, ma ne aggiorno solo la giacenza
        //assertEquals(6, mgz.getMgz().get(str).getGiacenza());

    }

    @Test
    void scaricoMagazzino() {
        Magazzino mgz = new Magazzino();
        Strumento str = new Strumento("546",500,new Categoria("tastiera"),"pianoforte a mezza coda", "pianoforte","yamaha",2002);
        CD cd = new CD("1234",21,new Categoria("pop"),"album nuovo", "the best of","jovanotti", 2018);
        int quantita = 2;

        mgz.CaricaMagazzino(cd,3);
        int expected = 0;
        //int gianew = 1;
        //assertEquals(gianew,mgz.getMgz().get(str).getGiacenza(), "Lo scarico è avvenuto correttamente, la giacenza è stata aggiornata");


        int gianew = 2;
        assertEquals(gianew,mgz.getMgz().get(str).getGiacenza(), "Lo scarico è avvenuto correttamente, la giacenza è stata aggiornata");

    }


}