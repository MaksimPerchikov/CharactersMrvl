package ru.mrvl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mrvl.model.Characters;
import ru.mrvl.model.Comics;
import ru.mrvl.repository.ComicsRepository;
import ru.mrvl.service.GeneralizationInterfaceImpl;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/v1/public")
public class MainRestController {

    private final GeneralizationInterfaceImpl generalizationInterfaceImpl;


    @Autowired
    public MainRestController(GeneralizationInterfaceImpl generalizationInterfaceImpl) {
        this.generalizationInterfaceImpl = generalizationInterfaceImpl;

    }

    //Вывод всех доступных персонажей
    @GetMapping(value = "/characters")
    public List<Characters> findAllCharac(){
        return generalizationInterfaceImpl.findAllCharacters();
    }

    //добавление персонажа
    @PostMapping(value = "/characters/add")
    public String addCharac(@RequestBody Characters characters){
        return generalizationInterfaceImpl.addCharacter(characters);
    }

    //поиск персонажа по айди
    @GetMapping(value = "/characters/{characterId}")
    public Object findByIdCharac(@PathVariable("characterId") Long characterId){
      return generalizationInterfaceImpl.findByIdCharacter(characterId);
    }

    //вывод всех комиксов
    @GetMapping(value = "/comics")
    public List<Comics> findAllCom(){
        return generalizationInterfaceImpl.findAllComics();
    }
    //вывод комикса по айди
    @GetMapping(value = "/comics/{comicsId}")
    public Object findByIdCom(@PathVariable("comicsId") Long id){
        return generalizationInterfaceImpl.findByIdComics(id);
    }

    //Добавить комикс
    @PostMapping(value = "/comics/add")
    public String addCom(@RequestBody Comics comics) {
        return generalizationInterfaceImpl.addComics(comics);
    }

  //  ---------------------------------сортировки--------------------------------------  //

    //сортировка комиксов по айди в порядке возрастания
    @GetMapping(value = "/comics/sorted/id/ascending")
    public List<Comics> sortedComicsByIdAscending(){
        return generalizationInterfaceImpl.sortedByIdAscendingComics();
    }

    //сортировка комиксов по айди в порядке убывания
    @GetMapping(value = "/comics/sorted/id/descending")
    public List<Comics> sortedComicsByIdDescending(){
        return generalizationInterfaceImpl.sortedByIdDescendingComics();
    }

    //сортировка комиксов по имени
    @GetMapping(value = "/comics/sorted/name")
    public List<Comics> sortedComicsByName(){
        return generalizationInterfaceImpl.sortedByNameComics();
    }

    //сортировка персонажей в порядке возрастания
    @GetMapping(value = "/characters/sorted/id/ascending")
    public List<Characters> sortedCharactersByIdAscending(){
        return generalizationInterfaceImpl.sortedByIdAscendingCharacters();
    }
    //сортировка персонажей в порядке убывания
    @GetMapping(value = "/characters/sorted/id/descending")
    public List<Characters> sortedCharactersByIdDescending(){
        return generalizationInterfaceImpl.sortedByIdDescendingCharacters();
    }

    @GetMapping(value = "/characters/sorted/name")
    public List<Characters> sortedCharactersByName(){
        return generalizationInterfaceImpl.sortedByNameCharacters();
    }




}
