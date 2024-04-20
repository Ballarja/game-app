package com.GameApp.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gameDescription;
    private int timePlayed;

}
