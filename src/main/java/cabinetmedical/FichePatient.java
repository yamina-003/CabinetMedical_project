package cabinetmedical;

public class FichePatient {
    private Patient patient;
    private String antecedentsMedicaux;
    private String antecedentsChirurgicaux;
    private String donneesTerrain;
    private String observations;

    public FichePatient(Patient patient, String antecedentsMedicaux, String antecedentsChirurgicaux, String donneesTerrain, String observations) {
        this.patient = patient;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.antecedentsChirurgicaux = antecedentsChirurgicaux;
        this.donneesTerrain = donneesTerrain;
        this.observations = observations;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(String antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    public String getAntecedentsChirurgicaux() {
        return antecedentsChirurgicaux;
    }

    public void setAntecedentsChirurgicaux(String antecedentsChirurgicaux) {
        this.antecedentsChirurgicaux = antecedentsChirurgicaux;
    }

    public String getDonneesTerrain() {
        return donneesTerrain;
    }

    public void setDonneesTerrain(String donneesTerrain) {
        this.donneesTerrain = donneesTerrain;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    
}
