package by.pivovar.sportsman.progress.repository.sportsman;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsmanRepository extends JpaRepository<SportsmanEntity, Long> {
}
