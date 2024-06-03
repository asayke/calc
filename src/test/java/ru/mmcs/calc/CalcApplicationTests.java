package ru.mmcs.calc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.mmcs.calc.dto.CalcAnswersDto;
import ru.mmcs.calc.dto.CalcValuesDto;
import ru.mmcs.calc.exception.UnsupportedOperatorException;
import ru.mmcs.calc.service.interfaces.CalcService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestPropertySource(properties = "server.port=8080")
class CalcApplicationTests {

    @Autowired
    CalcService calcService;

    @Test
    void shouldCalculateSum() {
        CalcValuesDto calcValuesDto = new CalcValuesDto(List.of("1 + 2"));
        CalcAnswersDto actual = calcService.calc(calcValuesDto);
        assertEquals("3.0", actual.getAnswers().get(0).toString());
    }

    @Test
    void shouldCalculateDifference() {
        CalcValuesDto calcValuesDto = new CalcValuesDto(List.of("2 - 1"));
        CalcAnswersDto actual = calcService.calc(calcValuesDto);
        assertEquals("1.0", actual.getAnswers().get(0).toString());
    }

    @Test
    void shouldCalculateMulti() {
        CalcValuesDto calcValuesDto = new CalcValuesDto(List.of("2 * 3"));
        CalcAnswersDto actual = calcService.calc(calcValuesDto);
        assertEquals("6.0", actual.getAnswers().get(0).toString());
    }

    @Test
    void shouldCalculateDiv() {
        CalcValuesDto calcValuesDto = new CalcValuesDto(List.of("8 / 2"));
        CalcAnswersDto actual = calcService.calc(calcValuesDto);
        assertEquals("4.0", actual.getAnswers().get(0).toString());
    }

    @Test
    void shouldThrowExceptionForInvalidOperator() {
        CalcValuesDto calcValuesDto = new CalcValuesDto(List.of("2 % 1"));
        assertThrows(UnsupportedOperatorException.class, () -> calcService.calc(calcValuesDto));
    }
}