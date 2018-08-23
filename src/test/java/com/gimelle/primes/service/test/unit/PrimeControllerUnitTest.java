package com.gimelle.primes.service.test.unit;

import com.gimelle.primes.controller.PrimeController;
import com.gimelle.primes.service.PrimeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimeControllerUnitTest {

    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    PrimeController primeController;

    @MockBean
    PrimeService primeService;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(this.primeController).build();
    }

    @Test
    public void testSearchSync() throws Exception {

        when(primeService.primes(any(Integer.class))).thenReturn(Arrays.asList(2, 3));

        mockMvc.perform(get("/primes/4").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                "{" +
                        "  \"Initial\": \"4\"," +
                        "  \"Primes\": [2,3]" +
                        "}"));
    }

}
