package edu.cs.cs590.webshop.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class UniversityFairTest {
    @InjectMocks
    UniversityFair universityFair;

    @BeforeEach
    void setUp() {
        universityFair = new UniversityFair();
    }

    @AfterEach
    void tearDown() {
        universityFair = null;
    }

    @Test
    void universityCareerFair() {
        int[] arrival = {1,3,3,5,7};
        int[] duration = {2,2,1,2,1};
        assertEquals(4, universityFair.universityCareerFair(arrival, duration));
    }
}
