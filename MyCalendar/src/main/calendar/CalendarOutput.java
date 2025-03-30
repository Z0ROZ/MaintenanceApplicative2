package calendar;

public class CalendarOutput {
    public void eventAdded() {
        System.out.println("Événement ajouté avec succès !");
    }

    public void duplicateTitle() {
        System.out.println("Erreur : Un événement avec ce titre existe déjà.");
    }

    public void eventRemoved() {
        System.out.println("Événement supprimé avec succès");
    }

    public void eventNotFound() {
        System.out.println("Événement non trouvé");
    }
}