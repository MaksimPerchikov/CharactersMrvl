package ru.mrvl.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "comics")
public class Comics {

    @Id
    @GeneratedValue
    private Long idComics;

    @Column(name = "name_comics")
    private String nameComics;

    /*@OneToMany(cascade = CascadeType.ALL) //одному комиксу соответствует множество персонажей
    @JoinColumn(name = "charactersList_id_characters")
    private List<Characters> charactersList;*/
}
