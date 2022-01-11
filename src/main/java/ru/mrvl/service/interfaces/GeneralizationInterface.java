package ru.mrvl.service.interfaces;

import ru.mrvl.dto.GeneralizationDto;
import ru.mrvl.model.Characters;
import ru.mrvl.model.Comics;
import ru.mrvl.model.Generalization;

import java.util.List;

public interface GeneralizationInterface {

    List<Characters> findAllCharacters();
    Object findByIdCharacter(Long id);
    String addComics(Comics comics);
    String addCharacter(Characters characters);
    List<Comics> findAllComics();
    Object findByIdComics(Long id);


    Generalization converterDtoToEntity(GeneralizationDto generalizationDto);
    Generalization converterEntityToDto(Generalization generalization);


    List<Comics> sortedByIdAscendingComics();
    List<Comics> sortedByIdDescendingComics();
    List<Comics> sortedByNameComics();

    List<Characters> sortedByIdAscendingCharacters();
    List<Characters> sortedByIdDescendingCharacters();
    List<Characters> sortedByNameCharacters();
   
}
