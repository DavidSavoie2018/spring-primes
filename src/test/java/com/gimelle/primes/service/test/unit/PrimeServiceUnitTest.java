package com.gimelle.primes.service.test.unit;

import com.gimelle.primes.service.PrimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrimeServiceUnitTest {

    @Autowired
    private PrimeService primeService;

    @Test
    public void isAprimeTest(){
        assertThat(primeService.isAPrime().test(2)).isTrue();
        assertThat(primeService.isAPrime().test(3)).isTrue();
        assertThat(primeService.isAPrime().test(4)).isFalse();
        assertThat(primeService.isAPrime().test(1)).isTrue();
        assertThat(primeService.isAPrime().test(1)).isTrue();
    }

    @Test
    public void isABigPrimeTest(){
        assertThat(primeService.isAPrime().test(2147483647)).isTrue();
        assertThat(primeService.isAPrime().test(2147483646)).isFalse();
        assertThat(primeService.isAPrime().test(2147483645)).isFalse();
    }

    @Test
    public void test4FirstPrimeNumbers() throws IOException {
        List<Integer> primes = primeService.primes(10);
        assertThat(primes)
                .isNotEmpty()
                .contains(2,3,5,7);
    }



}
