package com.jetbrains;

import java.rmi.RemoteException;
import java.util.*;

public class GestionaleaAdmin {
    private static Store432Frequency sistema;

    public GestionaleaAdmin() {
    }


    public static void main(String args[]) throws RemoteException {
        String k = "";
        sistema = sistema.getInstance();

        sistema.caricaArtFile();
        sistema.caricaMagFile();
        sistema.caricaClientiFile();
        sistema.caricaOrdCliFile();
        sistema.caricaFornitoriFile();
        sistema.caricaOrdFornFile();
        sistema.caricaAgevolazioniFile();
        Amministratore admin = new Amministratore("admin","1234");


        System.out.println("\t\t\t******************************");
        System.out.println("\t\t\t******  432  FREQUENCY  ******");
        System.out.println("\t\t\t******      store       ******");
        System.out.println("\t\t\t******************************");
        System.out.println("\n\n");

        int scelta;
        int scelta_int;
        int sc;
        int sc1;
        int scelta_int1;

        do{
            System.out.print("1)Gestionale Store\n" +
                             "2)E-commerce Store\n" +
                             "0)Esci\n> ");
            Scanner input = new Scanner(System.in);
            sc = input.nextInt();
            switch(sc) {
                case 0:
                    sistema.SalvaAnaArtFile();
                    sistema.SalvaMagFile();
                    sistema.SalvaClientiFile();
                    sistema.SalvaFornitoriFile();
                    sistema.salvaOrdCliFile();
                    sistema.salvaOrdFornFile();
                    sistema.salvaAgevolazioniFile();
                    break;

                case 1:
                    //LOGIN ADMIN
                    Scanner inadmin = new Scanner(System.in);
                    String sadmin;
                    String padmin;
                    System.out.println("Inserisci username");
                    sadmin = inadmin.nextLine();
                    System.out.println("Inserisci password");
                    padmin = inadmin.nextLine();
                    if (sistema.LoginAdmin(sadmin, padmin, admin)) {

                    do {
                        //PORTALE GESTIONALE ADMIN
                        System.out.print("1)Gestisci Anagrafica Articoli\n" + //UC1
                                "2)Gestisci Magazzino\n" + //UC3
                                "3)Gestisci Fornitori\n" + //UC4
                                "4)Gestisci Clienti\n" + //UC6
                                "5)Effettua ordine verso un fornitore\n" + //UC5
                                "6)Visualizza Articoli Ordinati\n" + //UC2
                                "7)Gestisci Agevolazioni\n" + //UC7
                                "0)Esci\n> ");
                        input = new Scanner(System.in);
                        String s = input.nextLine();
                        scelta = Integer.valueOf(s);
                        switch (scelta) {
                            case 0:
                                break;

                            case 1: //GESTISCI ANAGRAFICA ARTICOLI

                                do {
                                    System.out.print("\n1)Visualizza Anagrafica Articoli\n" +
                                                     "2)Inserisci Articolo\n" +
                                                     "3)Ricerca Articolo\n" +
                                                     "4)Modifica Articolo\n" +
                                                     "5)Elimina Articolo\n" +
                                                     "0)Esci\n>");
                                    s = input.nextLine();
                                    scelta_int = Integer.valueOf(s);
                                    switch (scelta_int) {
                                        case 0:
                                            break;

                                        case 1:
                                            sistema.VisualizzaAna(); //in tali metodi sono presenti gli input per l'inserimento
                                            break;

                                        case 2:
                                            sistema.InserisciArticoloAnagrafica();
                                            break;

                                        case 3:
                                            sistema.RicercaArticoloAnagrafica();
                                            break;

                                        case 4:
                                            sistema.ModificaArticoloAnagrafica();
                                            break;

                                        case 5:
                                            sistema.EliminaArticoloAnagrafica();
                                            break;
                                    }
                                } while (scelta_int != 0);
                                break;

                            case 2: //GESTISCI MAGAZZINO
                                do {
                                    System.out.print("1)Visualizza Magazzino\n" +
                                            "2)Carica Articolo\n" +
                                            "3)Scarica Articolo\n" +
                                            "4)Visualizza Articoli in giacenza minima\n" +
                                            "0)Esci\n>");
                                    Scanner ch1 = new Scanner(System.in);
                                    scelta_int = ch1.nextInt();
                                    switch (scelta_int) {
                                        case 0:
                                            break;

                                        case 1:
                                            sistema.VisualizzaMagazzino();
                                            break;

                                        case 2:
                                            sistema.CaricaMagazzino();
                                            break;

                                        case 3:
                                            sistema.ScaricaMagazzino();
                                            break;

                                        case 4:
                                            System.out.println(sistema.GiacenzaMinima());
                                            break;

                                    }
                                } while (scelta_int != 0);
                                break;

                            case 3: //GESTISCI FORNITORE

                                do {
                                    System.out.print("1)Visualizza Lista Fornitori\n" +
                                            "2)Inserisci Fornitore\n" +
                                            "3)Ricerca Fornitore\n" +
                                            "4)Modifica Fornitore\n" +
                                            "5)Elimina Fornitore\n" +
                                            "0)Esci\n>");
                                    s = input.nextLine();
                                    scelta_int = Integer.valueOf(s);
                                    switch (scelta_int) {
                                        case 0:
                                            break;

                                        case 1:
                                            sistema.VisualizzaFornitori();
                                            break;

                                        case 2:
                                            sistema.InserisciFornitore();
                                            break;

                                        case 3:
                                            sistema.RicercaFornitore();
                                            break;

                                        case 4:
                                            sistema.ModificaFornitore();
                                            break;


                                        case 5:
                                            sistema.EliminaFornitore();
                                            break;
                                    }
                                } while (scelta_int != 0);
                                break;

                            case 4: //GESTISCI CLIENTE
                                do {
                                    System.out.print("1)Visualizza Lista Clienti\n" +
                                            "2)Inserisci Cliente\n" +
                                            "3)Ricerca Cliente\n" +
                                            "4)Modifica Cliente\n" +
                                            "5)Elimina Cliente\n" +
                                            "0)Esci\n>");
                                    s = input.nextLine();
                                    scelta_int = Integer.valueOf(s);
                                    switch (scelta_int) {
                                        case 0:
                                            break;

                                        case 1:
                                            sistema.VisualizzaClienti();
                                            break;

                                        case 2:
                                            sistema.InserisciCliente();
                                            break;

                                        case 3:
                                            sistema.RicercaCliente();
                                            break;

                                        case 4:
                                            sistema.ModificaCli();
                                            break;


                                        case 5:

                                            if (sistema.getListaclienti().isEmpty())
                                                System.out.println("Lista clienti vuota. Impossibile effettuare una eliminazione\n");
                                            else {
                                                Cliente cl = new Cliente();
                                                System.out.println(sistema.getListaclienti().toString() + "\n");
                                                System.out.println("Inserisci codice fiscale del cliente da eliminare\n");
                                                System.out.println(">");
                                                Scanner cf = new Scanner(System.in);
                                                cl.setCf(cf.nextLine());
                                                System.out.println(sistema.Eliminacliente(cl));

                                            }
                                            break;
                                    }
                                } while (scelta_int != 0);


                                break;

                            case 5:
                                /////EFFETTUA ORDINE FORNITORE
                                Scanner in = new Scanner(System.in);
                                System.out.println("Inserisci il nome società del fornitore verso cui effettuare un ordine\n");
                                String nomesoc = in.nextLine();
                                Fornitore f = sistema.RicercaFornOrdine(nomesoc);

                                    if (f == null) {
                                        System.out.println("Partita IVA non trovata\n");
                                    } else {
                                        Ordine ordine = sistema.creaOrdine();
                                        int uscita;
                                        Scanner i = new Scanner(System.in);
                                        do{
                                            System.out.println("\n1)Inserisci articolo\n"+
                                                                 "0)Concludi ordine\n>");
                                            uscita = i.nextInt();
                                            switch (uscita){
                                                case 0:
                                                    sistema.ConcludiOrdine(ordine,f);
                                                    break;

                                                case 1:
                                                    ordine = sistema.inserisciArtOrdine(ordine);
                                                    break;
                                            }

                                        }while(uscita!=0);

                                    }
                                break;

                            case 6:
                                //VISUALIZZA ARTICOLI ACQUISTI E VENDITE
                                sistema.VisualizzaAna();
                                System.out.println("\nInserisci seriale dell'articolo di cui vuoi visualizzare acquisti e vendite:\n");
                                Scanner inseriale = new Scanner(System.in);
                                String seriale = inseriale.nextLine();
                                Articolo a = sistema.getAnagrafica().RicercaArticoloAna(seriale);
                                if (a != null) {
                                    sistema.StampaAcquisti(a);
                                    sistema.StampaVendite(a);
                                } else {
                                    System.out.println("Seriale non presente\n");
                                }
                                break;

                            case 7:
                                //GESTISCI AGEVOLAZIONE
                                Scanner inag = new Scanner(System.in);
                                int ag;
                                do{
                                    System.out.println("1)Visualizza agevolazioni presenti\n"+
                                                       "2)Inserisci agevolazione\n"+
                                                       "3)Modifica agevolazione\n"+
                                                       "4)Elimina agevolazione\n"+
                                                       "5)Ricerca agevolazione\n"+
                                                       "0)Esci\n>");
                                    ag = inag.nextInt();
                                    switch (ag){
                                        case 0:
                                            break;

                                        case 1:
                                            sistema.StampaAgevolazioni();
                                            break;

                                        case 2:
                                            //INSERISCI AGEVOLAZIONE
                                            Scanner ag1 = new Scanner(System.in);
                                            Scanner ag2 = new Scanner(System.in);
                                            Scanner ag3 = new Scanner(System.in);
                                            String desc;

                                            Agevolazione agin = new Agevolazione();
                                            System.out.println("Inserisci numero identificativo agevolazione:\n");
                                            int agnum = ag1.nextInt();
                                            if (sistema.RicercaAgbykey(agnum)==null){
                                                System.out.println("Inserisci descrizione:\n");
                                                desc = ag2.nextLine();
                                                agin.setDescrizione(desc);
                                                System.out.println("Inserisci sconto:\n");
                                                int agsconto = ag3.nextInt();
                                                agin.setDescrizione(desc);
                                                agin.setSconto(agsconto);
                                                sistema.InserisciAgevolazione(agnum,agin);
                                            }
                                            else{
                                                System.out.println("Agevolazione già presente\n");
                                            };


                                            break;

                                        case 3:
                                            //MODIFICA AGEVOLAZIONE
                                            Scanner ag5 = new Scanner(System.in);
                                            Scanner ag6 = new Scanner(System.in);
                                            Scanner ag7 = new Scanner(System.in);
                                            sistema.StampaAgevolazioni();
                                            System.out.println("Inserisci chiave dell'agevolazione da modificare:\n");
                                            int k2 = ag5.nextInt();
                                            sistema.ModificaAgevolazione(k2);
                                            break;

                                        case 4:
                                            Scanner ag4 = new Scanner(System.in);
                                            //ELIMINA AGEVOLAZIONE
                                            System.out.println("Inserisci chiave dell'agevolazione da eliminare:\n");
                                            int k1 = ag4.nextInt();
                                            sistema.EliminaAgevolazione(k1);

                                            break;

                                        case 5:
                                            //RICERCA AGEVOLAZIONE
                                            ag3 = new Scanner(System.in);
                                            System.out.println("Inserisci descrizione dell'agevolazione da ricercare:\n");
                                            desc = ag3.nextLine();
                                            if(sistema.RicercaAgbyDesc(desc).isEmpty()){
                                                System.out.println("Agevolazione non presente\n");
                                            }
                                            else
                                            System.out.println(sistema.RicercaAgbyDesc(desc));

                                            break;


                                    }

                                }while(ag!=0);
                                break;


                        }

                    } while (scelta != 0);
            }
            else
                System.out.println("Username e/o password non corretti\n");

                    break;

                case 2://E COMMERCE
                    int sceltacliente;
                    Scanner incliente = new Scanner(System.in);
                    //LOGIN CLIENTE
                    do{
                        System.out.println("1)Registrazione\n"+
                                           "2)Login cliente\n" +
                                           "0)Esci\n>");
                       sceltacliente = incliente.nextInt();
                       switch (sceltacliente){
                           case 0:
                               break;

                           case 1:
                               //REGISTRAZIONE
                               Scanner inreg = new Scanner(System.in);
                               int reg;
                               System.out.println("1)Registrazione Studente\n" +
                                                    "2)Registrazione Docente\n"+
                                                    "3)Registrazione utente\n>");
                               reg = inreg.nextInt();
                               switch (reg){
                                   case 1:
                                       sistema.InserisciCliente();
                                       sistema.getListaclienti().getLast().setId(1);
                                       
                                       break;

                                   case 2:
                                       sistema.InserisciCliente();
                                       sistema.getListaclienti().getLast().setId(2);
                                       break;

                                   case 3:
                                       sistema.InserisciCliente();
                                       sistema.getListaclienti().getLast().setId(0);
                                       break;

                               }


                               break;

                           case 2:
                               //LOGIN CLIENTE
                               Scanner incliente1 = new Scanner(System.in);
                               String scliente;
                               String pcliente;
                               System.out.println("Inserisci username");
                               scliente = incliente1.nextLine();
                               System.out.println("Inserisci password");
                               pcliente = incliente1.nextLine();

                               if(sistema.LoginCliente(scliente,pcliente)){
                                   //tutto l'ecommerce dopo login con successo
                                   //Cliente cliente = sistema.RicercaClientebynamepw(scliente,pcliente);
                                   do {
                                       System.out.print("1)Visualizza Catalogo\n" +
                                               "2)Effettua ordine\n" +
                                               "3)Gestisci carrello\n" +
                                               "4)Visualizza storico ordini\n" +
                                               "0)Logout\n>");
                                       scelta_int = input.nextInt();
                                       switch (scelta_int) {
                                           case 0:
                                               break;

                                           case 1: //VISUALIZZA CATALOGO
                                               do {
                                                   System.out.print("Ricerca per:\n" +
                                                                    "1)Descrizione prodotto\n" +
                                                                    "2)Categoria prodotto\n" +
                                                                    "3)Prezzo\n" +
                                                                    "0)Esci\n>");
                                                   scelta_int1 = input.nextInt();
                                                   switch (scelta_int1) {
                                                       case 0:
                                                           break;

                                                       case 1:
                                                           System.out.print("\nInserisci descrizione: ");
                                                           Scanner i1 = new Scanner(System.in);
                                                           String desc = i1.nextLine();
                                                           HashMap<Articolo, Giacenza> catalogo1 = sistema.StampaCatalogobydesc(desc);
                                                           if (catalogo1.isEmpty()) {
                                                               System.out.println("\nNon sono presenti articoli che soddisfano la tua ricerca");
                                                           } else
                                                               System.out.println(catalogo1);
                                                           break;

                                                       case 2:
                                                           System.out.print("\nInserisci categoria: ");
                                                           Scanner i2 = new Scanner(System.in);
                                                           String cat = i2.nextLine();
                                                           HashMap<Articolo, Giacenza> catalogo2 = sistema.StampaCatalogobycat(cat);
                                                           if (catalogo2.isEmpty()) {
                                                               System.out.println("\nNon sono presenti articoli che soddisfano la tua ricerca");
                                                           } else
                                                               System.out.println(catalogo2);

                                                           break;

                                                       case 3:
                                                           System.out.print("\nInserisci prezzo massimo dell'articolo: ");
                                                           Scanner i3 = new Scanner(System.in);
                                                           double prezzo = i3.nextDouble();
                                                           HashMap<Articolo, Giacenza> catalogo3 = sistema.StampaCatalogobyprice(prezzo);
                                                           if (catalogo3.isEmpty()) {
                                                               System.out.println("\nNon sono presenti articoli che soddisfano la tua ricerca");
                                                           } else
                                                               System.out.println(catalogo3);
                                                           break;
                                                   }
                                               } while (scelta_int1 != 0);

                                               break;

                                           case 2:
                                               ////EFFETTUA ORDINE CLIENTE/////
                                               Ordine ordine;
                                               LinkedList<Ordine> listord;
                                               Scanner in2 = new Scanner(System.in);
                                               int conferma;
                                               if (sistema.RicercaClientebynamepw(scliente,pcliente).getCarrello().getCarrello().isEmpty()) {
                                                   System.out.println("\nImpossibile effettuare un ordine. Carrello vuoto\n ");

                                               } else {
                                                   double stampaprezzo = sistema.calcolaTotaleScontato(scliente, pcliente);
                                                   System.out.println("Il tuo ordine è di: ");

                                                   System.out.println(stampaprezzo);

                                                   do {


                                                       System.out.println("\nConfermi di procedere con l'ordine?\n" +
                                                                          "1)Conferma\n" +
                                                                          "2)Annulla\n>");
                                                       conferma = in2.nextInt();
                                                       switch (conferma) {
                                                           case 1:
                                                               sistema.concludiOrdineCliente(scliente,pcliente);

                                                               break;

                                                           case 2:
                                                               System.out.println("\nOrdine annullato\n");

                                                               break;
                                                       }
                                                   } while (conferma < 1 || conferma > 2);
                                               }
                                               break;

                                           case 3: //GESTISCI CARRELLO
                                               do {
                                                   System.out.print("1)Visualizza carrello\n" +
                                                           "2)Inserisci articolo nel carrello\n" +
                                                           "3)Svuota carrello\n" +
                                                           "4)Rimuovi articolo dal carrello\n" +
                                                           "5)Modifica quantità articolo\n" +
                                                           "0)Esci\n>");
                                                   sc1 = input.nextInt();
                                                   Scanner i2 = new Scanner(System.in);
                                                   ;
                                                   String seriale;
                                                   switch (sc1) {
                                                       case 0:
                                                           break;

                                                       case 1:
                                                           //VISUALIZZA CARRELLO
                                                           sistema.RicercaClientebynamepw(scliente,pcliente).getCarrello().stampaCarrello();

                                                          double prezzo_new = sistema.calcolaTotaleScontato(scliente,pcliente);
                                                           System.out.println("Il tuo carrello, a seguito dell'agevolazione è:\n");

                                                           System.out.println(prezzo_new);

                                                           break;

                                                       case 2:
                                                           //INSERISCI ARTICOLO CARRELLO
                                                           sistema.VisualizzaMagazzino();
                                                           System.out.println("Inserisci seriale dell'articolo da inserire nel carrello\n");
                                                           seriale = i2.nextLine();
                                                           Articolo a = sistema.RicercaInMag(seriale);
                                                           if (a != null) {
                                                               System.out.println("Inserisci quantità dell'articolo da inserire nel carrello\n");
                                                               int quantita = i2.nextInt();
                                                               sistema.RicercaClientebynamepw(scliente,pcliente).getCarrello().InserisciArtCarrello(a, quantita);
                                                           }
                                                           break;

                                                       case 3:
                                                           sistema.RicercaClientebynamepw(scliente,pcliente).getCarrello().SvuotaCarrello();
                                                           break;

                                                       case 4:
                                                           sistema.RicercaClientebynamepw(scliente,pcliente).getCarrello().stampaCarrello();
                                                           System.out.println("Inserisci seriale dell'articolo da voler eliminare dal carrello\n");
                                                           i2 = new Scanner(System.in);
                                                           seriale = i2.nextLine();
                                                           sistema.RicercaClientebynamepw(scliente,pcliente).getCarrello().rimuoviDalCarrello(seriale);
                                                           break;

                                                       case 5:
                                                           sistema.RicercaClientebynamepw(scliente,pcliente).getCarrello().stampaCarrello();
                                                           System.out.println("Inserisci seriale dell'articolo di cui voler modificare la quantità\n");
                                                           i2 = new Scanner(System.in);
                                                           seriale = i2.nextLine();
                                                           sistema.RicercaClientebynamepw(scliente,pcliente).getCarrello().modificaQArticolo(seriale);
                                                           break;

                                                   }

                                               } while (sc1 != 0);
                                               break;


                                           case 4: //VISUALIZZA STORICO ORDINI
                                               sistema.VisualizzaOrdini(scliente,pcliente);
                                               break;


                                       }
                                   } while (scelta_int != 0);


                               }

                               else
                                   System.out.println("Username e/o password non corretti\n");




                               break;

                       }

                    }while(sceltacliente!=0);


                                break;
                    }
        }while (sc!= 0);
    }
}

