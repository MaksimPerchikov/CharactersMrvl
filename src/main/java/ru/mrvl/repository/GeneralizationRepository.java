package ru.mrvl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mrvl.model.Generalization;

@Repository
public interface GeneralizationRepository extends JpaRepository<Generalization,Long> {
}
