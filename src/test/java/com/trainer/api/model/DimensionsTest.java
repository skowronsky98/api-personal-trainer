package com.trainer.api.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DimensionsTest {

    @Test
    public void CheckDimensionsEqual(){
        Dimensions dimensions = new Dimensions(15, 20, 30, 40, 50 , 60);

        assertEquals(20, dimensions.getArm());
    }

    @Test
    public void CheckDimensionsNotEqual(){
        Dimensions dimensions = new Dimensions(15, 20.5, 30, 40, 50 , 60);

        assertNotEquals(20, dimensions.getArm());
    }
}