package by.pivovar.sportsman.progress.service.sportsman;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import by.pivovar.sportsman.progress.repository.sportsman.SportsmanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsmanService {

    private final SportsmanRepository sportsmanRepository;
    private final SportsmanValidationService sportsmanValidationService;

    public SportsmanService(SportsmanRepository sportsmanRepository, SportsmanValidationService sportsmanValidationService) {
        this.sportsmanRepository = sportsmanRepository;
        this.sportsmanValidationService = sportsmanValidationService;
    }

    public SportsmanEntity findById(Long id){
        return sportsmanRepository.getOne(id);
    }

    public List<SportsmanEntity> findAll(){
        return sportsmanRepository.findAll();
    }

    public SportsmanEntity createSportsman(SportsmanEntity sportsman){
        // To do: validation
        sportsman.setId(null);
        return sportsmanRepository.save(sportsman);
    }

    public void deleteById(Long Id){
        sportsmanRepository.deleteById(Id); // deleteByIdCascade
    }

    public SportsmanEntity updateSportsman(){
        return null;
    }

}
