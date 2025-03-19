

import Event.Periodique;
import Event.RendezVous;
import Event.Reunion;
import Event.primitives.*;
import Event.Event;
import enums.TypeEvenement;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        String utilisateur = null;
        boolean continuer = true;

        String[] utilisateurs = new String[99];
        String[] motsDePasses = new String[99];
        int nbUtilisateurs = 0;

        while (true) {

            if (utilisateur == null) {
                System.out.println("  _____         _                   _                __  __");
                System.out.println(" / ____|       | |                 | |              |  \\/  |");
                System.out.println(
                        "| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
                System.out.println(
                        "| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
                System.out.println(
                        "| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
                System.out.println(
                        " \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
                System.out.println(
                        "                                                                                   __/ |");
                System.out.println(
                        "                                                                                  |___/");

                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.println("Choix : ");

                switch (scanner.nextLine()) {
                    case "1":
                        System.out.print("Nom d'utilisateur: ");
                        utilisateur = scanner.nextLine();

                        if (utilisateur.equals("Roger")) {
                            String motDePasse = scanner.nextLine();
                            if (!motDePasse.equals("Chat")) {
                                utilisateur = null;
                            }
                        } else {
                            if (utilisateur.equals("Pierre")) {
                                String motDePasse = scanner.nextLine();
                                if (!motDePasse.equals("KiRouhl")) {
                                    utilisateur = null;
                                }
                            } else {
                                System.out.print("Mot de passe: ");
                                String motDePasse = scanner.nextLine();

                                for (int i = 0; i < nbUtilisateurs; i = i + 1) {
                                    assert utilisateurs[i] != null;
                                    if (utilisateurs[i].equals(utilisateur) && motsDePasses[i].equals(motDePasse)) {
                                        utilisateur = utilisateurs[i];
                                    }
                                }
                            }
                        }
                        break;

                    case "2":
                        System.out.print("Nom d'utilisateur: ");
                        utilisateur = scanner.nextLine();
                        System.out.print("Mot de passe: ");
                        String motDePasse = scanner.nextLine();
                        System.out.print("Répéter mot de passe: ");
                        if (scanner.nextLine().equals(motDePasse)) {
                            utilisateurs[nbUtilisateurs] = utilisateur;
                            motsDePasses[nbUtilisateurs] = motDePasse;
                            nbUtilisateurs = nbUtilisateurs + 1;
                        } else {
                            System.out.println("Les mots de passes ne correspondent pas...");
                            utilisateur = null;
                        }
                        break;
                }
            }

            while (continuer && utilisateur != null) {
                System.out.println("\nBonjour, " + utilisateur);
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");

                String choix = scanner.nextLine();

                switch (choix) {
                    case "1":
                        System.out.println("\n=== Menu de visualisation d'Événements ===");
                        System.out.println("1 - Afficher TOUS les événements");
                        System.out.println("2 - Afficher les événements d'un MOIS précis");
                        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
                        System.out.println("4 - Afficher les événements d'un JOUR précis");
                        System.out.println("5 - Retour");
                        System.out.print("Votre choix : ");

                        choix = scanner.nextLine();

                        switch (choix) {
                            case "1":
                                calendar.afficherEvenements();
                                break;

                            case "2":
                                afficherEvenementsDansPeriode(calendar, scanner, "MOIS");
                                break;

                            case "3":
                                afficherEvenementsDansPeriode(calendar, scanner, "SEMAINE");
                                break;

                            case "4":
                                afficherEvenementsDansPeriode(calendar, scanner, "JOUR");
                                break;
                        }
                        break;

                    case "2":
                        creerEvenement(calendar, scanner, utilisateur, TypeEvenement.RDV_PERSONNEL);
                        break;

                    case "3":
                        creerEvenement(calendar, scanner, utilisateur, TypeEvenement.REUNION);
                        break;

                    case "4":
                        creerEvenement(calendar, scanner, utilisateur, TypeEvenement.PERIODIQUE);
                        break;

                    default:
                        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                        continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");

                        utilisateur = null;
                }
            }
        }
    }

    private static void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }

    private static void creerEvenement(CalendarManager calendar, Scanner scanner, String utilisateur, TypeEvenement type) {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        String annee = scanner.nextLine();
        System.out.print("Mois (1-12) : ");
        String mois = scanner.nextLine();
        System.out.print("Jour (1-31) : ");
        String jour = scanner.nextLine();
        System.out.print("Heure début (0-23) : ");
        String heure = scanner.nextLine();
        System.out.print("Minute début (0-59) : ");
        String minute = scanner.nextLine();

        TitreEvenement titreEvenement = new TitreEvenement(titre);
        ProprietaireEvenement proprietaireEvenement = new ProprietaireEvenement(utilisateur);
        LocalDateTime dateDebutEvenement =LocalDateTime.of(Integer.parseInt(annee), Integer.parseInt(mois), Integer.parseInt(jour), Integer.parseInt(heure), Integer.parseInt(minute));

        int duree = 0;
        DureeEvenement dureeEvenement = new DureeEvenement(duree);
        LieuEvenement lieuEvenement = null;
        ParticipantsEvenement participantsEvenement = null;
        int frequence = 0;
        FrequenceJours frequenceJours = new FrequenceJours(0);

        if (type == TypeEvenement.RDV_PERSONNEL || type == TypeEvenement.REUNION) {
            System.out.print("Durée (en minutes) : ");
            duree = Integer.parseInt(scanner.nextLine());
            dureeEvenement = new DureeEvenement(duree);
        }

        if (type == TypeEvenement.REUNION) {
            System.out.print("Nom du lieu : ");
            lieuEvenement = new LieuEvenement(scanner.nextLine());

            System.out.println("Ajouter des participants ? (oui / non)");
            List<String> participantsList = new ArrayList<>();
            participantsList.add(utilisateur);
            while (scanner.nextLine().equalsIgnoreCase("oui")) {
                System.out.print("Participant : ");
                participantsList.add(scanner.nextLine());
            }
            participantsEvenement = new ParticipantsEvenement(participantsList);
        }

        if (type == TypeEvenement.PERIODIQUE) {
            System.out.print("Fréquence (en jours) : ");
            frequence = Integer.parseInt(scanner.nextLine());
            frequenceJours = new FrequenceJours(frequence);
        }

        Event evenement;
        if (type == TypeEvenement.PERIODIQUE) {
            evenement = new Periodique(titreEvenement, proprietaireEvenement, dateDebutEvenement, dureeEvenement, frequenceJours);
        } else if (type == TypeEvenement.REUNION) {
            evenement = new Reunion(titreEvenement, proprietaireEvenement, dateDebutEvenement, dureeEvenement, lieuEvenement, participantsEvenement);
        } else {
            evenement = new RendezVous(titreEvenement, proprietaireEvenement, dateDebutEvenement, dureeEvenement);
        }

        calendar.ajouterEvenement(evenement);

        System.out.println("Événement ajouté.");
    }

    private static void afficherEvenementsDansPeriode(CalendarManager calendar, Scanner scanner, String typePeriode) {
        System.out.print("Entrez l'année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());

        LocalDateTime debut = null, fin = null;

        switch (typePeriode) {
            case "MOIS":
                System.out.print("Entrez le mois (1-12) : ");
                int mois = Integer.parseInt(scanner.nextLine());
                debut = LocalDateTime.of(annee, mois, 1, 0, 0);
                break;

            case "SEMAINE":
                System.out.print("Entrez le numéro de semaine (1-52) : ");
                int semaine = Integer.parseInt(scanner.nextLine());
                debut = LocalDateTime.now()
                        .withYear(annee)
                        .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                        .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                        .withHour(0).withMinute(0);
                fin = debut.plusDays(7).minusSeconds(1);
                break;

            case "JOUR":
                System.out.print("Entrez le mois (1-12) : ");
                int moisJour = Integer.parseInt(scanner.nextLine());
                System.out.print("Entrez le jour (1-31) : ");
                int jour = Integer.parseInt(scanner.nextLine());
                debut = LocalDateTime.of(annee, moisJour, jour, 0, 0);
                fin = debut.plusDays(1).minusSeconds(1);
                break;
        }

        afficherListe(calendar.evenementsDansPeriode(debut, fin));
    }


}
