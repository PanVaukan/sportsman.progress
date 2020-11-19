package by.pivovar.sportsman.progress.service.run.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StartGreatThanFinishException extends RuntimeException {
    public StartGreatThanFinishException(String message) {
        super(message);
    }
}
