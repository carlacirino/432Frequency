package com.jetbrains;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarrelloTest {



    @Test
    void inserisciArtCarrello() {
        Carrello cart = new Carrello();
        CD cd = new CD("1234",21,new Categoria("pop"),"album nuovo", "the best of","jovanotti", 2018 );
        CD cd1 = new CD("5678",22,new Categoria("rock"),"album rock", "river","bruce", 2020 );
        CD cd2 = new CD("5678",22,new Categoria("rock"),"album rock", "river","bruce", 2020);

        //double tot = cd.getPrezzo();
        int q2 = 0;
        int q1 = 3;
        int q = 2;

        cart.InserisciArtCarrello(cd2, q2);
        assertEquals(0,cart.getCarrello().size(),"aggiunto un articolo con quantità nulla o negativa");
        cart.InserisciArtCarrello(cd, q);
        cart.InserisciArtCarrello(cd1, q1);
        assertEquals(2,cart.getCarrello().size());
        assertEquals(108,cart.getTotale());
        //assertEquals(42,cart.getTotale());
    }

    @Test
    void ricercaNelCarrello() {
        Carrello c = new Carrello();
        c.InserisciArtCarrello(new CD("1234",21,new Categoria("pop"),"album nuovo", "the best of","jovanotti", 2018),1);


        assertNull(c.ricercaNelCarrello("5678"));
        assertNotNull(c.ricercaNelCarrello("1234"));
        String expected = "1234";
        Assert.assertEquals("e' stato trovato l'articolo con seriale atteso", expected, c.ricercaNelCarrello("1234").getSeriale());

        //Articolo a = null;


    }


    @Test
    void rimuoviDalCarrello() {
        Carrello c = new Carrello();
        c.InserisciArtCarrello(new CD("1234",21,new Categoria("pop"),"album nuovo", "the best of","jovanotti", 2018),1);
        c.rimuoviDalCarrello("4567");
        assertNotNull(c);
        c.rimuoviDalCarrello("1234");



    }

    @Test
    void modificaQArticolo() {
    }
}