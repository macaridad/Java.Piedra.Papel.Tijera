package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.PlayEntity;
import ar.edu.utn.frc.tup.lciii.models.Play;
import ar.edu.utn.frc.tup.lciii.repositories.PlayRepository;
import ar.edu.utn.frc.tup.lciii.services.PlayService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayServiceImpl implements PlayService {
    @Autowired
    private PlayRepository playRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public Play getPlay(Long id) {
        PlayEntity playEntity = playRepository.getReferenceById(id);
        return modelMapper.map(playEntity, Play.class);
    }

    @Override
    public Play postPlay(Play play) {
        PlayEntity playEntity = modelMapper.map(play, PlayEntity.class);
        playRepository.save(playEntity);
        return modelMapper.map(playEntity, Play.class);
    }
}
