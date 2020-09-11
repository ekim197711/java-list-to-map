package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SpaceShipService {
    private List<SpaceShip> ships;
    Map<String, SpaceShip> captainShipMap = null;

    {
        ships = List.of(
                SpaceShip.builder().captain("Mike").fuel(25.0).model("Round").build(),
                SpaceShip.builder().captain("Susan").fuel(35.0).model("Box").build(),
                SpaceShip.builder().captain("Rikke").fuel(15.0).model("Round").build(),
                SpaceShip.builder().captain("Harriet").fuel(26.0).model("Pyramid").build(),
                SpaceShip.builder().captain("Janet").fuel(29.0).model("Round").build(),
                SpaceShip.builder().captain("Mette").fuel(99.0).model("Pyramid").build()
        );
    }

    private Map<String, SpaceShip> captainShipMap() {
        if (captainShipMap == null) {
            captainShipMap = ships.stream().collect(
                    Collectors.toMap(
                            SpaceShip::getCaptain,
                            v -> v
                    )
            );
        }
        return captainShipMap;
    }

    public SpaceShip whereIsCaptain(String captain) {
        return captainShipMap().get(captain);
    }
}
