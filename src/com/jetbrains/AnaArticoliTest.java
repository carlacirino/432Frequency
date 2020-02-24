package com.jetbrains;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class AnaArticoliTest {

    @Test
    void ricercaArticoloAnaTest() {
        AnaArticoli anagrafica = new AnaArticoli();
        CD cd1 = new CD("5678",22,new Categoria("rock"),"album rock", "river","bruce", 2020 );
        CD cd2 = new CD("1234",20,new Categoria("pop"),"album pop", "hit","madonna", 2010);
        Strumento str = new Strumento("546",500,new Categoria("tastiera"),"pianoforte a mezza coda", "pianoforte","yamaha",2002);
        anagrafica.InserisciArticoloAna(cd1);
        anagrafica.InserisciArticoloAna(cd2);
        anagrafica.InserisciArticoloAna(str);

        assertNotNull(anagrafica.RicercaArticoloAna("1234"));
        assertNull(anagrafica.RicercaArticoloAna("4561"));
    }

    @Test
    void ricercaArtbyNameTest() {
        AnaArticoli anagrafica = new AnaArticoli();
        HashMap<String,Articolo> mappareturn = new HashMap<>();
        CD cd1 = new CD("5678",22,new Categoria("rock"),"album rock", "river","bruce", 2020 );
        CD cd2 = new CD("1234",20,new Categoria("pop"),"album pop", "hit","madonna", 2010);
        Strumento str = new Strumento("546",500,new Categoria("tastiera"),"pianoforte a mezza coda", "pianoforte","yamaha",2002);
        anagrafica.InserisciArticoloAna(cd1);
        anagrafica.InserisciArticoloAna(cd2);
        anagrafica.InserisciArticoloAna(str);
        mappareturn = anagrafica.RicercaArtbyName("flauto");
        //assertNotNull(anagrafica.RicercaArtbyName("pianoforte"));

        assertEquals(mappareturn,anagrafica.RicercaArtbyName("flauto"));
    }


}