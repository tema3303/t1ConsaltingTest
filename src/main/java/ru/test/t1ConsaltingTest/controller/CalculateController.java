package ru.test.t1ConsaltingTest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.t1ConsaltingTest.service.CalculateService;

import java.util.HashMap;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class CalculateController {

    private final CalculateService calculateService;

    @GetMapping
    public HashMap<String, Integer> getCalculateString(@RequestParam String input){
        return calculateService.getCalculateString(input);
    }
}