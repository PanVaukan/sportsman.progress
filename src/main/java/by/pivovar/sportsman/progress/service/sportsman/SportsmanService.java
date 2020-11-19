package by.pivovar.sportsman.progress.service.sportsman;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import by.pivovar.sportsman.progress.repository.sportsman.SportsmanRepository;
import by.pivovar.sportsman.progress.service.sportsman.creation.SportsmanCreationRequest;
import by.pivovar.sportsman.progress.service.sportsman.update.SportsmanUpdateRequest;
import by.pivovar.sportsman.progress.service.sportsman.validation.SportsmanValidationService;
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

    public SportsmanEntity createSportsman(SportsmanCreationRequest sportsmanCreationRequest){
        sportsmanValidationService.validateSportsmanCreationRequest(sportsmanCreationRequest);
        SportsmanEntity sportsmanEntity = new SportsmanEntity();
        sportsmanEntity.setId(null);
        sportsmanEntity.setFirstName(sportsmanCreationRequest.getFirstName());
        sportsmanEntity.setLastName(sportsmanCreationRequest.getLastName());
        sportsmanEntity.setBirthday(sportsmanCreationRequest.getBirthday());
        sportsmanEntity.setEmail(sportsmanCreationRequest.getEmail());
        return sportsmanRepository.save(sportsmanEntity);
    }

    public void deleteById(Long Id){
        sportsmanRepository.deleteById(Id); // deleteByIdCascade
    }

    public SportsmanEntity updateSportsman(SportsmanUpdateRequest sportsmanUpdateRequest){

        SportsmanEntity sportsmanEntity = findById(sportsmanUpdateRequest.getId());

        sportsmanValidationService.validateSportsmanUpdateRequest(sportsmanEntity, sportsmanUpdateRequest);

        sportsmanEntity.setFirstName(sportsmanUpdateRequest.getFirstName());
        sportsmanEntity.setLastName(sportsmanUpdateRequest.getLastName());
        sportsmanEntity.setBirthday(sportsmanUpdateRequest.getBirthday());
        sportsmanEntity.setEmail(sportsmanUpdateRequest.getEmail());
        sportsmanEntity = sportsmanRepository.save(sportsmanEntity);

        return sportsmanEntity;

    }

}
