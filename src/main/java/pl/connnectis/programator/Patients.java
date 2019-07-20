package pl.connnectis.programator;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Patients implements PatientManager {

    List<Patient> patients = new ArrayList<>();


    public Patients() {
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void clean() {
        patients.clear();
    }

    @Override
    public boolean addPatient(Patient patient) throws TooManyPatients {

        long differYears = ChronoUnit.YEARS.between(patient.getYob(), LocalDate.now());

        if (patients.size() >= 5) {
            throw new TooManyPatients();
        } else if (patients.contains(patient)) {
            return false;

        } else if (differYears > 200 || differYears < 0) {
            return false;

        } else {
            patients.add(patient);
            return true;
        }
    }

    @Override
    public List<Patient> sortByName() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return patients;
    }

    @Override
    public List<Patient> sortByYob() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                return o1.getYob().compareTo(o2.getYob());
            }
        });
        return patients;
    }

    @Override
    public List<Patient> findOlderThan(int year) {
        List<Patient> olderThan = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getYob().getYear() < year) {
                olderThan.add(patient);
            }
        }
        return olderThan;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patients patients1 = (Patients) o;
        return Objects.equals(patients, patients1.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patients);
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patients=" + patients +
                '}';
    }

    public int helper() {
        return patients.size();
    }
}

