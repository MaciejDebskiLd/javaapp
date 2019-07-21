package pl.connnectis.programator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class PatientsTest {

    static Patients patients = new Patients();
    //    static Patients checklistPatiens = new Patients();
    PatientManager pm = new Patients(); // jeżeli będziemy testować takie pm, to sprawdzamy tylko metody będące częścią interfejsu!!

    @BeforeEach
    void prepareData() {

        Patient patient1 = new Patient("Adam", LocalDate.parse("1990-05-12"));
        Patient patient2 = new Patient("Wanda", LocalDate.parse("1980-02-12"));
        Patient patient3 = new Patient("Krzysztof", LocalDate.parse("1960-05-12"));
        Patient patient4 = new Patient("Robert", LocalDate.parse("1985-03-14"));
        Patient patient5 = new Patient("Anna", LocalDate.parse("1997-11-01"));

        Collections.addAll(patients.getPatients(), patient1, patient2, patient3, patient4, patient5);
//        Collections.addAll(checklistPatiens.getPatients(), patient1, patient2, patient3, patient4, patient5);
    }

    @AfterEach
    void clear() {
        patients.clean();
    }


//    @Test
//    @DisplayName("Test dodawania pacjenta, jest komplet 5")
//    void checkAddingComplete(){
//        assertEquals(false, patients.addPatient(new Patient("Robert", LocalDate.parse("2000-01-01"))));
//    }

//    @Test
//    @DisplayName("Test dodawania pacjenta, jest za stary")
//    void checkAddingOld() throws TooManyPatients {
//        assertEquals(false, patients.addPatient(new Patient("Robert", LocalDate.parse("1999-01-01"))));
//    }

//    @Test
//    @DisplayName("Test dodawania pacjenta, jest 4 pacjentow")
//    void checkAddingIncomplete(){
//        patients.getPatients().remove(0);
//        assertEquals(true, patients.addPatient(new Patient("Robert", LocalDate.parse("2000-01-01"))));
//
//    }

    @Test
    @DisplayName("Test sortowania wg name")
    void checkSortByName() {
        patients.sortByName();
        assertEquals("Adam", patients.getPatients().get(0).getName());
        assertEquals("Anna", patients.getPatients().get(1).getName());
        assertEquals("Krzysztof", patients.getPatients().get(2).getName());
        assertEquals("Robert", patients.getPatients().get(3).getName());
        assertEquals("Wanda", patients.getPatients().get(4).getName());
    }

    @Test
    @DisplayName("Test sortowania wg daty urodzenia")
    void checkSortByYod() {
        patients.sortByYob();
        assertEquals(LocalDate.parse("1960-05-12"), patients.getPatients().get(0).getYob());
        assertEquals(LocalDate.parse("1980-02-12"), patients.getPatients().get(1).getYob());
        assertEquals(LocalDate.parse("1985-03-14"), patients.getPatients().get(2).getYob());
        assertEquals(LocalDate.parse("1990-05-12"), patients.getPatients().get(3).getYob());
        assertEquals(LocalDate.parse("1997-11-01"), patients.getPatients().get(4).getYob());
    }

    @Test
    void checkTooManyPatientException() throws TooManyPatients {
        assertThrows(TooManyPatients.class, () -> patients.addPatient(new Patient("Roman", LocalDate.parse("2000-01-01"))));

        pm.addPatient(new Patient("Bolek", LocalDate.parse("1990-05-12")));//fragment do sprawdzenia pm - metody z interfejsu
        pm.addPatient(new Patient("Zuza", LocalDate.parse("1990-05-12")));

        assertEquals(2, ((Patients) pm).helper());

    }

    @Test
    void checkIterable() {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient("Bolek", LocalDate.parse("1990-05-12")));
        patientList.add(new Patient("Lolek", LocalDate.parse("1990-05-12")));
        patientList.add(new Patient("Tola", LocalDate.parse("1990-05-12")));

        List<Patient> checklistPatients = new ArrayList<>();
        checklistPatients.add(new Patient("Bolek", LocalDate.parse("1990-05-12")));
        checklistPatients.add(new Patient("Lolek", LocalDate.parse("1990-05-12")));
        checklistPatients.add(new Patient("Tola", LocalDate.parse("1990-05-12")));


        assertIterableEquals(patientList, checklistPatients);
    }

    @Test
    void checkFindingOlderThan() {
        assertThat(patients.getPatients()).filteredOn(patient -> patient.getYob().isBefore(LocalDate.of(2000, 1, 1)))
                .containsOnlyElementsOf(patients.findOlderThan(2000));

    }


//    @ParameterizedTest
//    @CsvFileSource(resources = "patients.csv")
//    void checkAddPatientFromFile (String n, int y, boolean result){
//        assertTrue(result, patients.addPatient(new Patient(n, y));
//    }

}
