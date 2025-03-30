package user;

import user.message.UserOutput;
import user.primitives.Password;
import user.primitives.Username;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserManager {
    private List<User> users;
    private User currentUser;
    private final Scanner scanner;
    private final UserOutput output;
    private final String USERS_FILE = "users.json";


    public UserManager(Scanner scanner, UserOutput output){
        this.scanner = scanner;
        this.output = output;
        this.users = new ArrayList<>();
        loadUsers();
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void login() {
        output.displayMessage("Nom d'utilisateur: ");
        Username username = Username.of(scanner.nextLine());
        output.displayMessage("Mot de passe: ");
        String plainPassword = scanner.nextLine();

        boolean isLogged = users.stream()
                .filter(u -> u.getUsername().getValue().equals(username.getValue()))
                .filter(u -> u.getPassword().matches(plainPassword))
                .findFirst()
                .map(u -> {
                    currentUser = u;
                    return true;
                })
                .orElse(false);

        output.displayMessage(isLogged ? "Connexion réussie !" : "Identifiants incorrects.");
    }

    public void register() {
        try {
            output.displayMessage("Nom d'utilisateur: ");
            Username username = Username.of(scanner.nextLine());

            if (users.stream().anyMatch(u -> u.getUsername().getValue().equals(username.getValue()))) {
                output.displayMessage("Ce nom d'utilisateur existe déjà");
                return;
            }

            output.displayMessage("Mot de passe: ");
            String password = scanner.nextLine();
            if (password.length() < 6) {
                output.displayError("Le mot de passe doit faire au moins 6 caractères");
                return;
            }

            output.displayMessage("Répéter mot de passe: ");
            String confirmation = scanner.nextLine();

            if (!confirmation.equals(password)) {
                output.displayError("Les mots de passe ne correspondent pas");
                return;
            }

            User newUser = new User(username, Password.fromPlainText(password));
            users.add(newUser);
            saveUsers();
            output.displayMessage("Compte créé avec succès !");

        } catch (IllegalArgumentException e) {
            output.displayError("Erreur de validation: " + e.getMessage());
        }
    }

    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            users = (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            output.displayMessage("Aucun utilisateur enregistré, démarrage initial...");
        } catch (IOException | ClassNotFoundException e) {
            output.displayError("Problème lors de la récupération des utilisateurs");
        }
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            output.displayError("Problème lors de la sauvegarde des utilisateurs");
        }
    }
}
