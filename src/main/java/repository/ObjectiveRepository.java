package repository;

import domain.entity.Objective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectiveRepository extends JpaRepository<Objective, Integer> {
    Objective findById(int objectiveId);
}
