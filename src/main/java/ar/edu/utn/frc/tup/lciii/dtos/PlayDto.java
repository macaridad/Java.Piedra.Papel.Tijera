package ar.edu.utn.frc.tup.lciii.dtos;

import ar.edu.utn.frc.tup.lciii.models.Element;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayDto {
    private Element element1;
    private Element element2;
    private String result;
}
