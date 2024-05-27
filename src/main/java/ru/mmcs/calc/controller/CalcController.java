package ru.mmcs.calc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mmcs.calc.dto.CalcAnswersDto;
import ru.mmcs.calc.dto.CalcValuesDto;
import ru.mmcs.calc.service.interfaces.CalcService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/calc/")
public class CalcController {
    private final CalcService calcService;

    @PostMapping
    public ResponseEntity<CalcAnswersDto> calc(@RequestBody CalcValuesDto calcValuesDto) {
        return ResponseEntity.ok(calcService.calc(calcValuesDto));
    }
}