package by.pivovar.sportsman.progress.service.run.validation;

import by.pivovar.sportsman.progress.model.run.RunEntity;
import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import by.pivovar.sportsman.progress.service.run.validation.exception.DistanceNotZeroException;
import by.pivovar.sportsman.progress.service.run.validation.exception.StartGreatThanFinishException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class RunValidationService {

    void validateRun(@Valid @NotNull RunEntity run){

        if (run.getStartRun().toEpochSecond() > run.getFinishRun().toEpochSecond()) {
            throw new StartGreatThanFinishException("Start time must be more than finish time");
        }
        if (run.getDistance() < 0) {
            throw new DistanceNotZeroException("Distance must be more that 0 ");
        }

    }

    public void validateRun(@Valid @NotNull RunEntity run, @Valid RunEntity runEntity) {

    }

    void validateRunCreationRequest(@Valid @NotNull RunEntity runEntity){

    }

    void validateRunUpdateRequest(@Valid @NotNull RunEntity runEntity){

    }


}
