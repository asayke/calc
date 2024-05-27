package ru.mmcs.calc.service.interfaces;

import ru.mmcs.calc.dto.CalcAnswersDto;
import ru.mmcs.calc.dto.CalcValuesDto;

public interface CalcService {
    CalcAnswersDto calc(CalcValuesDto calcValuesDto);
}
