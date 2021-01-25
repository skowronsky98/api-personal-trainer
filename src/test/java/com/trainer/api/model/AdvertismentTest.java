package com.trainer.api.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdvertismentTest {

    @Test
    public void AdvertActiveTrue() {
        Advertisment advert = new Advertisment();
        advert.setActive(true);
        advert.setPrice(100d);
        advert.setDescription("testing");

        assertEquals(true, advert.getActive());
    }

    @Test
    public void AdvertCheckPrice() {
        Advertisment advert = new Advertisment();
        advert.setActive(true);
        advert.setPrice(100d);
        advert.setDescription("testing");

        assertEquals(100, advert.getPrice());
    }

    @Test
    public void AdvertCheckDescription() {
        Advertisment advert = new Advertisment();
        advert.setActive(true);
        advert.setPrice(100d);
        advert.setDescription("testing");

        assertNotNull(advert.getDescription());
    }
}