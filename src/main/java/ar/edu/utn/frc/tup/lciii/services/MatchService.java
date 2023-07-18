package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.MatchDtoResponse;
import ar.edu.utn.frc.tup.lciii.dtos.MatchDtoResquest;
import ar.edu.utn.frc.tup.lciii.dtos.PlayDto;
import org.springframework.stereotype.Service;

@Service
public interface MatchService {
    MatchDtoResponse getMatch(Long id);
    MatchDtoResponse postMatch(MatchDtoResquest matchDto);
    MatchDtoResponse postPlay(Long idMatch, PlayDto playDto);
}
