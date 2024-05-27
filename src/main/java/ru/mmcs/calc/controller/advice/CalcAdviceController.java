package ru.mmcs.calc.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.mmcs.calc.controller.CalcController;
import ru.mmcs.calc.dto.error.ErrorDto;
import ru.mmcs.calc.exception.UnsupportedOperatorException;

@ControllerAdvice(assignableTypes = {CalcController.class})
public class CalcAdviceController {

    @ExceptionHandler({UnsupportedOperatorException.class})
    public ResponseEntity<ErrorDto> handleUnsupportedOperatorException(RuntimeException e) {
        return new ResponseEntity<>(new ErrorDto(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

}