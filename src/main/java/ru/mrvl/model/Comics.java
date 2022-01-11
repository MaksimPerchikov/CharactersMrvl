package ru.mrvl.model;

import lombok.*;

import javax.persistence.*;

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

    /*@ManyToOne //одному персонажу соответствует множество комиксов
    @JoinColumn(name = "character_id_characters")
    private Characters character;*/
}
