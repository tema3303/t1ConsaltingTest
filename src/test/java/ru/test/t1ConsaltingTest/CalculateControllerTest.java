package ru.test.t1ConsaltingTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.test.t1ConsaltingTest.controller.CalculateController;
import ru.test.t1ConsaltingTest.service.CalculateService;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CalculateControllerTest {

    @InjectMocks
    private CalculateController calculateController;

    @Mock
    private CalculateService calculateService;

    private HashMap<String, Integer> result = new HashMap<>();

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .standaloneSetup(calculateController)
                .build();
        result.put("a", 1);
    }

    @Test
    void getCalculateString() throws Exception {
        when(calculateService.getCalculateString(any(String.class)))
                .thenReturn(result);
        mvc.perform(get("/calculate?input=a"))
                .andExpect(status().isOk())
                .andReturn();
    }
}