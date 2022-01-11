package ru.mrvl.service.interfaces;

import ru.mrvl.model.Characters;
import ru.mrvl.model.Comics;

import java.util.List;

public interface GeneralizationInterface {

    List<Characters> findAllCharacters();
    Characters findByIdCharacter(Long id);
    String addComics(Comics comics);
    String addCharacter(Characters characters);

}
