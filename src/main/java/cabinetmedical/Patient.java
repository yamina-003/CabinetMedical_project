package cabinetmedical;


import java.util.List;


public class Patient {
    private String nom;
    private String prenom;
    private DossierMedical dossierMedical;



    public Patient(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical){
        this.dossierMedical = dossierMedical;
    }

    public void afficherDossierMedical(Patient patient) {
        System.out.println("Dossier médical de " + patient.getNom() + " " + patient.getPrenom());
        DossierMedical dossierMedical = patient.getDossierMedical();
        if (dossierMedical != null) {
            System.out.println("Fiches patients :");
            for (FichePatient fiche : dossierMedical.getFichesPatient()) {
                System.out.println("Antécédents médicaux : " + fiche.getAntecedentsMedicaux());
                System.out.println("Antécédents chirurgicaux : " + fiche.getAntecedentsChirurgicaux());
                System.out.println("Données du terrain : " + fiche.getDonneesTerrain());
                System.out.println("Observations : "+ fiche.getObservations());
            }
    
            List<Ordonnance> ordonnances = dossierMedical.getOrdonnances();
                System.out.println("Ordonnances :");
                for (Ordonnance ordonnance : ordonnances) {
                    ordonnance.afficherOrdonnance();
                } 
        } else {
                System.out.println("Aucun dossier médical trouvé.");
        }
                 
    }
    

}
    
