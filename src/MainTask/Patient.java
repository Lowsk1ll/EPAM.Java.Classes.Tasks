package MainTask;

import java.math.BigInteger;
import java.util.ArrayList;

public class Patient {
    private BigInteger id;
    private String surname;
    private String name;
    private String middlename;
    private String adress;
    private BigInteger medCardNumber;
    private String diagnosis;

    public Patient() {
    }

    public Patient(BigInteger id, String surname, String name, String middlename, String adress, BigInteger medCardNumber, String diagnosis) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.adress = adress;
        this.medCardNumber = medCardNumber;
        this.diagnosis = diagnosis;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public BigInteger getMedCardNumber() {
        return medCardNumber;
    }

    public void setMedCardNumber(BigInteger medCardNumber) {
        this.medCardNumber = medCardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient:" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middlename='" + middlename + '\'' +
                ", adress='" + adress + '\'' +
                ", medCardNumber=" + medCardNumber +
                ", diagnosis='" + diagnosis + '\'' ;
    }

    public static ArrayList<Patient> createPatientList() {
        ArrayList<Patient> patientsList = new ArrayList<>();
        return patientsList;
    }


    public static void addPatient(Patient patient, ArrayList<Patient> patientsList) {
        patientsList.add(patient);
    }

    public static ArrayList<Patient> getPatientListWithSameDiagnosis(String diagnosis, ArrayList<Patient> patientsList) {
        ArrayList<Patient> patientListWithSameDiagnosis = new ArrayList<>();
        for (Patient patient : patientsList) {
            if (patient.getDiagnosis().contains(diagnosis)) {
                addPatient(patient,patientListWithSameDiagnosis);
            }
        }
        return patientListWithSameDiagnosis;
    }

    public static ArrayList<Patient> getPatientListWithSameMedCardNumberRange(BigInteger LeftBorder, BigInteger RightBorder, ArrayList<Patient> patientsList) {
        ArrayList<Patient> patientListWithSameMedCardNumberRange = new ArrayList<>();
        for (Patient patient : patientsList) {
            if (patient.getMedCardNumber().compareTo(LeftBorder) > 0 && patient.getMedCardNumber().compareTo(RightBorder) < 0) {
                addPatient(patient,patientListWithSameMedCardNumberRange);
            }
        }
        return patientListWithSameMedCardNumberRange;
    }
}



