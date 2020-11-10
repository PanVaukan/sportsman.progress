package by.pivovar.sportsman.progress.service.sportsman;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class SportsmanValidationService {

    void validateSportsman(@Valid @NotNull SportsmanEntity sportsman){

    }

    void validateSportsmanCreationRequest(@Valid @NotNull SportsmanEntity sportsman){

    }

    void validateSportsmanUpdateRequest(@Valid @NotNull SportsmanEntity sportsman){

    }

}
