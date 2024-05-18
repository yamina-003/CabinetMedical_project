package cabinetmedical;

import java.util.ArrayList;
import java.util.List;

public class DossierMedical {
    private Patient patient;
    private List<FichePatient> fichesPatient;
    private List<Ordonnance> ordonnances;

    public DossierMedical(Patient patient) {
        this.patient = patient;
        this.fichesPatient = new ArrayList<>();
        this.ordonnances = new ArrayList<>();
    }

    public void ajouterFichePatient(FichePatient fichePatient) {
        fichesPatient.add(fichePatient);
    }

    public void ajouterOrdonnance(Ordonnance ordonnance) {
        ordonnances.add(ordonnance);
    }

    public Patient getPatient() {
        return patient;
    }

    public List<FichePatient> getFichesPatient() {
        return fichesPatient;
    }

    public List<Ordonnance> getOrdonnances() {
        return ordonnances;
    }
    

    

    
}
