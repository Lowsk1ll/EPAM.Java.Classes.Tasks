package MainTask;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Patient> patients = Patient.createPatientList();
        Patient.addPatient(new Patient(1,"Иванов","Иван","Иванович","Москва,ул.Пушкина",2147483647,"Ангина"),patients);
        Patient.addPatient(new Patient(2,"Захаров","Иван","Иванович","Москва,ул.Минина",2147483645,"Ангина"),patients);
        Patient.addPatient(new Patient(3,"Сорокин","Иван","Иванович","Москва,ул.Горького",2147483643,"Простуда"),patients);
        Patient.addPatient(new Patient(4,"Чернов","Иван","Иванович","Москва,ул.Бекетова",2147483641,"Перелом"),patients);
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
        long leftBorder = 2147483640;
        long rightBorder = 2147483644;
        System.out.println("\nСписок пациентов имеющих номер мед карты в диапозоне ("+ leftBorder+ ";"+ rightBorder+")");
        ArrayList<Patient> patientsListWithSameMedCardNumberRange = Patient.getPatientListWithSameMedCardNumberRange(leftBorder,rightBorder,patients);
        for (Patient patient:patientsListWithSameMedCardNumberRange) {
            System.out.println(patient.toString());

        }
    }
}
