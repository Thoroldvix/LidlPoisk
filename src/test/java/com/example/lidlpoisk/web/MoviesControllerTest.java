package com.example.lidlpoisk.web;

import com.example.lidlpoisk.model.entities.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MoviesControllerTest extends ControllerBaseTest {

    private List<Movie> movies;

    @Test
    void getMoviesList() throws Exception {

    }
}
