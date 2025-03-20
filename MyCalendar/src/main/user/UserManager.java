package user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserManager {
    private List<User> users;
    private int nbUsers;
    private Scanner scanner;


    public UserManager(Scanner scanner) {
        users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void seConnecter() {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        boolean authentifie = false;
        for (int i = 0; i < nbUsers; i++) {
            User u = users.get(i);
            if (u.getName().equals(username) && u.getPassword().equals(motDePasse)) {
                authentifie = true;
                break;
            }
        }

        if (authentifie) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Identifiants incorrects.");
        }
    }

    public void creerCompte() {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        String confirmation = scanner.nextLine();

        if (confirmation.equals(motDePasse)) {
            users.add(new User(username, motDePasse));
            nbUsers++;
            System.out.println("Compte créé avec succès !");
        } else {
            System.out.println("Les mots de passe ne correspondent pas...");
        }
    }

}
