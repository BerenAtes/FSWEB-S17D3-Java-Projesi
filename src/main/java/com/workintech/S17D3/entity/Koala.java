package com.workintech.S17D3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Koala {
    private int id;
    private String name;
    private double weight;
    private double sleepHour;
    private Gender gender;
}
