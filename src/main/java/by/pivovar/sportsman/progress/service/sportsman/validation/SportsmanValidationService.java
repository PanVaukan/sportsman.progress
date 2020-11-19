package by.pivovar.sportsman.progress.service.sportsman.validation;

import by.pivovar.sportsman.progress.model.sportsman.SportsmanEntity;
import by.pivovar.sportsman.progress.repository.sportsman.SportsmanRepository;
import by.pivovar.sportsman.progress.service.sportsman.creation.SportsmanCreationRequest;
import by.pivovar.sportsman.progress.service.sportsman.update.SportsmanUpdateRequest;
import by.pivovar.sportsman.progress.service.sportsman.validation.exception.EmailAlreadyInUseException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class SportsmanValidationService {

    private final SportsmanRepository sportsmanRepository;

    public SportsmanValidationService(SportsmanRepository sportsmanRepository) {
        this.sportsmanRepository = sportsmanRepository;
    }

    public void validateSportsman(@Valid @NotNull SportsmanEntity sportsman){

    }

    public void validateSportsmanCreationRequest(@Valid @NotNull SportsmanCreationRequest sportsmanCreationRequest){

        String email = sportsmanCreationRequest.getEmail();
        boolean suchEmailAlreadyIsExists = sportsmanRepository.existsByEmailIgnoreCase(email);

        if ( suchEmailAlreadyIsExists ) { throw new EmailAlreadyInUseException(email); }

    }

    public void validateSportsmanUpdateRequest(@Valid @NotNull SportsmanEntity sportsman, @Valid SportsmanUpdateRequest sportsmanUpdateRequest ){

    }

}
