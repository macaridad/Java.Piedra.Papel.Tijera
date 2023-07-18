package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.models.Play;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "matchs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer initialPlays;
    @Column
    private Integer remainPlays;
    @Column
    private String winner;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id_match", cascade = CascadeType.ALL) //relación entre tablas de uno a muchos
    @Fetch(FetchMode.SELECT)
    private List<PlayEntity> plays;
}
