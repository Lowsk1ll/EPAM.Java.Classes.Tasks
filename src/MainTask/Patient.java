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

    public static void main(String[] args) {
        ArrayList<Patient> patients = Patient.createPatientList();
        Patient.addPatient(new Patient(BigInteger.valueOf(1),"Иванов","Иван","Иванович","Москва,ул.Пушкина",BigInteger.valueOf(2147483647),"Ангина"),patients);
        Patient.addPatient(new Patient(BigInteger.valueOf(2),"Захаров","Иван","Иванович","Москва,ул.Минина",BigInteger.valueOf(2147483645),"Ангина"),patients);
        Patient.addPatient(new Patient(BigInteger.valueOf(3),"Сорокин","Иван","Иванович","Москва,ул.Горького",BigInteger.valueOf(2147483643),"Простуда"),patients);
        Patient.addPatient(new Patient(BigInteger.valueOf(4),"Чернов","Иван","Иванович","Москва,ул.Бекетова",BigInteger.valueOf(2147483641),"Перелом"),patients);
        System.out.println("Список пациентов");
        for (Patient patient:patients) {
            System.out.println(patient.toString());

        }
        String diagnosis = "Ангина";
        System.out.println("\nСписок пациантов имеющих "+ diagnosis);
        ArrayList<Patient> patientsWithSameDiagnosis = Patient.getPatientListWithSameDiagnosis(diagnosis,patients);
        for (Patient patient:patientsWithSameDiagnosis) {
            System.out.println(patient.toString());
        }
        BigInteger leftBorder = BigInteger.valueOf(2147483640);
        BigInteger rightBorder = BigInteger.valueOf(2147483644);
        System.out.println("\nСписок пациентов имеющих номер мед карты в диапозоне ("+ leftBorder+ ";"+ rightBorder+")");
        ArrayList<Patient> patientsListWithSameMedCardNumberRange = Patient.getPatientListWithSameMedCardNumberRange(leftBorder,rightBorder,patients);
        for (Patient patient:patientsListWithSameMedCardNumberRange) {
            System.out.println(patient.toString());

        }
    }
}



