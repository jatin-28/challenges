package com.company;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class IPMatcher {
    private String pattern;


    @Test
    public void successMatchIPAddress() {
        String ip = "6.255.255.255";
        boolean matches = ip.matches("^[0-2]?[0-5]?[0-5]\\.[0-2]?[0-5]?[0-5]\\.[0-2]?[0-5]?[0-5]\\.[0-2]?[0-5]?[0-5]");

        assertThat(matches).isTrue();
    }

    /*
    12.12.12.12                   true
13.13.13.112                      true
VUUT.12.12                        false
111.111.11.111                    true
1.1.1.1.1.1.1                     false
.....                             false
1...1..1..1                       false
0.0.0.0                           true
255.0.255.0                       true
266.266.266.266                   false
00000.000000.0000000.00001        false
0023.0012.0012.0034               false


     */
}
