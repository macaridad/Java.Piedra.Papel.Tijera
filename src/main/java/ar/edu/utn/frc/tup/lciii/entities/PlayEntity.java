package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.models.Element;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plays")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Enumerated(EnumType.STRING)
    private Element element1;
    @Column
    @Enumerated(EnumType.STRING)
    private Element element2;
    @Column
    private String result;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchEntity id_match;
}
