package Sekcja10_WyjatkiIAseracje.Asercje;

import java.io.IOException;

public class Calculator {

    public void calculate(String var) {
        assert var != null : "Unexpected error (assert)";

        //to samo co

        if (var == null) {
            throw new AssertionError("Unexpected error (if)");
        }
    }
}