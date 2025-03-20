package user;

import action.exceptions.AuthentificationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserManager {
    private List<User> users;
    private User currentUser;
    private final Scanner scanner;
    private final String USERS_FILE = "users.json";


    public UserManager(Scanner scanner){
        this.scanner = scanner;
        users = new ArrayList<>();
        loadUsers();
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void login() throws AuthentificationException {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        boolean isLogged = false;
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(PasswordUtils.hashPassword(motDePasse))) {
                currentUser = u;
                isLogged = true;
                break;
            }
        }

        if (isLogged) {
            System.out.println("Connexion réussie !");
        } else {
            throw new AuthentificationException("Identifiants incorrects.");
        }
    }

    public void register() {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        String confirmation = scanner.nextLine();

        if (confirmation.equals(motDePasse)) {
            User newUser = new User(username, PasswordUtils.hashPassword(motDePasse));
            users.add(newUser);
            saveUsers();
            System.out.println("Compte créé avec succès !");
        } else {
            System.out.println("Les mots de passe ne correspondent pas...");
        }
    }

    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            users = (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Aucun utilisateur enregistré, démarrage initial...");
        } catch (IOException | ClassNotFoundException e) {
            //throw new AuthentificationException("Problème lors de la récupération des utilisateurs", e);
        }
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            //throw new AuthentificationException("Problème lors de la sauvegarde des utilisateurs", e);
        }
    }
}
