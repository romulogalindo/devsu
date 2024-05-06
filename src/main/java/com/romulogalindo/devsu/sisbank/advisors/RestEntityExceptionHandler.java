package com.romulogalindo.devsu.sisbank.advisors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessageDTO> handledErrorNoSaldo(Exception ep) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO();
        errorMessageDTO.setMensaje(ep.getMessage());

        return new ResponseEntity<>(errorMessageDTO, httpStatus);
    }
}
