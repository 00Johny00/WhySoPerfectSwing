package com.mycompany.doskonala.View;

import com.mycompany.doskonala.Model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private static final String MESSAGE_FOR_ENTER_LOWER_COMPARTMENT = "Please Enter Lower Compartment";
    private static final String MESSAGE_FOR_ENTER_HIGHER_COMPARTMENT = "Please Enter Higher Compartment";
    private static final String MESSAGE_FOR_RESULTS = "Perfect Numbers are: \n";

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private View view;


}