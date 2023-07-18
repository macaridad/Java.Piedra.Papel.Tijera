package ar.edu.utn.frc.tup.lciii.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDtoResquest {
    private Integer initialPlays = 10;
    private Integer remainPlays;
    private String winner;
}
