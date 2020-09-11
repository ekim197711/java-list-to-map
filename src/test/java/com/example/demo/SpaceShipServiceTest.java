package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceShipServiceTest {

    @Test
    public void whereIsCaptain() {
        SpaceShip mike = new SpaceShipService().whereIsCaptain("Mike");
        System.out.println("SpaceShip returned: " + mike);
        Assertions.assertNotNull(mike);
        Assertions.assertEquals("Round", mike.getModel());
        Assertions.assertEquals("Mike", mike.getCaptain());
        Assertions.assertEquals(25.0, mike.getFuel());
    }
}