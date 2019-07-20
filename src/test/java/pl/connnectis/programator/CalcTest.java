package pl.connnectis.programator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class CalcTest {

    // System Under Test -> STU
    Calc calc = new Calc();
//    CalcTwo calcTwo = new CalcTwo();

//    @BeforeEach
//    void prepareData(){
//        System.out.println("Wykonuję inicjalizację danych");
//        List<Double> values = new ArrayList<>();
//
//        values.add(1.0);
//        values.add(2.0);
//        values.add(3.0);
//        values.add(4.0);
//        values.add(5.0);
//        calcTwo.setValues(values);
//
//
//    }
//
//    @AfterEach
//    void cleanUp(){
//        System.out.println("Czyszczenie po każdym teście");
//        calcTwo.clear();
//    }


    @Test
    void checkAdding(){
        assertEquals(5, calc.sum(2, 3));
    }

    @Test //Test musi być przy każdej metodzie testującej!!!
    void checkMean(){
        List<Double> values = new ArrayList<>();

        values.add(1.0);
        values.add(2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0);
        assertEquals(3.0, calc.mean(values), ()->{
            System.out.println("Obliczam komunikat dla błędu");
            return "Błąd w obliczaniu średniej";
        });
//LAMBDA WYWOŁA SIĘ TYLKO W RAZIE WYSTĄPIENIA BŁĘDU - TO TZW LENIWA INICJALIZACJA PARAMETRU
    }


    }

