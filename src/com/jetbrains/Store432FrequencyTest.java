package com.jetbrains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Store432FrequencyTest {

    private static Store432Frequency sistema;
    private AnaArticoli anagrafica;
    private Cliente cliente;
    private Magazzino mgz;

    Articolo articolo;

    @BeforeEach
    void setup() {
        Store432Frequency sistema = new Store432Frequency();
        sistema.getAnagrafica().getAnagrafica().put("7894", new Strumento("7894", 3000, new Categoria("tastiera"), "tastiera per concerto live", "tastiera", "yamaha", 2010));
        sistema.getAnagrafica().getAnagrafica().put("4561", new CD("4561", 19, new Categoria("album pop"), "primo album di Lewis", "Lewis", "capaldi", 2019));
        sistema.getAnagrafica().getAnagrafica().put("8976", new Strumento("8976", 500, new Categoria("archi"), "violino con accessori", "violino", "yamaha", 2018));
        sistema.getMagazzino().getMgz().put(new CD("1234", 20, new Categoria("album rock"), "album del cantante di the river", "album rock", "springsteen", 2020), new Giacenza(12));
        sistema.getMagazzino().getMgz().put(new Strumento("7894", 3000, new Categoria("tastiera"), "tastiera per concerto live", "tastiera", "yamaha", 2010), new Giacenza(2));
        cliente = new Cliente("carla", "cirino", "piazza calvario", "CRNCRL93A70C351G", "carla.cirino", "dodo");

    }

    @Test
    void inserisciArticoloAnaTest() {
        sistema = sistema.getInstance();
        CD cd = new CD("1234", 21, new Categoria("pop"), "album nuovo", "the best of", "jovanotti", 2018);
        CD cd1 = new CD("1234", 22, new Categoria("pop"), "album nuovo", "the best of", "jovanotti", 2018);
        sistema.InserisciArticoloAna(cd);
        assertEquals(1, sistema.getAnagrafica().getAnagrafica().size());

        sistema.InserisciArticoloAna(cd1);
        assertEquals(1, sistema.getAnagrafica().getAnagrafica().size(), "articolo già presente");

    }
}



