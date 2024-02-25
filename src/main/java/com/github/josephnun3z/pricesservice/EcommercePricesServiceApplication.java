package com.github.josephnun3z.pricesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.josephnun3z.pricesservice")
public class EcommercePricesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommercePricesServiceApplication.class, args);
    }

    /*
    TODO:
        test setup ---------------------------------------> [DONE]
        5 test cases -------------------------------------> [DONE]
        rest of the application --------------------------> [DONE]
        tests passes -------------------------------------> [DONE]
        documentation ------------------------------------> [DONE]
        extras:
            API doc --------------------------------------> [IN_PROGRESS]
            Auth with JWT --------------------------------> [PENDING]
            Exception handling and validation ------------> [PENDING]
            dockerization --------------------------------> [PENDING]
     */

}
