package com.trainer.api.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RaportTest {
    @Test
    public void CheckProfileEquals() {
        Raport raport = new Raport();
        String desc = "Meals are too expensive";
        raport.setDescription(desc);
        raport.setType("Comments");

        assertEquals(desc, raport.getDescription());
    }
    @Test
    public void CheckProfileNotEquals() {
        Raport raport = new Raport();
        String desc = "Meals are too expensive";
        raport.setDescription(desc);
        raport.setType("Comments");

        assertNotEquals("Error", raport.getType());
    }
}