package repository;

import domain.entity.ProgressRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProgressRepository extends JpaRepository<ProgressRecord, Integer> {

    @Query("SELECT pr FROM ProgressRecord pr WHERE pr.objective.objective_id = :objectiveId")
    List<ProgressRecord> findByObjectiveId(@Param("objectiveId") int objectiveId);

}


