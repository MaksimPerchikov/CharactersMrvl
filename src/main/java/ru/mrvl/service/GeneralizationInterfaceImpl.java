package ru.mrvl.service;

import org.springframework.stereotype.Service;
import ru.mrvl.model.Characters;
import ru.mrvl.service.interfaces.ComicsAndCharacterInterface;

import java.util.List;

@Service
public class ComicsAndCharacterInterfaceImpl implements ComicsAndCharacterInterface {



    @Override
    public List<Characters> findAllCharacters() {
        return null;
    }

    @Override
    public Characters findByIdCharacter(Long id) {
        return null;
    }
}
