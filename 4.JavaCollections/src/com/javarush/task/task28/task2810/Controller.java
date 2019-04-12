package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Controller {
    private Model model;

    public Controller(Model model) {
        if (model == null) {
            throw new IllegalArgumentException("Model should not be null");
        }
        this.model = model;
    }

    public void onCitySelect(String cityName) {
        model.selectCity(cityName);
    }

}
