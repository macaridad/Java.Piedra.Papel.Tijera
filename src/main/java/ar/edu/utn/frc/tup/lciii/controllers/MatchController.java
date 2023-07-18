package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.MatchDtoResponse;
import ar.edu.utn.frc.tup.lciii.dtos.MatchDtoResquest;
import ar.edu.utn.frc.tup.lciii.dtos.PlayDto;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matchs")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @GetMapping("/{id}")
    public ResponseEntity<MatchDtoResponse> getMatch(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatch(id));
    }

    @PostMapping("")
    public ResponseEntity<MatchDtoResponse> postMatch(@RequestBody MatchDtoResquest matchDto) {
        return ResponseEntity.ok(matchService.postMatch(matchDto));
    }

    @PostMapping("/{id}/play")
    public ResponseEntity<MatchDtoResponse> postPlay(@PathVariable Long id, @RequestBody PlayDto playDto) {
        return ResponseEntity.ok(matchService.postPlay(id, playDto));
    }
}
