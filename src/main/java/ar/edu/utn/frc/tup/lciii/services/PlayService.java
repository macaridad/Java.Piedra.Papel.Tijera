package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.Play;
import org.springframework.stereotype.Service;

@Service
public interface PlayService {
    Play getPlay(Long id);
    Play postPlay(Play play);
}
