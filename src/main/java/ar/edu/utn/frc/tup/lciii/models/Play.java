package ar.edu.utn.frc.tup.lciii.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Play {
    private Long id;
    private Element element1;
    private Element element2;
    private String result;

    public Element getElement1(){
        return Element.randomElement();
    }
    public Element getElement2(){
        return Element.randomElement();
    }


}
