package pl.jewusiak.inwentarzeeapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DuplicateEmailExistsInDatabase extends ResponseStatusException {
    public DuplicateEmailExistsInDatabase() {
        super(HttpStatus.CONFLICT, "Email exists in the database");
    }
}
