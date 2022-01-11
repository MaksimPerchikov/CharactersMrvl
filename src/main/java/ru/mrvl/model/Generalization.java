package ru.mrvl.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "generalization")
public class Generalization {
    @Id
    @GeneratedValue
    private Long id;


   /* @ManyToOne
    @JoinColumn(name = "comics_id_comics")
    private Comics comics;

    @ManyToOne
    @JoinColumn(name = "characters_id_characters")
    private Characters characters;*/

}
