package net.javaguides.departmentservice.exceptions.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IDNullException extends RuntimeException {
    private String message;

    public IDNullException(String message) {
        this.message = message;
    }

}
