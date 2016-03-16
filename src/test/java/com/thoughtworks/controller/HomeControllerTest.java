package com.thoughtworks.controller;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;

import static org.junit.Assert.assertEquals;

public class HomeControllerTest {

    @InjectMocks
    HomeController homeController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldInitNameWhenIInputTheIndexUrl() throws Exception {
        //Given
        ExtendedModelMap model = new ExtendedModelMap();

        //When
        String index = homeController.index(model);

        //Then
        assert(model.get("name")).equals("ThoughtWorks");
    }

    @Test
    public void shouldReturnIndexPageWhenIInputTheIndexUrl() throws Exception {
        //Given
        ExtendedModelMap model = new ExtendedModelMap();

        //When
        String index = homeController.index(model);

        //Then
        assert(index).equals("index");
    }
}