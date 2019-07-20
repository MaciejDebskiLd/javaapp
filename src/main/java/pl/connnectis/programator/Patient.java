package pl.connnectis.programator;

import java.time.LocalDate;
import java.util.Objects;

public class Patient {

    private String name;
    private LocalDate yob; //rok urodzenia


    public Patient(String name, LocalDate yob) {
        this.name = name;
        this.yob = yob;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYob() {
        return yob;
    }

    public void setYob(LocalDate yob) {
        this.yob = yob;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name) &&
                Objects.equals(yob, patient.yob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yob);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", yob=" + yob +
                '}';
    }

//    private String name;
//    private int yob;
//
//    public Patient(String name, int yob) {
//        this.name = name;
//        this.yob = yob;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getYob() {
//        return yob;
//    }
//
//    public void setYob(int yob) {
//        this.yob = yob;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Patient patient = (Patient) o;
//        return yob == patient.yob &&
//                Objects.equals(name, patient.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, yob);
//    }
//
//    @Override
//    public String toString() {
//        return "Patient{" +
//                "name='" + name + '\'' +
//                ", yob=" + yob +
//                '}';
//    }
}
