package ru.mmcs.calc.service.implementation;

import org.springframework.stereotype.Service;
import ru.mmcs.calc.dto.CalcAnswersDto;
import ru.mmcs.calc.dto.CalcValuesDto;
import ru.mmcs.calc.exception.UnsupportedOperatorException;
import ru.mmcs.calc.service.interfaces.CalcService;

@Service
public class CalcServiceImpl implements CalcService {

    @Override
    public CalcAnswersDto calc(CalcValuesDto calcValuesDto) {
        return new CalcAnswersDto(calcValuesDto.getValues()
                .stream()
                .map(this::calculateValue)
                .map(Double::parseDouble)
                .toList()
        );
    }

    private String calculateValue(String expression) {
        String[] parts = expression.split(" ");
        double operand1 = Double.parseDouble(parts[0]);
        double operand2 = Double.parseDouble(parts[2]);
        String operator = parts[1];

        return switch (operator) {
            case "+" -> String.valueOf(operand1 + operand2);
            case "-" -> String.valueOf(operand1 - operand2);
            case "*" -> String.valueOf(operand1 * operand2);
            case "/" -> String.valueOf(operand1 / operand2);
            default -> throw new UnsupportedOperatorException(String.format("Unsupported operator: %s", operator));
        };
    }
}