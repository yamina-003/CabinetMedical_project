package cabinetmedical;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Medecin medecin = new Medecin();
        int choix;

        do {
            System.out.println("Menu : ");
            System.out.println("1. Prise d'un rendez-vous");
            System.out.println("2. Afficher la liste des rendez-vous");
            System.out.println("3. Annuler un rendez-vous");
            System.out.println("4. Afficher un rendez-vous d'un patient");
            System.out.println("5. Afficher le dossier médical d'un patient");
            System.out.println("6. Effectuer une consultation");
            System.out.println("7. Quitter");

            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne après nextInt()

            switch (choix) {
                case 1:
                    // la prise d'un rendez-vous
                    Rendezvous.prendreRendezVous(scanner);
                    break;
                case 2:
                    // Afficher la liste des rendez-vous
                    Rendezvous.afficherListeRendezVous();
                    break;
                case 3:
                    LocalDate  date_rdv_annuler;
                    LocalTime heure_rdv_annuler;
                    // annuler un rendez-vous
                    System.out.println("Date du rendez-vous (jj/mm/aaaa) à annuler : ");
                      System.out.print("Jour : ");
                      int jour = scanner.nextInt();
                      System.out.print("Mois : ");
                      int mois = scanner.nextInt();
                      System.out.print("Année : ");
                      int annee = scanner.nextInt();
                      date_rdv_annuler = LocalDate.of(annee, mois, jour);

                      // Saisie de l'heure du rendez-vous
                      System.out.println("Heure du rendez-vous (hh:mm) à annuler : ");
                      System.out.print("Heure : ");
                      int heure = scanner.nextInt();
                      System.out.print("Minute : ");
                      int minute = scanner.nextInt();
                      heure_rdv_annuler = LocalTime.of(heure, minute);
                      Rendezvous.supprimerRendezvous(date_rdv_annuler, heure_rdv_annuler);
                    break;
                case 4:
                    // Logique pour afficher les rendez-vous d'un patient spécifique
                    // Saisie des informations du patient
                    System.out.println("Nom du patient : ");
                    String nom1 = scanner.nextLine();
                    System.out.println("Prénom du patient : ");
                    String prenom1 = scanner.nextLine();
                    Patient patient1 = GestionPatients.rechercherPatient(nom1, prenom1);
                    if(patient1 != null){
                        Rendezvous.afficherRendezVousParPatient(patient1);
                    } else {
                        System.out.println("Patient non trouvé.");
                    }


                    break;
                case 5:
                    // Logique pour afficher le dossier médical d'un patient
                    System.out.println("Nom du patient : ");
                    String nom2 = scanner.nextLine();
                    System.out.println("Prénom du patient : ");
                    String prenom2 = scanner.nextLine();
                    Patient patient2 = GestionPatients.rechercherPatient(nom2, prenom2);
                    if(patient2 != null){
                        patient2.afficherDossierMedical(patient2);
                    } else {
                        System.out.println("Patient non trouvé.");
                    }
                    
                    break;
                case 6:
                    Consultation.effectuerConsultation(scanner, medecin);
                    break;
                case 7:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 8.");
                    break;
            }
        } while (choix != 7);
    }
}




