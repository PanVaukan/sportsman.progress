package by.pivovar.sportsman.progress.repository.run;

import by.pivovar.sportsman.progress.model.run.RunEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunRepository extends JpaRepository<RunEntity, Long> {

}
