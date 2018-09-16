package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class GuitarSubSetAttemptsTest {

    private GuitarSubSetAttempts testObj = new GuitarSubSetAttempts();

    // inout:
    // 24
    //[12,1,61,5,9,2]

    //output
    //[12,9,2,1]

    @Test
    public void testFirstAttemptListCombo() {
        List<Integer> input = Arrays.asList(12, 1,61,5,9,2);

        List<Integer> output = testObj.findGuitarSubListFirstAttempt(input, 24);

        System.out.println(output);

        assertThat(output).containsAll(Arrays.asList(12,9,2,1));

    }

    @Test
    public void testSecondAttemptListCombo() {
        List<Integer> input = Arrays.asList(12, 1,61,5,9,2);

        List<Integer> output = testObj.findGuitarSubListSecondAttempt(input, 24);

        System.out.println(output);

        assertThat(output).containsAll(Arrays.asList(12,9,2,1));

    }


    @Test
    public void testSecondAttemptListCombo2() {
        List<Integer> input = Arrays.asList(7, 5,23,1,2,9);

        List<Integer> output = testObj.findGuitarSubListSecondAttempt(input, 24);

        System.out.println(output);

        assertThat(output).containsAll(Arrays.asList(23,1));
    }

    @Test
    public void testSecondAttemptListCombo3() {
        List<Integer> input = Arrays.asList(4,3,6,24,23,1);

        List<Integer> output = testObj.findGuitarSubListSecondAttempt(input, 24);

        System.out.println(output);

        assertThat(output).containsAll(Arrays.asList(24));
    }

}
