package uz.ruzyume.porfolio_block.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(
            final NotFoundException e, WebRequest exchange
    ){
        return constructExceptionResponse(e, exchange, HttpStatus.NOT_FOUND);
    }
    private ResponseEntity<ExceptionResponse> constructExceptionResponse(
            final Exception e, final  WebRequest exchange, final HttpStatus status
    ){
        return new ResponseEntity<>(
                ExceptionResponse.builder()
                        .massage(e.getMessage())
                        .occurredAt(LocalDateTime.now())
                        .status(status.value())
                        .build(), status
        );
    }

}
