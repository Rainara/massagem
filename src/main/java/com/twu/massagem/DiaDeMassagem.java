package com.twu.massagem;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiaDeMassagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String date;
    String tipoDeMassagem;

    public DiaDeMassagem(int id, String date, String tipoDeMassagem) {
        this.id = id;
        this.date = date;
        this.tipoDeMassagem = tipoDeMassagem;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTipoDeMassagem() {
        return tipoDeMassagem;
    }
}
