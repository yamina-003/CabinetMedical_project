package cabinetmedical;

import java.util.ArrayList;
import java.util.List;

public class GestionPatients {

    private static List<Patient> patients = new ArrayList<>();

    public static boolean ajouterPatient(Patient patient){
        if(! existePatient(patient)){
            patients.add(patient);
            return true;
        }
        return false;
      
    }

    public static boolean existePatient(Patient patient) {
        return patients.contains(patient);
    }

    public static boolean supprimerPatient(Patient patient) {
        return patients.remove(patient);
    }

    public static Patient rechercherPatient(String nom, String prenom) {
        for (Patient patient : patients) {
            if (patient.getNom().equals(nom) && patient.getPrenom().equals(prenom)) {
                return patient;
            }
        }
        return null;
    }

}
