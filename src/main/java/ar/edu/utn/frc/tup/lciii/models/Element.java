package ar.edu.utn.frc.tup.lciii.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public enum Element {
    PIEDRA, PAPEL, TIJERA;

    private static final List<Element> values = Arrays.asList(values());
    public static Element randomElement(){
        return values.get((int)Math.random()*3);
    }
}
