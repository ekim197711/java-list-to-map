package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SpaceShipService {
    private List<SpaceShip> ships;
    Map<String, SpaceShip> captainShipMap = null;

    {
        ships = List.of(
                SpaceShip.builder().captain("Mike").fuel(55.0).model("Round").build(),
                SpaceShip.builder().captain("Susan").fuel(65.0).model("Box").build(),
                SpaceShip.builder().captain("Rikke").fuel(55.0).model("Round").build(),
                SpaceShip.builder().captain("Harriet").fuel(76.0).model("Pyramid").build(),
                SpaceShip.builder().captain("Janet").fuel(29.0).model("Round").build(),
                SpaceShip.builder().captain("Mette").fuel(19.0).model("Pyramid").build()
        );
    }

    public SpaceShip nextSpaceShipToRefuel() {
        Optional<SpaceShip> optionalSpaceShip = ships.parallelStream()
                .peek(spaceship -> log.info("SpaceShip to evaluate: " + spaceship))
                .filter(spaceship -> spaceship.getFuel() < 50.0d)
                .findAny();
        if (optionalSpaceShip.isEmpty())
            throw new IllegalStateException("No more ships needs refuelling");

        return optionalSpaceShip.get();

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
