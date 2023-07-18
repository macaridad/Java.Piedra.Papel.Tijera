package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.MatchDtoResponse;
import ar.edu.utn.frc.tup.lciii.dtos.MatchDtoResquest;
import ar.edu.utn.frc.tup.lciii.dtos.PlayDto;
import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.entities.PlayEntity;
import ar.edu.utn.frc.tup.lciii.models.Element;
import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public MatchDtoResponse getMatch(Long id) {
        MatchEntity matchEntity = matchRepository.getReferenceById(id);
        return modelMapper.map(matchEntity, MatchDtoResponse.class);
    }

    @Override
    public MatchDtoResponse postMatch(MatchDtoResquest matchdto) {
        MatchEntity matchEntity = modelMapper.map(matchdto, MatchEntity.class);
        matchRepository.save(matchEntity);
        return modelMapper.map(matchEntity, MatchDtoResponse.class);
    }
    public void discountPlays(MatchEntity matchEntity){
        matchEntity.setRemainPlays(matchEntity.getRemainPlays().intValue()-1);
    }
    @Override
    public MatchDtoResponse postPlay(Long idMatch, PlayDto playDto) {
        MatchDtoResponse matchDto = getMatch(idMatch);
        MatchEntity matchEntity = modelMapper.map(matchDto, MatchEntity.class);
        PlayEntity playEntity = modelMapper.map(play(playDto), PlayEntity.class);
        playEntity.setId_match(matchEntity);
        List<PlayEntity> playsList = new ArrayList<>();
        playsList.add(playEntity);
        matchEntity.setPlays(playsList);
        if(matchEntity.getRemainPlays()>0)
        {
            discountPlays(matchEntity);
        }
        MatchEntity matchSaved = matchRepository.saveAndFlush(matchEntity);
        MatchDtoResponse matchToReturn = modelMapper.map(matchSaved, MatchDtoResponse.class);
        return matchToReturn;
    }
    public PlayDto play(PlayDto playDto)
    {
        PlayDto playToSave = playDto;
        if(playDto.getElement1().equals(playDto.getElement2()))
        {
            playToSave.setResult("EMPATE");
        } else if (playDto.getElement1() == Element.PAPEL && playDto.getElement2() == Element.TIJERA) {
            playToSave.setResult(Element.TIJERA.toString());
        } else if (playDto.getElement2() == Element.PAPEL && playDto.getElement1() == Element.TIJERA) {
            playToSave.setResult(Element.TIJERA.toString());
        } else if (playDto.getElement1() == Element.TIJERA && playDto.getElement2() == Element.PIEDRA) {
            playToSave.setResult(Element.PIEDRA.toString());
        } else if (playDto.getElement2() == Element.TIJERA && playDto.getElement1() == Element.PIEDRA) {
            playToSave.setResult(Element.PIEDRA.toString());
        } else if (playDto.getElement1() == Element.PIEDRA && playDto.getElement2() == Element.PAPEL) {
            playToSave.setResult(Element.PAPEL.toString());
        } else if (playDto.getElement2() == Element.PIEDRA && playDto.getElement1() == Element.PAPEL) {
            playToSave.setResult(Element.PAPEL.toString());
        }
        return playToSave;
    }

    public void initMatch(){
        Match match = new Match();
        match.getId();
    }
}
