package by.pivovar.sportsman.progress.service.run;

import by.pivovar.sportsman.progress.model.run.RunEntity;
import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class RunValidationService {

    void validateRun(@Valid @NotNull RunEntity run){

    }

    void validateRunCreationRequest(@Valid @NotNull RunEntity runEntity){

    }

    void validateRunUpdateRequest(@Valid @NotNull RunEntity runEntity){

    }


}
