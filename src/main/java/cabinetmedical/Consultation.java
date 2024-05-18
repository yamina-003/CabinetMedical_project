package cabinetmedical;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Consultation {
    private Patient patient;
    private LocalDate date;
    private Medecin medecin;
    private Ordonnance ordonnance;

    public Consultation(LocalDate date, Medecin medecin, Patient patient, Ordonnance ordonnance) {
        this.date = date;
        this.medecin = medecin;
        this.patient = patient;
        this.ordonnance = new Ordonnance(patient, medecin, date);
    }

    private boolean verifierMotDePasse(String motDePasse) {
        return medecin.getMotdePasse().equals(motDePasse);
    }

    public void consultationencours(Scanner scanner, LocalDate daterdv) {
        System.out.println("Mot de passe du médecin : ");
        String motDePasse = scanner.nextLine();
        
        if (!verifierMotDePasse(motDePasse)) {
            System.out.println("Accès refusé : mot de passe incorrect.");
            return;
        }

        System.out.println("Les observations du médecin: ");
        String observations = scanner.nextLine();
        System.out.println("Antécédents médicaux:");
        String antecedentsMedicaux = scanner.nextLine();
        System.out.println("Antécédents chirurgicaux:");
        String antecedentsChirurgicaux = scanner.nextLine();
        System.out.println("Données terrain: ");
        String donneesTerrain = scanner.nextLine();
    
        FichePatient fichepatient = new FichePatient(patient, antecedentsMedicaux, antecedentsChirurgicaux, donneesTerrain, observations);
        this.patient.getDossierMedical().ajouterFichePatient(fichepatient);
        this.ordonnance.remplirOrdonnance(scanner, daterdv);
        this.patient.getDossierMedical().ajouterOrdonnance(ordonnance);
    }

    public static void effectuerConsultation(Scanner scanner, Medecin medecin) {
        LocalDate daterdv;
        LocalTime heurerdv;

        System.out.println("Date du rendez-vous (jj/mm/aaaa) : ");
        System.out.print("Jour : ");
        int jour = scanner.nextInt();
        scanner.nextLine(); // Consomme le caractère de fin de ligne
        System.out.print("Mois : ");
        int mois = scanner.nextInt();
        scanner.nextLine(); // Consomme le caractère de fin de ligne
        System.out.print("Année : ");
        int annee = scanner.nextInt();
        scanner.nextLine(); // Consomme le caractère de fin de ligne
        daterdv = LocalDate.of(annee, mois, jour);

        System.out.println("Heure du rendez-vous (hh:mm) : ");
        System.out.print("Heure : ");
        int heure = scanner.nextInt();
        scanner.nextLine(); // Consomme le caractère de fin de ligne
        System.out.print("Minute : ");
        int minute = scanner.nextInt();
        scanner.nextLine(); // Consomme le caractère de fin de ligne
        heurerdv = LocalTime.of(heure, minute);

        Rendezvous rdv = Rendezvous.getRendezvous(daterdv, heurerdv);
        if (rdv != null) {
            Consultation consultation = new Consultation(daterdv, medecin, rdv.getPatient(), null);
            consultation.consultationencours(scanner, daterdv);
            Rendezvous.supprimerRendezvous(daterdv, heurerdv);
        } else {
            System.out.println("Aucun rendez-vous trouvé à la date et l'heure spécifiées. Veuillez prendre un rendez-vous avant d'effectuer une consultation.");
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }
}
