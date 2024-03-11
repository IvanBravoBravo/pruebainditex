package com.inditex.prueba.controller;

import com.inditex.prueba.PruebaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;


@SpringBootTest(classes = PruebaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
@Slf4j
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetHealth() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/health")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
           
        log.debug("resultado getHealth : --------- " + response.getContentAsString());
    }
    
    @Test
    public void testGetPrice_caso1() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/prices?fecha_aplicacion=2020-06-14-10.00.00&id_producto=35455&id_cadena=1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        
        
        log.debug("resultado GetPrecio caso 1: --------- " + response.getContentAsString());
    }

    @Test
    public void testGetPrice_caso2() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/prices?fecha_aplicacion=2020-06-14-16.00.00&id_producto=35455&id_cadena=1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        
        
        log.debug("resultado GetPrecio caso 2: --------- " + response.getContentAsString());
    }
    
    @Test
    public void testGetPrice_caso3() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/prices?fecha_aplicacion=2020-06-14-21.00.00&id_producto=35455&id_cadena=1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        
        
        log.debug("resultado GetPrecio caso 3: --------- " + response.getContentAsString());
    }
    
    @Test
    public void testGetPrice_caso4() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/prices?fecha_aplicacion=2020-06-15-10.00.00&id_producto=35455&id_cadena=1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        
        
        log.debug("resultado GetPrecio caso 4: --------- " + response.getContentAsString());
    }
    
    @Test
    public void testGetPrice_caso5() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/prices?fecha_aplicacion=2020-06-16-21.00.00&id_producto=35455&id_cadena=1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        
        
        log.debug("resultado GetPrecio caso 5: --------- " + response.getContentAsString());
    }
    
}
