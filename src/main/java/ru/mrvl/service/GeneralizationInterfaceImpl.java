package ru.mrvl.service;

import com.mysql.cj.xdevapi.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mrvl.dto.GeneralizationDto;
import ru.mrvl.model.Characters;
import ru.mrvl.model.Comics;

import ru.mrvl.repository.CharactersRepository;
import ru.mrvl.repository.ComicsRepository;

import ru.mrvl.service.interfaces.GeneralizationInterface;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GeneralizationInterfaceImpl implements GeneralizationInterface {

    private final CharactersRepository charactersRepository;
    private final ComicsRepository comicsRepository;

    @Autowired
    public GeneralizationInterfaceImpl(CharactersRepository charactersRepository,
                                       ComicsRepository comicsRepository
                                       ) {
        this.charactersRepository = charactersRepository;
        this.comicsRepository = comicsRepository;
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
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
         String t = new ResponseEntity<>(HttpStatus.BAD_REQUEST).toString();
         return t;
        }
    }


    @Override
    public Object converterDtoToEntity(GeneralizationDto generalizationDto) throws Exception {
        Characters characters = new Characters();


       /* List<Characters> charactersList =
                charactersRepository.findAll();

        for (Characters onlyOriginalNameCharacter:charactersList) {
            if(!onlyOriginalNameCharacter.getNameCharacter().equals(generalizationDto.getNameCharacter())){*/
                characters.setNameCharacter(generalizationDto.getNameCharacter());

        /*    }else throw new Exception(String.valueOf(HttpStatus.BAD_REQUEST));
        }*/


        characters.setAffiliation(generalizationDto.getAffiliation());

        Comics comics = new Comics();
        try {
            List<Comics> comicsList = comicsRepository.findAll();
            Optional<Comics> comicsOptional =
                    comicsList.stream()
                            .filter(element -> element.getNameComics().equals(generalizationDto.getNameComics()))
                            .findFirst();

            comics.setNameComics(comicsOptional.get().getNameComics());
            characters.setComics(comicsOptional.get());
        }catch (Exception e){
            String str  = new ResponseEntity<>(HttpStatus.NOT_FOUND).toString();
            return str;
        }

        charactersRepository.save(characters);


        GeneralizationDto generalizationDto1 = new GeneralizationDto();
        generalizationDto1.setNameComics(comics.getNameComics());
        generalizationDto1.setNameCharacter(characters.getNameCharacter());
        generalizationDto1.setAffiliation(characters.getAffiliation());
        return generalizationDto1;
        /*///////////////////////////////////////////////////
        Characters characters = new Characters();

        characters.setNameCharacter(generalizationDto.getNameCharacter());
        characters.setAffiliation(generalizationDto.getAffiliation());

        Comics comics = new Comics();
        comics.setNameComics(generalizationDto.getNameComics());

        List<Characters> charactersList = charactersRepository.findAll();
        charactersList.stream()
                        .filter(e-> e.getComics().equals())

        characters.setComics(comics);
        return characters;*/
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

    @Override
    public List<Comics> findComicsByCharacterName(String name) {
         List<Characters> charactersList1 = charactersRepository.findAll();
        List<Characters> characters =  charactersList1.stream()
                 .filter(e -> e.getNameCharacter().equals(name))
                 .collect(Collectors.toList());

        List<Comics> comics =
                characters.stream()
                        .map(e1 -> e1.getComics())
                        .collect(Collectors.toList());

        return comics;
    }

    @Override
    public List<Characters> findCharactersByCharacterName(String name) {
        List<Characters> charactersList = charactersRepository.findAll();

        List<Characters> c = charactersList
                .stream()
                .filter(e->e.getComics().getNameComics().equals(name))
                .collect(Collectors.toList());
        return c;

    }
}
