package com.twu.massagem.model;



import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class MassageDay {

    private int id;
    private LocalDate date;
    public String massageType;

    public String getMassageType() {
        return massageType;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public MassageDay(LocalDate date, String massageType) {
        this.date = date;
        this.massageType = massageType;
    }


}
