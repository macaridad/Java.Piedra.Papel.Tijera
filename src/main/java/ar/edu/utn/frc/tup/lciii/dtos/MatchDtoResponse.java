package ar.edu.utn.frc.tup.lciii.dtos;

import ar.edu.utn.frc.tup.lciii.models.Play;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDtoResponse {
    private Long id;
    private Integer initialPlays = 10;
    private Integer remainPlays;
    private String winner;
    private List<Play> plays;
}
