package com.mycompany.doskonala.Model;

import com.mycompany.doskonala.Controller.Controller;
import com.mycompany.doskonala.Controller.ControllerExceptionHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
/**
 *
 * @author
 * @version 1
 */
    /**
     Class of ModelTest */
    private static final String EXCEPTION_MESSAGE = "Wrong typed compartments. Compartment should be higher then 0, and lower must be lower then higher";
    private Model model;

    @BeforeEach
    void beforeEach(){
        model = new Model();
    }

    /**
     Testing function findPerfectNumberBetweenLowerAndHigher with happy path*/
    @ParameterizedTest
    @CsvSource({"1,500" , "1,1000"})
    void findCorrectPerfectNumberBetweenLowerAndHigher(int lower, int higher) throws ControllerExceptionHandler {

        List results;
        List expectedResults = new ArrayList();
        expectedResults.add(0,6);
        expectedResults.add(1, 28);
        expectedResults.add(2, 496);

        results = model.findPerfectNumberBetweenLowerAndHigher(lower,higher);
        assertEquals(expectedResults, results);
    }
    /**
     Testing function findPerfectNumberBetweenLowerAndHigher with wrong parameter*/
    @ParameterizedTest
    @CsvSource({"1,100" , "900,1000",})
    void findWrongPerfectNumberBetweenLowerAndHigher(int lower, int higher) throws ControllerExceptionHandler {
        List results;
        List expectedResults = new ArrayList();
        expectedResults.add(0,6);
        expectedResults.add(1, 28);
        expectedResults.add(2, 496);

        results = model.findPerfectNumberBetweenLowerAndHigher(lower,higher);
        assertNotEquals(expectedResults, results);
    }

    /**
     Testing function findPerfectNumberBetweenLowerAndHigher with wrong parameter that throw error*/
    @ParameterizedTest
    @CsvSource({"100,100" , "144,5",})
    void shouldThrowExceptionAtWrongLowerAndHigherCompartments(int lower, int higher) {
        var exceptionHandler = assertThrows(ControllerExceptionHandler.class, () -> {
            model.findPerfectNumberBetweenLowerAndHigher(lower,higher);
        });
        assertEquals(EXCEPTION_MESSAGE, exceptionHandler.getMessage());
    }

    /**
     Testing function isPerfect with happy path*/
    @ParameterizedTest
    @ValueSource(ints = {6,28,496})
    void shouldIsPerfectCorrect(int number) {

        assertEquals(model.isPerfect(number),true);
    }
    /**
     Testing function isPerfect false with not perfect numbers*/
    @ParameterizedTest
    @ValueSource(ints = {3,8,46,444})
    void shouldIsPerfectWrong(int number) {
       assertFalse(model.isPerfect(number));
    }


    /**
     Testing function checkLowerCompartments with wrong parameter that throw error*/
    @ParameterizedTest
    @ValueSource(ints = {0,-1,-555})
    void shouldThrowExceptionAtWrongLowerCompartments(int lower) {
        var exceptionHandler = assertThrows(ControllerExceptionHandler.class, () -> {
            model.checkLowerCompartments(lower);
        });
        assertEquals(EXCEPTION_MESSAGE, exceptionHandler.getMessage());
    }
    /**
     Testing function checkHigherCompartments with wrong parameter that throw error*/
    @ParameterizedTest
    @ValueSource(ints = {0,-4,-777})
    void shouldThrowExceptionAtWrongHigherCompartments(int higher) {
        var exceptionHandler = assertThrows(ControllerExceptionHandler.class, () -> {
            model.checkHigherCompartments(higher);
        });
        assertEquals(EXCEPTION_MESSAGE, exceptionHandler.getMessage());
    }
}