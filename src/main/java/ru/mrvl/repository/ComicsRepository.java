package ru.mrvl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mrvl.model.Comics;

@Repository
public interface ComicsRepository extends JpaRepository<Comics,Long>{


}
