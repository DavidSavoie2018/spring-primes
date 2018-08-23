package com.gimelle.primes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Primes {
    @JsonProperty(value = "Initial")
    private String initial;
    @JsonProperty(value = "Primes")
    private List<Integer> primes;
}
