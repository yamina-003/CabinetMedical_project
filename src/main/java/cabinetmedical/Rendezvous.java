package cabinetmedical;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class Rendezvous {
    private LocalDate date;
    private Patient patient;
    private LocalTime heure;

    private static List<Rendezvous> rendezvousliste = new ArrayList<>();

    public Rendezvous(Patient patient, LocalDate date, LocalTime heure) {
        this.date = date;
        this.patient = patient;
        this.heure = heure;
    }

    public static void prendreRendezVous(Scanner scanner){
        
        // Saisie des informations du patient
        System.out.println("Nom du patient : ");
        String nom = scanner.nextLine();
        System.out.println("Prénom du patient : ");
        String prenom = scanner.nextLine();

        // Création du patient
        Patient patient = new Patient(nom, prenom);
        if (!GestionPatients.ajouterPatient(patient)) {
            System.out.println("Ce patient existe déjà.");
            
        } else {
            DossierMedical dossiermedical = new DossierMedical(patient);
            GestionPatients.ajouterPatient(patient);
            patient.setDossierMedical(dossiermedical);
            
        }

        // Saisie de la date du rendez-vous
        System.out.println("Date du rendez-vous (jj/mm/aaaa) : ");
        System.out.print("Jour : ");
        int jour = scanner.nextInt();
        System.out.print("Mois : ");
        int mois = scanner.nextInt();
        System.out.print("Année : ");
        int annee = scanner.nextInt();
        LocalDate date = LocalDate.of(annee, mois, jour);

        // Saisie de l'heure du rendez-vous
        System.out.println("Heure du rendez-vous (hh:mm) : ");
        System.out.print("Heure : ");
        int heure = scanner.nextInt();
        System.out.print("Minute : ");
        int minute = scanner.nextInt();
        LocalTime heureRdv = LocalTime.of(heure, minute);

        // Prise du rendez-vous
        Rendezvous.priseRendezVous(patient, date, heureRdv);

        

    }

    public static void priseRendezVous(Patient patient, LocalDate date, LocalTime heure) {
        if (rendezVousDisponible(date, heure)) {
            Rendezvous rdv = new Rendezvous(patient, date, heure);
            rendezvousliste.add(rdv);
            System.out.println("Rendez-vous pris avec succès pour " + patient.getNom() + " " + patient.getPrenom() + " le " + date + " à " + heure);
        } else {
            System.out.println("Echec de prise du Rendezvous");
        }
    }

    public static boolean rendezVousDisponible(LocalDate date, LocalTime heure) {
        for (Rendezvous rdv : rendezvousliste) {
            if (rdv.getDate().equals(date) && rdv.getHeure().equals(heure)) {
                return false;
            }
        }
        return true;
    }

    public static Rendezvous getRendezvous(LocalDate date, LocalTime heure) {
        for (Rendezvous rdv : rendezvousliste) {
            if (rdv.getDate().equals(date) && rdv.getHeure().equals(heure)) {
                return rdv;
            }
        }
        return null; 
    }

    public static void supprimerRendezvous(LocalDate date, LocalTime heure) {
        Iterator<Rendezvous> iterateur = rendezvousliste.iterator();
        boolean rendezvousTrouve = false;
        while (iterateur.hasNext()) {
            Rendezvous rdv = iterateur.next();
            if (rdv.getDate().equals(date) && rdv.getHeure().equals(heure)) {
                iterateur.remove();
                rendezvousTrouve = true;
            }
        }
        if (!rendezvousTrouve) {
            System.out.println("Aucun rendez-vous trouvé à la date et l'heure spécifiées.");
        }
    }
    
    /* cette methode affiche la liste des rendez vous du cabinet medical  */
    public static void afficherListeRendezVous() {
        if (rendezvousliste.isEmpty()) {
            System.out.println("Il n'y a aucun rendez-vous.");
        } else {
            System.out.println("Liste des rendez-vous :");
            for (Rendezvous rdv : rendezvousliste) {
                System.out.println("Date : " + rdv.getDate() + ", Heure : " + rdv.getHeure() + ", Patient : " + rdv.getPatient().getNom() + " " + rdv.getPatient().getPrenom());
            }
        }
    }
    
    /* cette methode affiche la liste des rendez vous d'un patient spécifique */
    public static void afficherRendezVousParPatient(Patient patient) {
        boolean trouve = false;
        System.out.println("Rendez-vous pour " + patient.getNom() + " " + patient.getPrenom() + ":");
        for (Rendezvous rdv : rendezvousliste) {
            if (rdv.getPatient().equals(patient)) {
                System.out.println("Date : " + rdv.getDate() + ", Heure : " + rdv.getHeure());
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun rendez-vous trouvé pour ce patient.");
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public static List<Rendezvous> getRendezvousliste() {
        return rendezvousliste;
    }
}

