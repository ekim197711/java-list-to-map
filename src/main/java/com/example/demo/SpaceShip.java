package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpaceShip {
    private String captain;
    private double fuel;
    private String model;

}
