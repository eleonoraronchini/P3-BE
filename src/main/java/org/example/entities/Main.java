package org.example.entities;

import net.bytebuddy.asm.Advice;
import org.example.DAO.ElementoCatalogoDAO;
import org.example.DAO.PrestitoDAO;
import org.example.DAO.UtenteDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main 
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto3");
    private static EntityManager em = emf.createEntityManager();

    public static void main( String[] args ) {
        //CREO ELEMENTI DAO:
       ElementoCatalogoDAO elemento = new ElementoCatalogoDAO(em);
        PrestitoDAO prestito = new PrestitoDAO(em);
        UtenteDAO utente = new UtenteDAO(em);

        //CREO LIBRI:
        Libri l1 = new Libri("Guerra e pace",2019,1560,"Lev Tolstoj","Classici");
        Libri l2 = new Libri("Il giardino magico",2025,272,"Kaho NASHIKI","Fantasy");
        Libri l3 = new Libri("La vegetariana",2019,192,"Han Kang","Romanzi stranieri");
        Libri l4 = new Libri("Pensieri",2024,324,"Marco Aurelio","Prosa letteraria");
        Libri l5 = new Libri ("La divina commedia.Inferno",2016,1176,"Dante","Classici");
        Libri l6 = new Libri ("La divina commedia.Purgatorio",2016,1204,"Dante","Classici");
        Libri l7 = new Libri ("Il trono di spade",2019,500,"George Martin","Fantasy");

        //CREO RIVISTE:
        Rivista r1 = new Rivista("Classick Rock",2020,40,Periodicità.MENSILE);
        Rivista r2 = new Rivista("Hacker Journal",2023,50,Periodicità.SEMESTRALE);
        Rivista r3 = new Rivista("Pollice Verde",2019,25,Periodicità.SETTIMANALE);
        Rivista r4 = new Rivista("Il Fotografo",2024,35,Periodicità.MENSILE);

        //CREO UTENTE:
        Utente u1 = new Utente("Caterina", "Marchi",LocalDate.of(1998, 3, 24));
        Utente u2 = new Utente("Marco", "Marini",  LocalDate.of(1996, 4, 12));
        Utente u3 = new Utente("Matilde", "Lazzari",LocalDate.of(1998, 12, 2));
        Utente u4 = new Utente("Giacomo", "Righetti",  LocalDate.of(1999, 9, 20));
        Utente u5 = new Utente("Allegra", "Savoretti", LocalDate.of(2001, 2, 15));
        Utente u6 = new Utente("Eleonora", "Ronchini", LocalDate.of(1997, 6, 28));
        Utente u7 = new Utente("Alberto", "Fraternali", LocalDate.of(1995, 12, 10));
        Utente u8 = new Utente("Teo", "Tentoni",  LocalDate.of(1997, 7, 3));



        //AGGIUNGO ELEMENTI AL DB:
        ElementoCatalogoDAO.save_elementoCatalogo(l1);
        ElementoCatalogoDAO.save_elementoCatalogo(l2);
        ElementoCatalogoDAO.save_elementoCatalogo(l3);
        ElementoCatalogoDAO.save_elementoCatalogo(l4);
        ElementoCatalogoDAO.save_elementoCatalogo(l5);
        ElementoCatalogoDAO.save_elementoCatalogo(l6);
        ElementoCatalogoDAO.save_elementoCatalogo(l7);

        ElementoCatalogoDAO.save_elementoCatalogo(r1);
        ElementoCatalogoDAO.save_elementoCatalogo(r2);
        ElementoCatalogoDAO.save_elementoCatalogo(r3);
        ElementoCatalogoDAO.save_elementoCatalogo(r4);

        UtenteDAO.save_utente(u1);
        UtenteDAO.save_utente(u2);
        UtenteDAO.save_utente(u3);
        UtenteDAO.save_utente(u4);
        UtenteDAO.save_utente(u5);
        UtenteDAO.save_utente(u6);
        UtenteDAO.save_utente(u7);
        UtenteDAO.save_utente(u8);

        List<ElementoCatalogo> listaPrestiti1 = new ArrayList<ElementoCatalogo>();
        List<ElementoCatalogo> listaPrestiti2 = new ArrayList<ElementoCatalogo>();
        List<ElementoCatalogo> listaPrestiti3 = new ArrayList<ElementoCatalogo>();
        List<ElementoCatalogo> listaPrestiti4 = new ArrayList<ElementoCatalogo>();
        List<ElementoCatalogo> listaPrestiti5 = new ArrayList<ElementoCatalogo>();

        listaPrestiti1.add(ElementoCatalogoDAO.get_elementoCatalogoById(458));
        listaPrestiti1.add(ElementoCatalogoDAO.get_elementoCatalogoById(459));
        listaPrestiti2.add(ElementoCatalogoDAO.get_elementoCatalogoById(460));
        listaPrestiti2.add(ElementoCatalogoDAO.get_elementoCatalogoById(462));
        listaPrestiti2.add(ElementoCatalogoDAO.get_elementoCatalogoById(463));
        listaPrestiti3.add(ElementoCatalogoDAO.get_elementoCatalogoById(468));
        listaPrestiti3.add(ElementoCatalogoDAO.get_elementoCatalogoById(469));
        listaPrestiti4.add(ElementoCatalogoDAO.get_elementoCatalogoById(467));
        listaPrestiti5.add(ElementoCatalogoDAO.get_elementoCatalogoById(465));
        listaPrestiti5.add(ElementoCatalogoDAO.get_elementoCatalogoById(466));
        listaPrestiti5.add(ElementoCatalogoDAO.get_elementoCatalogoById(469));

        //CREO PRESTITI:
        Prestito p1 = new Prestito(u1,listaPrestiti1,LocalDate.of(2025,1,2),LocalDate.of(2025,1,10),LocalDate.of(2025,1,9));
        Prestito p2 = new Prestito(u3,listaPrestiti2, LocalDate.of(2025,1,20),LocalDate.of(2025,1,29),null);
        Prestito p3 = new Prestito(u4,listaPrestiti3, LocalDate.of(2025,1,10),LocalDate.of(2025,2,3), null);
        Prestito p4 = new Prestito(u6,listaPrestiti5,LocalDate.of(2025,1,7),LocalDate.of(2025,1,19),LocalDate.of(2025,1,18));
        Prestito p5 = new Prestito(u7,listaPrestiti4, LocalDate.of(2025,1,7),LocalDate.of(2025,1,20),null);

        //AGGIUNGO PRESTITI AL DB:
        PrestitoDAO.save_prestito(p1);
        PrestitoDAO.save_prestito(p2);
        PrestitoDAO.save_prestito(p3);
        PrestitoDAO.save_prestito(p4);
        PrestitoDAO.save_prestito(p5);
        //PROVO I METODI:

      List <ElementoCatalogo> elementiPerAnno = Archivio.searchByAnnoDiPubblicazione(2019);
       elementiPerAnno.forEach(e->System.out.println(e));

       ElementoCatalogo elementoProva = Archivio.searchByISBN(458);
       System.out.println(elementoProva);

       List <Libri> elementiPerAutore = Archivio.searchByAuthor("Dante");
       elementiPerAutore.forEach(l->System.out.println(l));

       List <ElementoCatalogo> elementiPerTitolo = Archivio.searchByTitle("Hacker Journal");
       System.out.println(elementiPerTitolo);

        List<Prestito> prestitiPersonali = Archivio.searchElementsInPrestitoByNumeroTesseraUtente(533);
        System.out.println (prestitiPersonali);

        List<Prestito> prestitiScaduti = Archivio.searchPrestitiScadutieNonAncoraRestituiti();
        System.out.println(prestitiScaduti);








    }
}

