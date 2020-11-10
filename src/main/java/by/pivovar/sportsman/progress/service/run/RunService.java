package by.pivovar.sportsman.progress.service.run;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import by.pivovar.sportsman.progress.repository.sportsman.SportsmanRepository;
import by.pivovar.sportsman.progress.service.sportsman.SportsmanValidationService;

import java.util.List;

public class RunService {

    private final SportsmanRepository sportsmanRepository;
    private final SportsmanValidationService sportsmanValidationService;

    public RunService(SportsmanRepository sportsmanRepository, SportsmanValidationService sportsmanValidationService) {
        this.sportsmanRepository = sportsmanRepository;
        this.sportsmanValidationService = sportsmanValidationService;
    }



}
