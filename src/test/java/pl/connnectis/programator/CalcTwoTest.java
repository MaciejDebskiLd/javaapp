package pl.connnectis.programator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CalcTwoTest {

    CalcTwo calcTwo = new CalcTwo();

    @BeforeEach
    void prepareData() {
        System.out.println("Wykonuję inicjalizację danych");
        List<Double> values = new ArrayList<>();

        values.add(1.0);
        values.add(2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0);
        calcTwo.setValues(values);


    }

    @AfterEach
    void cleanUp() {
        System.out.println("Czyszczenie po każdym teście");
        calcTwo.clear();
    }
    @Test
    void checkDividing(){
        assertEquals(10, calcTwo.divide(20, 2));
    }


    @Test
    void checkAdding() {
        assertEquals(5, calcTwo.sum(2, 3));
    }

    @Test
        //Test musi być przy każdej metodzie testującej!!!
    void checkMean() {
        assertEquals(3.0, calcTwo.mean(), () -> {
            System.out.println("Obliczam komunikat dla błędu");
            return "Błąd w obliczaniu średniej";
        });
//LAMBDA WYWOŁA SIĘ TYLKO W RAZIE WYSTĄPIENIA BŁĘDU - TO TZW LENIWA INICJALIZACJA PARAMETRU
    }

    @Test
    @Tag("important")
    void checkStd() {
        System.out.println("testowanie odchylenia");
        assertEquals(1.5811388300841898, calcTwo.std());
    }

    @ParameterizedTest
    @CsvSource({"1,2,1.5", "2,2,2"})
    void checkMeanTwo(double l1, double l2, double result) {
        List<Double> values = new ArrayList<>();
        values.add(l1);
        values.add(l2);
        calcTwo.setValues(values);
        assertEquals(result, calcTwo.mean(), () -> "Błąd w obliczaniu średniej");
    }


    //Parametrized tests pozwalają na nieużywanie beforeEach i AfterEach
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 22, 122})
    void checkIsEven(int l) {
        assertTrue(calcTwo.isEven(l));

    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 21, 89})
    void checkIsOdd(int l) {
        assertFalse(calcTwo.isEven(l));
    }

    @ParameterizedTest
    @CsvSource({"2, 3, 5", "3, 4, 7", "2, 6, 8"})
        //trzecia liczba to result przewidywany
    void checkAdding(int l1, int l2, int result) {
        assertEquals(result, calcTwo.sum(l1, l2));

    }

    @ParameterizedTest//z pliku pobór danych do testu
    @CsvFileSource(resources = "/numbers.csv")
    void chceckAddingFromFile(int l1, int l2, int result) {
        assertEquals(result, calcTwo.sum(l1, l2));

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/even_odd.csv")
//można np zmienić separator w pliku csv - po przecinku za nazwą pliku wpisać delimiter
    void chceckIsEvenFromFile(int l1, boolean result) {
        assertEquals(result, calcTwo.isEven(l1));

    }

    @Test
    void checkTimeout() { //sprawdzanie czasu wykonania metody
        assertTimeout(Duration.ofMillis(10), () -> {
            Thread.sleep(0);
            calcTwo.mean();
        });
    }

    //grupowanie testów

//    @ Test
//    void groupedAssertions(){ //przepisać ze zdjęcia!!!
//        assertAll("True or false adding",
//                () -> assertEquals(2, calcTwo.sum(1,1)));
//        () -> assertEquals(2, calcTwo.sum(1,1)));
//
//    }

}
