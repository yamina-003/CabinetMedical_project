package cabinetmedical;

public class Medecin {
    private String nom; 
    private String prenom; 
    private String specialité; 
    private String motdepasse;
    
    

    public Medecin() {
        this.nom = "BENIA";
        this.prenom = "LAMIR";
        this.specialité = "Ophtalmologue";
        this.motdepasse = "droitacceslimite";
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public String getSpecialité() {
        return specialité;
    }
    public String getMotdePasse() {
        return motdepasse;
    }


    

    

}
