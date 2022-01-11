package ru.mrvl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mrvl.dto.GeneralizationDto;
import ru.mrvl.model.Characters;
import ru.mrvl.model.Comics;
import ru.mrvl.model.Generalization;
import ru.mrvl.repository.CharactersRepository;
import ru.mrvl.repository.ComicsRepository;
import ru.mrvl.repository.GeneralizationRepository;
import ru.mrvl.service.interfaces.GeneralizationInterface;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GeneralizationInterfaceImpl implements GeneralizationInterface {

    private final CharactersRepository charactersRepository;
    private final ComicsRepository comicsRepository;
    private final GeneralizationRepository generalizationRepository;

    @Autowired
    public GeneralizationInterfaceImpl(CharactersRepository charactersRepository,
                                       ComicsRepository comicsRepository,
                                       GeneralizationRepository generalizationRepository) {
        this.charactersRepository = charactersRepository;
        this.comicsRepository = comicsRepository;
        this.generalizationRepository = generalizationRepository;
    }

    @Override
    public List<Characters> findAllCharacters() {
        List<Characters> charactersList = charactersRepository.findAll();
        return charactersList.stream()
                .collect(Collectors.toList());
    }

    @Override
    public Object findByIdCharacter(Long id) {
        try{
            List<Characters> charactersList =
                    charactersRepository.findAll();
            Optional<Characters> charactersOptional =
                    charactersList.stream()
                            .filter(f -> f.getIdCharacters().equals(id))
                            .findFirst();

            Characters finder = charactersOptional.get();
            return finder;
        }catch (Exception e) {
           return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String addComics(Comics comics) {
        try{
            comicsRepository.save(comics);
            String goodCo = "Добавление комикса прошло успешно!";
            return goodCo;
        }catch(Exception e){
            String t = new ResponseEntity<>(HttpStatus.BAD_REQUEST).toString();
            return t;
        }
    }

    @Override
    public String addCharacter(Characters characters) {
        try{
            charactersRepository.save(characters);
            String goodCh = "Добавление персонажа прошло успешно!";
            return goodCh;
        }catch (Exception e) {
         /*String t = new ResponseEntity<>(HttpStatus.BAD_REQUEST).toString();
         return t;*/
            return null;
        }
    }

    @Override
    public Generalization converterDtoToEntity(GeneralizationDto generalizationDto) {
        return null;
    }

    @Override
    public Generalization converterEntityToDto(Generalization generalization) {
        return null;
    }

    @Override
    public List<Comics> findAllComics() {
        List<Comics> comicsList =
                comicsRepository.findAll();

        return comicsList.stream().collect(Collectors.toList());
    }

    @Override
    public Object findByIdComics(Long id) {
        try{
            List<Comics> comicsList =
                    comicsRepository.findAll();
            Optional<Comics> comicsOptional =
                    comicsList.stream()
                            .filter(e -> e.getIdComics().equals(id))
                            .findFirst();
            Comics comicsFind = comicsOptional.get();
            return comicsFind;

        }catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public List<Comics> sortedByNameComics() {
        List<Comics> comicsLinkedList =
                comicsRepository.findAll();
        List<Comics> sort =
                comicsLinkedList.stream()
                        .sorted(
                                Comparator.comparing(Comics::getNameComics)
                        )
                        .collect(Collectors.toList());
        return sort;
    }

    @Override
    public List<Comics> sortedByIdAscendingComics() {
        List<Comics> comicsLinkedList =
                comicsRepository.findAll();
        List<Comics> sort =
                comicsLinkedList.stream()
                        .sorted(
                                Comparator.comparing(Comics::getIdComics)
                        )
                        .collect(Collectors.toList());
        return sort;

    }

    @Override
    public List<Comics> sortedByIdDescendingComics() {
        List<Comics> comicsLinkedList =
                comicsRepository.findAll();
        List<Comics> sort =
                comicsLinkedList.stream()
                        .sorted(
                                Comparator.comparing(Comics::getIdComics)
                                        .reversed()
                        )
                        .collect(Collectors.toList());
        return sort;
    }


    @Override
    public void sortedByNameCharacter() {

    }

    @Override
    public List<Characters> sortedByIdAscendingCharacters() {
        List<Characters> charactersList =
                charactersRepository.findAll();
        List<Characters> sort =
                charactersList.stream()
                        .sorted(
                                Comparator.comparing(Characters::getIdCharacters)
                        )
                        .collect(Collectors.toList());
        return sort;

    }

    @Override
    public List<Characters> sortedByIdDescendingCharacters() {
        List<Characters> charactersList =
                charactersRepository.findAll();
        List<Characters> sort =
                charactersList.stream()
                        .sorted(
                                Comparator.comparing(Characters::getIdCharacters)
                                        .reversed()
                        )
                        .collect(Collectors.toList());
        return sort;
    }

    @Override
    public List<Characters> sortedByNameCharacters() {
        List<Characters> charactersList =
                charactersRepository.findAll();

        List<Characters> sort =
                charactersList.stream()
                        .sorted(Comparator.comparing(Characters::getNameCharacter))
                        .collect(Collectors.toList());
        return sort;
    }
}
