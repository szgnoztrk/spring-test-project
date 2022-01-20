package dev.patika.homework.model;

import dev.patika.homework.model.enumaration.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Genre genre;
    private String releaseYear;
    private String director;
   @OneToMany(mappedBy = "movie")
    private List<Cast> cast;
   @OneToMany
    List<Puan> oylamalarList;
    @ManyToMany
    List<Watchlist> watchlist;


}
