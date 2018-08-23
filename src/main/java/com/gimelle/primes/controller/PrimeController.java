package com.gimelle.primes.controller;

import com.gimelle.primes.model.Primes;
import com.gimelle.primes.service.PrimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/primes")
public class PrimeController {

    Logger logger = LoggerFactory.getLogger(PrimeController.class);

    @Autowired
    private PrimeService primeService;

    @RequestMapping(value = "/{initial}", method = RequestMethod.GET)
    public @ResponseBody
    Primes getPrime(@PathVariable("initial") Integer initial) {
        return Primes.builder()
                .initial(initial.toString())
                .primes(primeService.primes(initial))
                .build();
    }

}
