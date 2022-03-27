package pl.suncode.recruitmentTask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<Object> handleItemNotFoundException(ResultNotFoundException exception) {
        return new ResponseEntity<>("Brak rezultatów dla zapytania.", HttpStatus.NOT_FOUND);
    }
}
