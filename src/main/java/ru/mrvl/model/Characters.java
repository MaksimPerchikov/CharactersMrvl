package ru.mrvl.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "characters")
public class Characters {

    @Id
    @GeneratedValue
    private Long idCharacters;

    @Column(name = "name_character")
    private String nameCharacter;

    @Column(name = "affiliation")
    private String affiliation;

}
