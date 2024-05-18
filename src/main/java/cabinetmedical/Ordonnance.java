package cabinetmedical;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class Ordonnance {
    private List<Medicament> medicaments;
    private Patient patient;
    private Medecin medecin;
    private LocalDate date;


    public Ordonnance(Patient patient, Medecin medecin, LocalDate date) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        this.medicaments = new ArrayList<>();
    }

    public void ajouterMedicament(Medicament medicament) {
        if (!medicaments.contains(medicament)) {
            medicaments.add(medicament);
        }
    }

    public void remplirOrdonnance(Scanner scanner, LocalDate date) {
        boolean continuer = true;
        this.date = date;

        while (continuer) {
            System.out.println("Nom du médicament : ");
            String nom = scanner.nextLine();
            
            System.out.println("Posologie : ");
            String posologie = scanner.nextLine();
            
            Medicament medicament = new Medicament(nom, posologie);
            ajouterMedicament(medicament);

            System.out.println("Voulez-vous ajouter un autre médicament ? (oui/non)");
            String reponse = scanner.nextLine();
            if (!reponse.equals("oui")) {
                continuer = false;
            }
        }
    }

    public void afficherOrdonnance() {
        System.out.println("Ordonnance du " + date + " :");
        for (Medicament medicament : medicaments) {
            System.out.println("Nom du médicament : " + medicament.getNom());
            System.out.println("Posologie : " + medicament.getPosologie());
        }
    }
    

    

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public LocalDate getDate() {
        return date;
    }
}
