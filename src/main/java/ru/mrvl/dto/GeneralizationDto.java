package ru.mrvl.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ComicsCharactersDto {

    private String nameComics;
    private String nameCharacter;
    private String affiliation;
}
