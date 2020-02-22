package com.jetbrains;

import java.io.*;
import java.util.*;

public class Store432Frequency implements Serializable{
    private AnaArticoli anagrafica;
    private Magazzino magazzino;
    private LinkedList<Fornitore> listafornitori;
    private LinkedList<Cliente> listaclienti;
    private LinkedList<Articolo> listagminima;
    private HashMap<Cliente,LinkedList<Ordine>> ordiniclienti;
    private HashMap<Fornitore,LinkedList<Ordine>> ordinifornitori;
    private static Store432Frequency store;

    public HashMap<Integer, Agevolazione> getAgevolazioni() {
        return agevolazioni;
    }

    private HashMap<Integer,Agevolazione> agevolazioni;
    Articolo articolo;

    /*private final Amministratore admin = new Amministratore("admin", "admin");*/

    public HashMap<Cliente, LinkedList<Ordine>> getOrdiniclienti() {
        return ordiniclienti;
    }

    /*public void setOrdiniclienti(HashMap<Cliente, LinkedList<Ordine>> ordiniclienti) {
        this.ordiniclienti = ordiniclienti;
    }*/

    public HashMap<Fornitore, LinkedList<Ordine>> getOrdinifornitori() {
        return ordinifornitori;
    }

    /*public void setOrdinifornitori(HashMap<Fornitore, LinkedList<Ordine>> ordinifornitori) {

        this.ordinifornitori = ordinifornitori;
    }*/


    private static Store432Frequency istance;
    int choice = -1;

    Scanner input = new Scanner(System.in);

    public Store432Frequency() {
        anagrafica = new AnaArticoli();
        magazzino = new Magazzino();
        listafornitori = new LinkedList<>();
        listagminima = new LinkedList<>();
        listaclienti = new LinkedList<>();
        ordiniclienti = new HashMap<>();
        ordinifornitori = new HashMap<>();
        agevolazioni = new HashMap<>();

        /*agevolazioni.put(1,new Agevolazione("sconto per studente",50));
        agevolazioni.put(2, new Agevolazione("sconto per docente", 40));
        agevolazioni.put(0, new Agevolazione("utente normale",0));*/

        //per la seconda iterazione, poi ci sarà autenticazione
        //
        //listaclienti.add(new Cliente("carla","cirino","piazza calvario","CRNCRL93A70C351G","carla.cirino","dodo"));
        //ordiniclienti.put(new Cliente("carla","cirino","piazza calvario","CRNCRL93A70C351G","carla.cirino","dodo"),new LinkedList<>());
        /*anagrafica.getAnagrafica().put("1234",new CD("1234",20,new Categoria("album rock"),"album del cantante di the river","album rock","springsteen",2020));
        anagrafica.getAnagrafica().put("7894", new Strumento("7894",3000, new Categoria("tastiera"),"tastiera per concerto live","tastiera","yamaha",2010));
        anagrafica.getAnagrafica().put("4561",new CD("4561",19,new Categoria("album pop"),"primo album di Lewis","Lewis","capaldi",2019));
        anagrafica.getAnagrafica().put("8976", new Strumento("8976",500, new Categoria("archi"),"violino con accessori","violino","yamaha",2018));
        magazzino.getMgz().put(new CD("1234",20,new Categoria("album rock"),"album del cantante di the river","album rock","springsteen",2020),new Giacenza(12));
        magazzino.getMgz().put(new Strumento("7894",3000, new Categoria("tastiera"),"tastiera per concerto live","tastiera","yamaha",2010),new Giacenza(3));*/

    }


    public static Store432Frequency getInstance(){
        if(store == null){
            store = new Store432Frequency();
        }
        return store;
    }
    public static void setIstance(Store432Frequency istance) {
        Store432Frequency.istance = istance;
    }


    public void VisualizzaAna() {
        if (anagrafica.getAnagrafica().isEmpty()) {
            System.out.println("L'anagrafica articoli è vuota. Provvedi ad inserire almeno un articolo\n");
        } else
            System.out.println(anagrafica.toString());
    }

    public void VisualizzaMagazzino(){

        Iterator it;
        StringBuilder stampa = new StringBuilder();
        if(magazzino.getMgz().isEmpty()){
            System.out.println("Magazzino vuoto");
        }
        else{
            it = magazzino.getMgz().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                stampa.append("Prodotto: ").append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
            System.out.println(stampa.toString());
        }
    }




  public void ModificaFornitore_n(Fornitore f, String namenew){
      //Fornitore forn1 = RicercaFornByIva(p);
      f.setNomeSocieta(namenew);

  }
    public void ModificaFornitore_i(Fornitore f, String indnew){
        //Fornitore forn1 = RicercaFornByIva(p);
        f.setIndirizzo(indnew);

    }
    public void ModificaFornitore_p(Fornitore f, String indnew){
        //Fornitore forn1 = RicercaFornByIva(p);
        f.setP_iva(indnew);
    }

    public void ModificaForn(){
        Scanner ch1 = new Scanner(System.in);
        System.out.println("Inserisci partita IVA: ");
        String seriale = input.nextLine();
                                                /*System.out.println("Inserisci nuova partita IVA: ");
                                                String p_iva = input.nextLine();

                                                sistema.ModificaFornitore(seriale,p_iva);*/
        //sistema.ModificaFornitore(seriale);


        Fornitore forn1 = RicercaFornByIva(seriale);
        if (forn1 == null) {
            System.out.println("Fornitore non trovato\n");
        } else {
            System.out.println(forn1);
            Fornitore fornitore1 = forn1;
            System.out.println("1)Modifica nome Società\n" +
                    "2)Modifica via\n" +
                    "3)Modifica partita IVA\n" +
                    ">");

            choice = ch1.nextInt();
            switch (choice) {
                case 0:
                    break;

                case 1:
                    System.out.println("Inserisci nuovo nome società: ");
                    String s = input.nextLine();

                    fornitore1.setNomeSocieta(s);
                    //sistema.ModificaFornitore_p(fornitore1,s);
                    break;

                case 2:
                    System.out.println("Inserisci nuovo indirizzo: ");
                    s = input.nextLine();

                    //sistema.ModificaFornitore_i(fornitore1,s);
                    fornitore1.setIndirizzo(s);
                    break;

                case 3:
                    System.out.println("Inserisci nuova partita IVA: ");
                    s = input.nextLine();

                    //sistema.ModificaFornitore_p(fornitore1,s);
                    fornitore1.setP_iva(s);
                    break;


            }
            System.out.println("Modifica avvenuta con successo\n");


        }
    }

   /* public void VisualizzaCarrello(){
        getListaclienti().get(0).getCarrello().stampaCarrello();

    }*/
    public void InserisciArticoloAnagrafica(){
      int choice = -1;
      do {
          Scanner ch1 = new Scanner(System.in);
          System.out.print("\nChe articolo vuoi inserire?\n" +
                  "\n1: CD musicale" +
                  "\n2: Strumento musicale" +
                  "\n0: Annulla operazione\n");
          try {
              System.out.print(">");
              choice = ch1.nextInt();
          } catch (InputMismatchException e) {
              System.out.println("\nInput non valido! Inserire un numero compreso tra 0 e 2\n");
          }
          switch (choice) {
              case 0:
                  break;

              case 1:
                  CD cd = new CD();
                  cd = (CD) cd.InserisciArticolo();
                  InserisciArticoloAna(cd);
                  break;

              case 2:
                  Strumento st = new Strumento();
                  st = (Strumento) st.InserisciArticolo();
                  InserisciArticoloAna(st);
                  break;
          }
      } while (choice < 0 || choice > 2);
  }

    public void InserisciArticoloAna(Articolo a)  {
        /*CD cd = new CD();
        cd = (CD) cd.InserisciArticolo();*/
        if(anagrafica.getAnagrafica().containsKey(a.getSeriale())){
            System.out.println("\nArticolo presente in Anagrafica articoli!\n");
            return;
        }
        String key=a.getSeriale();
        anagrafica.getAnagrafica().put(key,a);
        System.out.println("\nArticolo inserito con successo!\n");
    }

    public void RicercaArticoloAnagrafica(){
        if (getAnagrafica().getAnagrafica().isEmpty()) {
            System.out.println("Anagrafica vuota. Impossibile effettuare una ricerca\n");
        } else {
            do {

                Scanner ch1 = new Scanner(System.in);
                System.out.print("\n1)Ricerca per seriale" +
                        "\n2)Ricerca per descrizione" +
                        "\n0)Esci\n" +
                        ">");
                choice = ch1.nextInt();
                switch (choice) {
                    case 0:
                        break;

                    case 1:


                        System.out.print("\nInserisci seriale dell'articolo da ricercare: ");
                        String s = input.nextLine();
                        if (anagrafica.RicercaArticoloAna(s)== null) {
                            System.out.println("Seriale non trovato\n");
                        } else
                            System.out.println(anagrafica.RicercaArticoloAna(s));

                        break;

                    case 2:
                        System.out.print("\nInserisci descrizione dell'articolo da ricercare: ");
                        s = input.nextLine();
                        System.out.println(anagrafica.RicercaArtbyName(s));
                        break;
                }
            } while (choice < 0 || choice > 2);
        }

    }

    public void ModificaArticoloAnagrafica(){
        if (getAnagrafica().getAnagrafica().isEmpty()) {
            System.out.println("Anagrafica vuota. Impossibile effettuare una modifica\n");
        } else {
            do {
                VisualizzaAna();
                Scanner ch1 = new Scanner(System.in);
                System.out.println("1)Modifica per seriale articolo\n" +
                        "0)Annulla modifica\n" +
                        ">");
                choice = ch1.nextInt();
                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        System.out.println("Inserisci seriale: ");
                        //s=input.nextLine();
                        String seriale = input.nextLine();
                        Articolo a = anagrafica.RicercaArticoloAna(seriale);
                        if (a == null) {
                            System.out.println("Seriale non trovato\n");
                        } else {
                            //getAnagrafica().EliminaArticoloAna(seriale);
                            System.out.println(a);
                            if (a instanceof CD) {
                                CD cd = (CD) a;
                                System.out.println("1)Modifica titolo\n" +
                                        "2)Modifica artista\n" +
                                        "3)Modifica anno\n" +
                                        "4)Modifica seriale\n" +
                                        "5)Modifica descrizione\n" +
                                        "6)Modifica prezzo\n" +
                                        "7)Modifica categoria\n" +
                                        "0)Concludi modifica\n" +
                                        ">");

                                choice = ch1.nextInt();
                                switch (choice) {
                                    case 0:
                                        break;

                                    case 1:
                                        System.out.println("Inserisci nuovo titolo: ");
                                        String s = input.nextLine();
                                        cd.setTitolo(s);
                                        break;

                                    case 2:
                                        System.out.println("Inserisci nuovo artista: ");
                                        s = input.nextLine();
                                        cd.setArtista(s);
                                        break;

                                    case 3:
                                        System.out.println("Inserisci nuovo anno: ");
                                        int i = input.nextInt();
                                        cd.setAnno(i);
                                        break;

                                    case 4:
                                        System.out.println("Inserisci nuovo seriale: ");
                                        seriale = input.nextLine();
                                        cd.setSeriale(seriale);
                                        break;

                                    case 5:
                                        System.out.println("Inserisci nuova descrizione: ");
                                        s = input.nextLine();
                                        cd.setLabel(s);
                                        break;

                                    case 6:
                                        System.out.println("Inserisci nuovo prezzo: ");
                                        double p = input.nextDouble();
                                        cd.setPrezzo(p);

                                        break;

                                    case 7:
                                        System.out.println("Inserisci nuova categoria: ");
                                        s = input.nextLine();
                                        cd.getCat().setDescrizione(s);
                                        break;
                                }
                                //getAnagrafica().getAnagrafica().put(seriale, cd);
                                System.out.println(a);
                                //System.out.println("Modifica avvenuta con successo\n");

                            }

                            if (a instanceof Strumento) {
                                Strumento strumento = (Strumento) a;

                                System.out.println("1)Modifica nome\n" +
                                        "2)Modifica marca\n" +
                                        "3)Modifica anno produzione\n" +
                                        "4)Modifica seriale\n" +
                                        "5)Modifica descrizione\n" +
                                        "6)Modifica prezzo\n" +
                                        "7)Modifica categoria\n" +
                                        "0)Annulla modifica\n" +
                                        ">");

                                choice = ch1.nextInt();
                                switch (choice) {
                                    case 0:
                                        break;

                                    case 1:
                                        System.out.println("Inserisci nuovo nome: ");
                                        String s = input.nextLine();
                                        strumento.setNome(s);

                                        break;

                                    case 2:
                                        System.out.println("Inserisci nuova marca: ");
                                        s = input.nextLine();
                                        strumento.setMarca(s);
                                        break;

                                    case 3:
                                        System.out.println("Inserisci nuovo anno produzione: ");
                                        int i = input.nextInt();
                                        strumento.setAnno_prod(i);
                                        break;

                                    case 4:
                                        System.out.println("Inserisci nuovo seriale: ");
                                        seriale = input.nextLine();
                                        strumento.setSeriale(seriale);
                                        break;

                                    case 5:
                                        System.out.println("Inserisci nuova descrizione: ");
                                        s = input.nextLine();
                                        strumento.setLabel(s);
                                        break;

                                    case 6:
                                        System.out.println("Inserisci nuova categoria: ");
                                        s = input.nextLine();
                                        strumento.getCat().setDescrizione(s);
                                        break;

                                    case 7:
                                        System.out.println("Inserisci nuovo prezzo: ");
                                        double p = input.nextDouble();
                                        strumento.setPrezzo(p);
                                        break;
                                }
                                //getAnagrafica().getAnagrafica().put(seriale, strumento);
                                //System.out.println("Modifica avvenuta con successo\n");
                            }

                        }
                        break;

                }
            } while (choice != 0);

        }
    }

    public void EliminaArticoloAnagrafica(){
        if (getAnagrafica().getAnagrafica().isEmpty()) {
            System.out.println("Anagrafica vuota. Impossibile effettuare un'eliminazione\n");
        } else {
            do {
                Scanner ch1 = new Scanner(System.in);
                System.out.print("\n1)Elimina tramite seriale" +
                        "\n2)Elimina per descrizione" +
                        "\n0)Esci\n" +
                        ">");
                choice = ch1.nextInt();
                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        System.out.print("\nInserisci seriale dell'articolo da eliminare: ");
                        String s = input.nextLine();
                        Articolo a = getAnagrafica().RicercaArticoloAna(s);
                        if (a == null) {
                            System.out.println("Seriale non trovato. Impossibile eliminare\n");
                            break;
                        } else {
                            System.out.print("\nConfermi di voler eliminare l'articolo?: ");
                            ch1 = new Scanner(System.in);
                            System.out.print("\n1)Conferma" +
                                    "\n0)Annulla l'eliminazione\n" +
                                    ">");
                            choice = ch1.nextInt();
                            switch (choice) {
                                case 0:
                                    break;

                                case 1:
                                    anagrafica.EliminaArticoloAna(s);
                                    break;
                            }
                        }
                        break;


                    case 2:
                        System.out.print("\nInserisci descrizione dell'articolo da eliminare: ");
                        s = input.nextLine();
                        System.out.println(getAnagrafica().RicercaArtbyName(s));
                        System.out.println("Inserisci il codice dell'articolo da voler eliminare");
                        s = input.nextLine();
                        a = getAnagrafica().RicercaArticoloAna(s);
                        if (a == null) {
                            System.out.println("Seriale non trovato. Impossibile eliminare\n");
                        } else {
                            anagrafica.EliminaArticoloAna(s);
                            break;
                        }

                }

            } while (choice != 0);
        }
    }

    public void InserisciFornitore(){
        Fornitore f = new Fornitore();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNome società: ");
        String nome = sc.nextLine();
        f.setNomeSocieta(nome);
        System.out.print("\nIndirizzo: ");
        String indirizzo = sc.nextLine();
        f.setIndirizzo(indirizzo);
        System.out.print("\nPartita IVA: ");
        String piva = sc.nextLine();
        f.setP_iva(piva);
        System.out.println("1)Conferma inserimento\n"+
                "0)Annulla\n");
        Scanner ch1 = new Scanner(System.in);
        int choice = ch1.nextInt();
        switch (choice) {
            case 0:
                break;

            case 1:
                InserisciFornitore(f);
                break;
        }

    }

    public void InserisciFornitore(Fornitore fornitore) {
        if (listafornitori.contains(fornitore.getP_iva())) {
            System.out.println("Fornitore già presente nel sistema\n");
        }
        else{
            listafornitori.add(fornitore);
            ordinifornitori.put(fornitore,new LinkedList<>());
            //System.out.println(ordinifornitori);
            System.out.println("Inserimento avvenuto con successo\n");
        }

        }

    public void RicercaFornitore(){
        if (getListafornitori().isEmpty())
            System.out.println("Lista fornitori vuota. Impossibile effettuare una ricerca\n");
        else {
            do {
                Scanner ch1 = new Scanner(System.in);
                System.out.print("\n1)Ricerca per nome società" +
                        "\n2)Ricerca per partita iva" +
                        "\n0)Esci\n" +
                        ">");
                choice = ch1.nextInt();
                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        System.out.print("\nInserisci nome società del fornitore da ricercare: ");
                        Fornitore fornit1 = new Fornitore();
                        LinkedList<Fornitore> listafor = new LinkedList<>();
                        System.out.println(">");
                        Scanner sc = new Scanner(System.in);
                        fornit1.setNomeSocieta(sc.nextLine());
                        if(RicercaFornByName(fornit1)==null){
                            System.out.println("Fornitore non trovato\n");
                        }
                        else {
                            listafor = RicercaFornByName(fornit1);
                            Iterator it = listafor.iterator();
                            while(it.hasNext()){
                                Fornitore f = (Fornitore)it.next();
                                System.out.println(f);
                                System.out.println(getOrdinifornitori().get(f));

                            }
                        }
                        break;

                    case 2:
                        System.out.print("\nInserisci partita IVA del fornitore da ricercare: ");
                        System.out.println(">");
                        sc = new Scanner(System.in);
                        String seriale = sc.nextLine();
                        //fornit2.setP_iva(sc.nextLine());
                        if(RicercaFornByIva(seriale)==null){
                            System.out.println("Fornitore non presente");
                        }
                        else {
                            System.out.println(RicercaFornByIva(seriale));
                            System.out.println(getOrdinifornitori().get(RicercaFornByIva(seriale)));
                        }
                        break;
                }
            } while (choice < 0 || choice > 2);


        }
    }

    public LinkedList<Fornitore> RicercaFornByName(Fornitore f) {
        LinkedList<Fornitore> listaret = new LinkedList<>();
        Iterator it = listafornitori.iterator();
        while (it.hasNext()) {
            Fornitore tmp = (Fornitore) it.next();
            if (tmp.getNomeSocieta().equalsIgnoreCase(f.getNomeSocieta())) {
                listaret.add(tmp);
            }

        }
        return listaret;
    }

    public Fornitore RicercaFornByIva(String seriale) {

/*        Fornitore frit = new Fornitore();
        for (Object aListaFornitori : listafornitori){
            Fornitore confronto = (Fornitore)aListaFornitori;
            if((confronto.getP_iva()).equalsIgnoreCase(seriale)){
                frit= confronto;
                break;
            }
            else frit = null;
        }
        return frit;*/
        Iterator it = listafornitori.iterator();
        while (it.hasNext()) {
            Fornitore tmp = (Fornitore) it.next();
            if (tmp.getP_iva().equalsIgnoreCase(seriale)) {
                return tmp;

            }

        }
        return null;
    }

    public void ModificaFornitore(){
        if (getListafornitori().isEmpty())
            System.out.println("Lista fornitori vuota. Impossibile effettuare una modifica\n");
        else {
            do {
                Scanner ch1 = new Scanner(System.in);
                System.out.println("1)Modifica per partita IVA \n" +
                        "0)Concludi modifica\n" +
                        ">");
                choice = ch1.nextInt();
                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        ModificaForn();

                }
            } while (choice != 0);

        }
    }

    public void EliminaFornitore(){
        if (getListafornitori().isEmpty())
            System.out.println("Lista fornitori vuota. Impossibile effettuare una eliminazione\n");
        else {

            Fornitore fornit = new Fornitore();
            System.out.println(getListafornitori().toString() + "\n");
            System.out.println("Inserisci partita IVA del fornitore da eliminare\n");
            System.out.println(">");
            Scanner sc = new Scanner(System.in);
            fornit.setP_iva(sc.nextLine());
            System.out.println(EliminaFornitore(fornit));

        }
    }

    public String EliminaFornitore(Fornitore f)  {
        for (Object aListaFornitori : listafornitori) {
            Fornitore confronto = (Fornitore) aListaFornitori;
            if ((confronto.getP_iva().equalsIgnoreCase(f.getP_iva()))) {
                listafornitori.remove(confronto);
                return "\nFornitore rimosso correttamente\n";
            }
        }
        return "\nImpossibile trovare il fornitore\n";
    }


    public void VisualizzaClienti(){
        if (listaclienti.isEmpty())
            System.out.println("Lista clienti vuota\n");
        else {
            System.out.println(getListaclienti().toString() + "\n");
        }
    }

    public void InserisciCliente(){
        Cliente c = new Cliente();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNome: ");
        String nome = sc.nextLine();
        c.setNome(nome);
        System.out.print("\nCognome: ");
        String cognome = sc.nextLine();
        c.setCognome(cognome);
        System.out.print("\nIndirizzo: ");
        String indirizzo = sc.nextLine();
        c.setIndirizzo(indirizzo);
        System.out.print("\nCodice fiscale: ");
        String cf = sc.nextLine();
        c.setCf(cf);
        System.out.print("\nUsername: ");
        String uname = sc.nextLine();
        c.setUsername(uname);
        System.out.print("\nPassword: ");
        String pw = sc.nextLine();
        c.setPassword(pw);
        c.setId(3);
        System.out.println("1)Conferma inserimento\n"+
                "0)Annulla\n");
        Scanner ch1 = new Scanner(System.in);
        int choice = ch1.nextInt();
        switch (choice) {
            case 0:
                break;

            case 1:
                InserisciCliente(c);
                break;
        }

    }

    public void InserisciCliente(Cliente cli){

        //Cliente tmp = RicercaClienteByCF(cli.getCf());
        if (listaclienti.contains(cli)) {
            System.out.println("Cliente già presente nel sistema\n");
        }
        else{
            listaclienti.add(cli);
            ordiniclienti.put(cli,new LinkedList<>());
            //System.out.println(ordiniclienti);
            System.out.println("Inserimento avvenuto con successo\n");
        }
    }

    public void RicercaCliente(){
        if (getListaclienti().isEmpty())
            System.out.println("Lista Clienti vuota. Impossibile effettuare una ricerca\n");
        else {
                Scanner ch1 = new Scanner(System.in);
                System.out.print("\nInserisci codice fiscale del cliente da ricercare: ");
                System.out.println(">");
                Scanner sc = new Scanner(System.in);
                String cf = sc.nextLine();
                if (RicercaClienteByCF(cf) == null) {
                    System.out.println("Cliente non trovato\n");
                } else {
                    System.out.println(RicercaClienteByCF(cf));
                }
            }
        }

    public Cliente RicercaClienteByCF(String cf){
        Iterator it = listaclienti.iterator();
        while (it.hasNext()) {
            Cliente tmp = (Cliente) it.next();
            if (tmp.getCf().equalsIgnoreCase(cf)) {
                return tmp;
            }

        }
        return null;
    }

    public Cliente RicercaClientebynamepw(String uname, String pw){
        Iterator it = listaclienti.iterator();
        while (it.hasNext()) {
            Cliente tmp = (Cliente) it.next();
            if (tmp.getUsername().equalsIgnoreCase(uname) && tmp.getPassword().equals(pw)) {
                return tmp;
            }

        }
        return null;
    }

  /*  public Cliente ricercaCliente(String Username){
        for (Cliente cliente : listaclienti){
            if (cliente.getUsername()
        }
    }*/

    public void ModificaCliente(){
        if (getListaclienti().isEmpty())
            System.out.println("Lista clienti vuota. Impossibile effettuare una modifica\n");
        else {
            do {
                Scanner ch1 = new Scanner(System.in);
                System.out.println("1)Inserisci codice fiscale del cliente da voler modificare \n" +
                        "0)Concludi modifica\n" +
                        ">");
                choice = ch1.nextInt();
                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        ModificaCli();

                }
            } while (choice != 0);

        }
    }


    public void ModificaCli(){
        Scanner ch1 = new Scanner(System.in);
        System.out.println("Inserisci codice fiscale: ");
        String cf = input.nextLine();
        Cliente cl = RicercaClienteByCF(cf);
        if (cl == null) {
            System.out.println("Cliente non trovato\n");
        } else {
            System.out.println(cl);
            Cliente cli = cl;
            System.out.println("1)Modifica nome\n" +
                    "2)Modifica cognome\n" +
                    "3)Modifica indirizzo\n"+
                    "4)Modifica codice fiscale\n"+
                    "5)Modifica username\n"+
                    "6)Modifica password\n" +
                    ">");

            choice = ch1.nextInt();
            switch (choice) {
                case 0:
                    break;

                case 1:
                    System.out.println("Inserisci nuovo nome : ");
                    String s = input.nextLine();

                    cli.setNome(s);
                    //sistema.ModificaFornitore_p(fornitore1,s);
                    break;
                case 2:
                    System.out.println("Inserisci nuovo cognome : ");
                    s = input.nextLine();

                    cli.setNome(s);
                //sistema.ModificaFornitore_p(fornitore1,s);
                    break;
                case 3:
                    System.out.println("Inserisci nuovo indirizzo: ");
                    s = input.nextLine();

                    //sistema.ModificaFornitore_i(fornitore1,s);
                    cli.setIndirizzo(s);
                    break;

                case 4:
                    System.out.println("Inserisci nuovo codice fiscale: ");
                    s = input.nextLine();

                    //sistema.ModificaFornitore_p(fornitore1,s);
                    cli.setCf(s);
                    break;


                case 5:
                    System.out.println("Inserisci nuova username: ");
                    s = input.nextLine();

                    //sistema.ModificaFornitore_p(fornitore1,s);
                    cli.setUsername(s);
                    break;

                case 6:
                    System.out.println("Inserisci nuova password: ");
                    s = input.nextLine();

                    //sistema.ModificaFornitore_p(fornitore1,s);
                    cli.setPassword(s);
                    break;

            }
            System.out.println("Modifica avvenuta con successo\n");


        }
    }

    public String Eliminacliente(Cliente c)  {
        for (Object aListaCliente : listaclienti) {
            Cliente confronto = (Cliente) aListaCliente;
            if ((confronto.getCf().equalsIgnoreCase(c.getCf()))) {
                listaclienti.remove(confronto);
                return "\nCliente rimosso correttamente\n";
            }
        }
        return "\nImpossibile trovare il cliente\n";
    }

    public String GiacenzaMinima() {
        listagminima.clear();
        StringBuilder stampa= new StringBuilder();
        for (Object o : magazzino.getMgz().entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Giacenza giac = (Giacenza) entry.getValue();
            int GM = 3;
            if (giac.getGiacenza() <= GM) {
                listagminima.add(anagrafica.getAnagrafica().get(entry.getKey()));
                stampa.append("Codice: ").append(entry.getKey()).append("; giacenza: ").append(giac.getGiacenza()).append("\n");
            }
        }
        if (listagminima.isEmpty()){
            return "\nNessun articolo in giacenza minima\n";
        }
        return stampa.toString();
    }

    public AnaArticoli getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(AnaArticoli anagrafica) {
        this.anagrafica = anagrafica;
    }

    public void CaricaMagazzino(){
        String s;
        Articolo a;
        Scanner i=new Scanner(System.in);
        if (anagrafica.getAnagrafica().isEmpty()) {
            System.out.println("Anagrafica vuota. Impossibile effettuare carico articolo in magazzino\n");
        } else {
            VisualizzaAna();
            System.out.println("Inserisci seriale dell'articolo da caricare in magazzino: ");
            s = i.nextLine();
            a = anagrafica.RicercaArticoloAna(s);
            if (a == null) {
                System.out.println("Seriale non trovato, impossibile caricare in magazzino\n");
            } else {
                System.out.println(a);
                System.out.println("Qual è la quantità che vuoi caricare in magazzino?");
                int quantita = input.nextInt();
                magazzino.CaricaMagazzino(a, quantita );
                System.out.println("Articolo caricato con successo, giacenza aggiornata\n");
            }
        }
    }

    public void ScaricaMagazzino(){
        Scanner in = new Scanner(System.in);
        if (getMagazzino().getMgz().isEmpty()) {
            System.out.println("Magazzino vuoto. Impossibile effettuare scarico articolo dal magazzino\n");
        } else {
            VisualizzaMagazzino();
            System.out.println("Inserisci seriale dell'articolo da scaricare dal magazzino: ");
            String s = in.nextLine();
            Articolo a = getAnagrafica().RicercaArticoloAna(s);
            if (a == null) {
                System.out.println("Seriale non trovato, impossibile scaricare dal magazzino\n");
            } else {
                System.out.println("Qual è la quantità che vuoi scaricare dal magazzino?\n");
                int quantita = input.nextInt();
                getMagazzino().ScaricoMagazzino(a, quantita);
                System.out.println("Articolo scaricato con successo, giacenza aggiornata\n");
            }
        }

    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }


    public Articolo RicercaInMag(String seriale) {
        Iterator it = magazzino.getMgz().entrySet().iterator();
        Articolo tmp = null;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Articolo a = (Articolo) entry.getKey();
            if (a.getSeriale().equalsIgnoreCase(seriale))
                tmp = a;
        }
        if(tmp ==null){
            System.out.println("Articolo non presente\n");
        }
        return tmp;
    }

    public HashMap<Articolo, Giacenza> StampaCatalogobydesc(String desc){
        HashMap<Articolo, Giacenza> returnArt = new HashMap<>();
        //LinkedList<Articolo> returnArt = new LinkedList<>();
        Iterator it = magazzino.getMgz().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry= (Map.Entry) it.next();
            Articolo a = (Articolo) entry.getKey();
            Giacenza g = (Giacenza) entry.getValue();
            if(a.getLabel().contains(desc)){
                returnArt.put(a,g);
            }
        }
        return returnArt;
    }

    public HashMap<Articolo, Giacenza> StampaCatalogobycat(String cat){
        HashMap<Articolo, Giacenza> returnArt = new HashMap<>();
        //LinkedList<Articolo> returnArt = new LinkedList<>();
        Iterator it = magazzino.getMgz().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry= (Map.Entry) it.next();
            Articolo a = (Articolo) entry.getKey();
            Giacenza g = (Giacenza) entry.getValue();
            if(a.getCat().getDescrizione().contains(cat)){
                returnArt.put(a,g);
            }
        }
        return returnArt;
    }

    public HashMap<Articolo, Giacenza> StampaCatalogobyprice(double prezzo){
        HashMap<Articolo, Giacenza> returnArt = new HashMap<>();
        //LinkedList<Articolo> returnArt = new LinkedList<>();
        Iterator it = magazzino.getMgz().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry= (Map.Entry) it.next();
            Articolo a = (Articolo) entry.getKey();
            Giacenza g = (Giacenza) entry.getValue();
            if(a.getPrezzo()<=prezzo){
                returnArt.put(a,g);
            }
        }
        return returnArt;
    }


    public void StampaAcquisti(Articolo art){
        boolean flag;
        System.out.println("L'articolo: "+art.getSeriale()+" "+ art.getLabel()+" è stato acquistato dal fornitore:\n");
        Iterator it1 = ordinifornitori.entrySet().iterator();
        while(it1.hasNext()){
            Map.Entry entry = (Map.Entry)it1.next();
            Fornitore forntmp = (Fornitore)entry.getKey();
            LinkedList<Ordine> ordforntmp = (LinkedList<Ordine>)entry.getValue();
            flag = false;
            Iterator it2 = ordforntmp.iterator();
            StringBuilder stampa = new StringBuilder();
            while(it2.hasNext()){
                Ordine ordtmp = (Ordine)it2.next();
                if(ordtmp.getArtOrd().get(art)!=null){
                    flag = true;
                    stampa.append("id: ").append(ordtmp.getId()).append(", ").append("data: ").append(ordtmp.getData()).append(", ").append("Quantità: ").append(ordtmp.getArtOrd().get(art)).append("\n");
                }
            }
            if(flag){
                System.out.println(forntmp.getNomeSocieta()+" negli ordini:\n"+stampa);
                flag = false;
            }
        }
    }


    public void StampaVendite(Articolo art){
        boolean flag;
        System.out.println("L'articolo: "+art.getSeriale()+" "+ art.getLabel()+" è stato acquistato dal cliente:\n");
        Iterator it1 = ordiniclienti.entrySet().iterator();
        while(it1.hasNext()){
            Map.Entry entry = (Map.Entry)it1.next();
            Cliente clttmp = (Cliente) entry.getKey();
            LinkedList<Ordine> ordcltmp = (LinkedList<Ordine>)entry.getValue();
            flag = false;
            Iterator it2 = ordcltmp.iterator();
            StringBuilder stampa = new StringBuilder();
            while(it2.hasNext()){
                Ordine ordtmp = (Ordine)it2.next();
                if(ordtmp.getArtOrd().get(art)!=null){
                    flag = true;
                    stampa.append("id: ").append(ordtmp.getId()).append(", ").append("data: ").append(ordtmp.getData()).append(", ").append("Quantità: ").append(ordtmp.getArtOrd().get(art)).append("\n");
                }
            }
            if(flag){
                System.out.println("Username: "+clttmp.getUsername()+" Nome cliente: "+clttmp.getNome()+" negli ordini:\n"+stampa);
                flag = false;
            }
        }
    }

    public boolean LoginAdmin(String uname, String pw, Amministratore admin){
        if(admin.getUsername().equalsIgnoreCase(uname) && admin.getPassword().equals(pw)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean LoginCliente(String uname, String pw){
        Cliente c = RicercaClientebynamepw(uname, pw);
        if(c!=null){
            return true;
        }
        else
            return false;
    }

    public Agevolazione RicercaAgbykey(int k){
        Agevolazione ag;
        if(agevolazioni.containsKey(k)){
            ag=agevolazioni.get(k);
            return ag;
        }
        return null;
    }

    public HashMap<Integer, Agevolazione> RicercaAgbyDesc(String n){
        HashMap<Integer, Agevolazione> returnAg = new HashMap<>();
        //LinkedList<Articolo> returnArt = new LinkedList<>();
        Iterator it = agevolazioni.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry= (Map.Entry) it.next();
            if(agevolazioni.get(entry.getKey()).getDescrizione().contains(n)){
                returnAg.put((Integer)entry.getKey(),(Agevolazione)entry.getValue());
            }
        }
        return returnAg;
    }

    public void InserisciAgevolazione(int k, Agevolazione ag ){
        if(RicercaAgbykey(k)==null){
            agevolazioni.put(k,ag);
        }
        else{
            System.out.println("Agevolazione già presente\n");
        }
    }

    public void EliminaAgevolazione(int k){
        if (RicercaAgbykey(k)!=null){
            agevolazioni.remove(k);
            System.out.println("Agevolazione rimossa con successo\n");

        }
        else
            System.out.println("Agevolazione non presente\n");
    }

    public void caricaArtFile(){
        try {
            FileInputStream fin1= new FileInputStream("AnagraficaArticoli.dat");
            ObjectInputStream oi1= new ObjectInputStream(fin1);
            anagrafica= (AnaArticoli) oi1.readObject();
            oi1.close();
            fin1.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato! AnagraficaArticoli.dat\n");
        } catch (IOException e) {
            System.err.print("Errore in lettura! AnagraficaArticoli.dat\n");
        } catch (ClassNotFoundException e) {
            System.err.print("Errore in lettura oggetto! AnagraficaArticoli.dat\n");
        }
    }

    public void SalvaAnaArtFile()  {
        try {
            FileOutputStream fout3= new FileOutputStream("AnagraficaArticoli.dat");
            ObjectOutputStream oo3= new ObjectOutputStream(fout3);
            oo3.writeObject(anagrafica);
            oo3.close();
            fout3.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile aprire il file anagrafica!\n");
        } catch (IOException e) {
            System.out.println("Impossibile scrivere su file anagrafica!\n");
        }
    }


    public void caricaMagFile(){
        try {
            FileInputStream fin2= new FileInputStream("Magazzino.dat");
            ObjectInputStream oi2= new ObjectInputStream(fin2);
            magazzino= (Magazzino) oi2.readObject();
            oi2.close();
            fin2.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato! Magazzino.dat\n");
        } catch (IOException e) {
            System.err.print("Errore in lettura! Magazzino.dat\n");
        } catch (ClassNotFoundException e) {
            System.err.print("Errore in lettura oggetto! Magazzino.dat\n");
        }
    }


    public void SalvaMagFile()  {
        try {
            FileOutputStream fout1= new FileOutputStream("Magazzino.dat");
            ObjectOutputStream oo1= new ObjectOutputStream(fout1);
            oo1.writeObject(magazzino);
            oo1.close();
            fout1.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile aprire il file magazzino!\n");
        } catch (IOException e) {
            System.out.println("Impossibile scrivere su file magazzino!\n");
        }
    }

    public void VisualizzaFornitori(){
        if (getListafornitori().isEmpty())
            System.out.println("Lista fornitori vuota\n");
        else {
            System.out.println(getListafornitori().toString() + "\n");
        }
    }

    public LinkedList<Fornitore> getListafornitori() {
        return listafornitori;
    }

    public void setListafornitori(LinkedList<Fornitore> listafornitori) {
        this.listafornitori = listafornitori;
    }

    public LinkedList<Cliente> getListaclienti() {
        return listaclienti;
    }

    public void setListaclienti(LinkedList<Cliente> listaclienti) {
        this.listaclienti = listaclienti;
    }

    //devo cercare di spezzare questo metodo in metodi più piccoli

    public Ordine effettuaOrdineFornitore(){
        int uscita=-1;
        String seriale;
        int quantita;
        Scanner i=new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Ordine ord = new Ordine();
        do{
            System.out.println("\n1)Inserisci articolo\n"+
                    "0)Concludi ordine\n>");
            uscita = i.nextInt();
            switch (uscita){
                case 0:

                    Iterator it = ord.getArtOrd().entrySet().iterator();
                    while(it.hasNext()){
                        Map.Entry entry = (Map.Entry) it.next();
                        Articolo a = (Articolo)entry.getKey();
                        int q = (Integer)entry.getValue();
                        if(magazzino.getMgz().containsKey(a)){
                            Giacenza giac = magazzino.getMgz().get(a);
                            giac.setGiacenza(giac.getGiacenza()+q);
                            magazzino.getMgz().put(a,giac);
                        }
                        else{
                            magazzino.CaricaMagazzino(a,q);
                        }


                    }
                    Random r = new Random();
                    Calendar cal = Calendar.getInstance();
                    String data = String.valueOf(cal.get(Calendar.DATE))+ "/"+ String.valueOf(cal.get(Calendar.MONTH)+1) + "/"+ String.valueOf(cal.get(Calendar.YEAR));
                    ord.setData(data);
                    ord.setId((r.nextInt(10000)));
                    break;

                case 1:
                    System.out.println(getAnagrafica().StampaArticoli());
                    System.out.println("Inserisci il seriale dell'articolo da volere ordinare\n");
                    seriale = in.nextLine();

                    Articolo a = getAnagrafica().RicercaArticoloAna(seriale);
                    if(a!=null){
                        System.out.println("Inserisci la quantità da voler ordinare\n");
                        quantita = i.nextInt();
                        ord.getArtOrd().put(a,quantita);
                        ord.setTotale(ord.getTotale()+quantita*a.getPrezzo());
                    }
                    else{
                        System.out.println("Seriale non trovato\n");
                    }
                    break;
            }

        }while(uscita!=0);
        return ord;
    }

    public Ordine effettuaOrdineCliente(Carrello cart, Magazzino mag ){
        Ordine ord = new Ordine();
        cart.getCarrello();
        Iterator it = cart.getCarrello().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Articolo a = (Articolo)entry.getKey();
            Integer q= (Integer)entry.getValue();
            if(mag.getMgz().get(a).getGiacenza()>q){
                //ord.setTotale(ord.getTotale()+a.getPrezzo()*q);
                ord.setTotale(ord.getTotale()+cart.getTotale());
                mag.getMgz().get(a).setGiacenza(mag.getMgz().get(a).getGiacenza()-q);
                ord.getArtOrd().put(a,q);
                it.remove();
            }
            else{
                System.out.println("Errore: la quantità dell'articolo "+a.getSeriale()+", "+a.getLabel()+" non è disponibile in magazzino.\n" +
                        "Impossibile effettuare l'ordine per questo articolo\n ");
                //cart.rimuoviDalCarrello(a.getSeriale());
            }

    }
    return ord;
    }

    public void StoricoOrdini(){
        if (getOrdiniclienti().get(getListaclienti().get(0)).isEmpty()) {
            System.out.println("Non hai ancora effettuato ordini nello store\n");
        } else {
            System.out.println(getOrdiniclienti().get(getListaclienti().get(0)));
        }
    }

    public void StampaAgevolazioni(){
        if(agevolazioni.isEmpty()){
            System.out.println("Non sono presenti agevolazioni\n");

        }
        else{
            System.out.println(agevolazioni);
        }
    }


    public boolean cercaUser(LinkedList<Cliente> l, String usr){
        Iterator<Cliente> it=l.iterator();
        Cliente c;
        while(it.hasNext()){
            c= it.next();
            if(c.getUsername().equalsIgnoreCase(usr)){
                return true;
            }
        }
        return false;
    }
    public void Registrazione(Cliente c) {

            if (cercaUser(listaclienti,c.getUsername())) {
              System.out.println("\nCliente presente nel sistema!\n");
            } else {
                listaclienti.add(c);
                System.out.println("\nCliente inserito correttamente\n");

            }
        }

    public void caricaClientiFile(){
        try {
            FileInputStream fin4= new FileInputStream("Clienti.dat");
            ObjectInputStream oi4= new ObjectInputStream(fin4);
            listaclienti= (LinkedList<Cliente>) oi4.readObject();
            oi4.close();
            fin4.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato! Clienti.dat\n");
        } catch (IOException e) {
            System.err.print("Errore in lettura! Clienti.dat\n");
        } catch (ClassNotFoundException e) {
            System.err.print("Errore in lettura oggetto! Clienti.dat\n");
        }
    }

    public void caricaFornitoriFile(){
        try {
            FileInputStream fin4= new FileInputStream("Fornitori.dat");
            ObjectInputStream oi4= new ObjectInputStream(fin4);
            listafornitori= (LinkedList<Fornitore>) oi4.readObject();
            oi4.close();
            fin4.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato! Fornitori.dat\n");
        } catch (IOException e) {
            System.err.print("Errore in lettura! Fornitori.dat\n");
        } catch (ClassNotFoundException e) {
            System.err.print("Errore in lettura oggetto! Fornitori.dat\n");
        }
    }

    public void caricaOrdCliFile(){
        try {
            FileInputStream fin4= new FileInputStream("Ordini clienti.dat");
            ObjectInputStream oi4= new ObjectInputStream(fin4);
            ordiniclienti= (HashMap<Cliente, LinkedList<Ordine>>) oi4.readObject();
            oi4.close();
            fin4.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato! Ordini cliente.dat\n");
        } catch (IOException e) {
            System.err.print("Errore in lettura! Ordini cliente.dat\n");
        } catch (ClassNotFoundException e) {
            System.err.print("Errore in lettura oggetto! Ordini cliente.dat\n");
        }
    }

    public void salvaOrdCliFile()  {
        try {
            FileOutputStream fout4= new FileOutputStream("Ordini clienti.dat");
            ObjectOutputStream oo4= new ObjectOutputStream(fout4);
            oo4.writeObject(ordiniclienti);
            oo4.close();
            fout4.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile aprire il file!\n");
        } catch (IOException e) {
            System.out.println("Impossibile scrivere su file!\n");
        }
    }

    public void caricaAgevolazioniFile(){
        try {
            FileInputStream fin4= new FileInputStream("Agevolazioni.dat");
            ObjectInputStream oi4= new ObjectInputStream(fin4);
            agevolazioni= (HashMap<Integer, Agevolazione>) oi4.readObject();
            oi4.close();
            fin4.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato! Ordini cliente.dat\n");
        } catch (IOException e) {
            System.err.print("Errore in lettura! Ordini cliente.dat\n");
        } catch (ClassNotFoundException e) {
            System.err.print("Errore in lettura oggetto! Ordini cliente.dat\n");
        }
    }

    public void salvaAgevolazioniFile()  {
        try {
            FileOutputStream fout4= new FileOutputStream("Agevolazioni.dat");
            ObjectOutputStream oo4= new ObjectOutputStream(fout4);
            oo4.writeObject(agevolazioni);
            oo4.close();
            fout4.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile aprire il file!\n");
        } catch (IOException e) {
            System.out.println("Impossibile scrivere su file!\n");
        }
    }

    public void caricaOrdFornFile(){
        try {
            FileInputStream fin4= new FileInputStream("Ordini fornitori.dat");
            ObjectInputStream oi4= new ObjectInputStream(fin4);
            ordinifornitori= (HashMap<Fornitore, LinkedList<Ordine>>) oi4.readObject();
            oi4.close();
            fin4.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato! Ordini fornitore.dat\n");
        } catch (IOException e) {
            System.err.print("Errore in lettura! Ordini fornitore.dat\n");
        } catch (ClassNotFoundException e) {
            System.err.print("Errore in lettura oggetto! Ordini fornitore.dat\n");
        }
    }

    public void salvaOrdFornFile()  {
        try {
            FileOutputStream fout4= new FileOutputStream("Ordini fornitori.dat");
            ObjectOutputStream oo4= new ObjectOutputStream(fout4);
            oo4.writeObject(ordinifornitori);
            oo4.close();
            fout4.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile aprire il file!\n");
        } catch (IOException e) {
            System.out.println("Impossibile scrivere su file!\n");
        }
    }

    public void SalvaClientiFile()  {
        try {
            FileOutputStream fout4= new FileOutputStream("Clienti.dat");
            ObjectOutputStream oo4= new ObjectOutputStream(fout4);
            oo4.writeObject(listaclienti);
            oo4.close();
            fout4.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile aprire il file!\n");
        } catch (IOException e) {
            System.out.println("Impossibile scrivere su file!\n");
        }
    }

    public void SalvaFornitoriFile()  {
        try {
            FileOutputStream fout4= new FileOutputStream("Fornitori.dat");
            ObjectOutputStream oo4= new ObjectOutputStream(fout4);
            oo4.writeObject(listafornitori);
            oo4.close();
            fout4.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile aprire il file!\n");
        } catch (IOException e) {
            System.out.println("Impossibile scrivere su file!\n");
        }
    }




}