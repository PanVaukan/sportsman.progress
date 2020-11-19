package by.pivovar.sportsman.progress.service.run;

import by.pivovar.sportsman.progress.model.run.RunEntity;
import by.pivovar.sportsman.progress.repository.run.RunRepository;
import by.pivovar.sportsman.progress.repository.sportsman.SportsmanRepository;
import by.pivovar.sportsman.progress.service.run.validation.RunValidationService;
import by.pivovar.sportsman.progress.service.sportsman.validation.SportsmanValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunService {

    private final RunRepository runRepository;
    private final RunValidationService runValidationService;

    public RunService(RunRepository runRepository, RunValidationService runValidationService) {
        this.runRepository = runRepository;
        this.runValidationService = runValidationService;
    }

    public RunEntity findById(Long id) {
        return runRepository.getOne(id);
    }

    public List<RunEntity> findAllRuns() {
        return runRepository.findAll();
    }

    public void deleteById(Long id) {
        runRepository.deleteById(id);
    }

    public RunEntity updateRun(Long id,RunEntity runEntity) {
        RunEntity run = findById(id);
        runValidationService.validateRun(run,runEntity);
        run.setStartRun(runEntity.getStartRun());
        run.setFinishRun(runEntity.getFinishRun());
        run.setDistance(runEntity.getDistance());
        run.setAverage(runEntity.getAverage());
        run.setSportsmanId(runEntity.getSportsmanId());
        return runRepository.save(run);
    }



}
