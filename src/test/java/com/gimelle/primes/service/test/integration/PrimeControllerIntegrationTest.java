package com.gimelle.primes.service.test.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.gimelle.primes.controller.PrimeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimeControllerIntegrationTest {

    MockMvc mockMvc;

    @Autowired
    PrimeController primeController;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(this.primeController).build();
    }

    @Test
    public void integrationTest() throws Exception {

        mockMvc.perform(
                get("/primes/10")
        )
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{" +
                                "  \"Initial\": \"10\"," +
                                "  \"Primes\": [2,3,5,7]" +
                                "}"));

    }

}
