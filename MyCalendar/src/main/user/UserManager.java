package user;

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

    public void login(){
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        boolean isLogged = false;
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(PasswordUtils.hashPassword(password))) {
                currentUser = u;
                isLogged = true;
                break;
            }
        }

        if (isLogged) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Identifiants incorrects.");
            //throw new AuthentificationException("Identifiants incorrects.");
        }
    }

    public void register() {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        String confirmation = scanner.nextLine();

        if (confirmation.equals(password)) {
            User newUser = new User(username, PasswordUtils.hashPassword(password));
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
            System.out.println("Problème lors de la récupération des utilisateurs");
        }
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println("Problème lors de la sauvegarde des utilisateurs");
        }
    }
}
