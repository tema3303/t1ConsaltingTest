package ru.test.t1ConsaltingTest;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.test.t1ConsaltingTest.service.CalculateService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CalculateServiceTest {

    private final CalculateService calculateService;
    private String input;

    @BeforeEach
    void setUp() {
        input = "aaaaabcccc";
    }

    @Test
    void getCalculateStringTest() {
        assertAll(
                () -> assertEquals(Map.of("a", 1), calculateService.getCalculateString("a"), "Тест не прошел"),
                () -> assertEquals(Map.of("c", 2, "A", 1, "a", 1, "b", 1, "B", 1), calculateService.getCalculateString("AbcBca"), "Тест не прошел"),
                () -> assertEquals(Map.of("a", 5, "c", 4, "b", 1), calculateService.getCalculateString(input), "Тест не прошел"),
                () -> assertEquals(Map.of(), calculateService.getCalculateString(""), "Тест не прошел")
        );
    }
}