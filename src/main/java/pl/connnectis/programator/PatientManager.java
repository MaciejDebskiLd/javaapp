package pl.connnectis.programator;

import java.util.List;

public interface PatientManager {

    //baza max 5 pacjentów
    //wyrzuca wyjątek TooMany Patients jeśli przekroczy rozmiar 5
    //zwraca false jeśli próbujemy dodać pacjenta, który istnieje
    //przyjąć wiek pacjenta (0,200)

    public boolean addPatient(Patient patient) throws TooManyPatients;

    public List<Patient> sortByName();

    public List<Patient> sortByYob();

    public List<Patient> findOlderThan(int year); //filtred on , contains only


}
