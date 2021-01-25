package com.trainer.api.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {
    @Test
    public void CheckProfileEquals() {
        Profile profile = new Profile("Tomasz", "Wcislo", 23, "bio");

        assertEquals(23, profile.getAge());
    }
    @Test
    public void CheckProfileNotEquals() {
        Profile profile = new Profile("Tomasz", "Wcislo", 23, "bio");

        assertNotEquals("Mateusz", profile.getFirstname());
    }
}