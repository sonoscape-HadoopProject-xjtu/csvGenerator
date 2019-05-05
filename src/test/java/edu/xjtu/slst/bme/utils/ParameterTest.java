package edu.xjtu.slst.bme.utils;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterTest {

    @Test
    @Ignore
    @DisplayName("Test setClassName() method.")
    void setClassName() {
        Parameter parameter = new Parameter();
        parameter.setClassName("test");
        assertEquals("test", parameter.getClassName(), "Class name should be equal.");
    }
}