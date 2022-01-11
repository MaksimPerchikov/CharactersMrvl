package ru.mrvl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mrvl.model.Characters;
@Repository
public interface CharactersRepository extends JpaRepository<Characters,Long> {
}
