package fr.grey.test;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import fr.grey.dao.VolDAO;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Logger log = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    public static void main(String[] args) {
        log.setLevel(Level.WARN);
        boolean leave = false;
        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("Bienvenue dans le fabuleux système de réservation de vol RESAFLIGHT2000!!!\n"
            +" Vous souhaitez :\n"
            +"1) Gerer les vols\n"
            +"2) Gerer les réservations\n"
            +"3) Quitter\n"
            +"Entrez le numero de votre choix et appuyez sur \"Entrée\" ");

            String str = sc.nextLine();
            switch(str){
                case "1":
                    gestionVols();
                    break;
                case "2":
                    gestionReservations();
                    break;
                case "3":
                    System.out.println("Vous avez choisi de nous quitter, merci et à bientôt!");
                    leave = true;
                    break;
                default:
                    System.out.println("Choix erroné, veuillez recommencer");
                    break;
            }
        } while (!leave);

    }

    private static void gestionVols() {
        boolean leave = false;
        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("1) Création d'un vol\n"
                    +"2) Liste des vols\n"
                    +"3) Rechercher un avion par numéro\n"
                    +"4) Rechercher un avion par ville de départ et d’arrivée\n"
                    +"5) Retour\n"
                    +"Entrez le numero de votre choix et appuyez sur \"Entrée\" ");

            String str = sc.nextLine();
            switch(str){
                case "1":
                    creationVol();
                    break;
                case "2":

                    break;
                case "5":
                    leave = true;
                    break;
                default:
                    System.out.println("Choix erroné, veuillez recommencer");
                    break;
            }
        } while (!leave);

    }

    private static void creationVol() {
        Scanner sc = new Scanner(System.in);

        Vol vol = new Vol();
        System.out.println("Vous souhaitez créer un nouveau vol!\n"
                +"Entrez un numéro de vol");
        vol.setNumeroVol(sc.nextLine());

        //<editor-fold desc="set type avion">
        boolean okType;
        do {
            okType = true;
            System.out.println("Type d'avion :\n"
                    +"1) A330\n"
                    +"2) A340\n"
                    +"3) A380\n"
                    +"4) B747");
            String str = sc.nextLine();
            switch (str) {
                case "1":
                    vol.setTypeAvion(Avion.A330);
                    break;
                case "2":
                    vol.setTypeAvion(Avion.A340);
                    break;
                case "3":
                    vol.setTypeAvion(Avion.A380);
                    break;
                case "4":
                    vol.setTypeAvion(Avion.B747);
                    break;
                default:
                    System.out.println("Type d'avion inexistant, veuillez recommencer");
                    okType = false;
                    break;
            }
        } while (!okType);
        //</editor-fold>

        System.out.println("Nombre de place :");
        vol.setNbPlaces(Integer.parseInt(sc.nextLine()));
        System.out.println("Ville de départ :");
        vol.setVilleDepart(sc.nextLine());
        System.out.println("Ville d'arrivée :");
        vol.setVilleArrivee(sc.nextLine());
        System.out.println("Date de départ (dd/mm/yyyy):");
        //vol.setDateDepart(Date.(sc.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        String inputDateDepart = sc.nextLine();
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy", Locale.FRENCH);
        Date dateDepart = null;
        try {
            dateDepart = df.parse(inputDateDepart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        VolDAO.createVol(vol);
        vol.setDateDepart(dateDepart);

    }

    private static void gestionReservations() {
        boolean leave = false;
        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("1) Création d'un vol\n"
                    +"2) Liste des vols\n"
                    +"3) Rechercher un avion par numéro\n"
                    +"4) Rechercher un avion par ville de départ et d’arrivée\n"
                    +"5) Retour\n"
                    +"Entrez le numero de votre choix et appuyez sur \"Entrée\" ");

            String str = sc.nextLine();
            switch(str){
                case "1":
                    break;
                case "2":
                    break;
                case "5":
                    leave = true;
                    break;
                default:
                    System.out.println("Choix erroné, veuillez recommencer");
                    break;
            }
        } while (!leave);

    }

}
