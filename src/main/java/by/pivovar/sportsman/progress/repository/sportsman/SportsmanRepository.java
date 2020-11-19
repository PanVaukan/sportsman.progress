package by.pivovar.sportsman.progress.repository.sportsman;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportsmanRepository extends JpaRepository<SportsmanEntity, Long> {

    boolean existsByEmailIgnoreCase(String email);

    List<SportsmanEntity> findAllByEmailIgnoreCase(String email);

}
