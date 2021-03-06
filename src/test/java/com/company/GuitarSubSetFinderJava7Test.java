package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class GuitarSubSetFinderJava7Test {

    private GuitarSubSetFinder testObj = new GuitarSubSetFinderJava7();

    // inout:
    // 24
    //[12,1,61,5,9,2]

    //output
    //[12,9,2,1]

    // empty input array
    // input array with only one value
    // embedded with duplicates
    // doesn't find any numbers
    // success case

    @Test
    public void emptyInputArray() {
        List<Integer> actual = testObj.findGuitarSubList(Collections.emptyList(), 43);

        assertThat(actual).containsExactlyInAnyOrder();
    }

    @Test
    public void testSecondAttemptListCombo() {
        List<Integer> input = Arrays.asList(12, 1,61,5,9,2);

        List<Integer> actual = testObj.findGuitarSubList(input, 24);

        assertThat(actual).containsExactlyInAnyOrder(12,9,2,1);

    }

    @Test
    public void inputArrayWithOneFail() {
        int totalSum = 43;
        List<Integer> input = Collections.singletonList(totalSum - 1);

        List<Integer> actual = testObj.findGuitarSubList(input, totalSum);

        assertThat(actual).containsExactlyInAnyOrder(totalSum - 1);
    }

    @Test
    public void inputArrayWithOneSuccess() {
        int totalSum = 43;
        List<Integer> input = Collections.singletonList(totalSum);

        List<Integer> actual = testObj.findGuitarSubList(input, totalSum);

        assertThat(actual).containsExactlyInAnyOrder(totalSum);
    }

    @Test
    public void inputWithDuplicatesSuccess() {
        int totalSum = 43;
        List<Integer> input = Arrays.asList(1,1,20,60,20,1);

        List<Integer> actual = testObj.findGuitarSubList(input, totalSum);

        assertThat(actual).containsExactlyInAnyOrder(1,1,20,20,1);
    }

    @Test
    public void inputListContainsNumbersBiggerThanSumRequired() {
        int totalSum = 43;
        List<Integer> input = Arrays.asList(100,48,57);

        List<Integer> actual = testObj.findGuitarSubList(input, totalSum);

        assertThat(actual).isEmpty();
    }

    @Test
    public void inputListDoesntContainEnoughNumbers() {
        int totalSum = 43;
        List<Integer> input = Arrays.asList(1,1,60,20,20);

        List<Integer> actual = testObj.findGuitarSubList(input, totalSum);

        assertThat(actual).containsExactlyInAnyOrder(1,1,20,20);
    }

    @Test
    //@Ignore
    // this case does not exist?
    public void inputListContainsListButNotAsExpected() {
        int totalSum = 24;
        List<Integer> input = Arrays.asList(12,60,11,9,3,2);

        List<Integer> actual = testObj.findGuitarSubList(input, totalSum);

        assertThat(actual).containsExactlyInAnyOrder(12,9,3);
    }

    @Test
    public void name() {
        System.out.println(nametryFinal());
    }

    public int nametryFinal() {

        try {
            return 10;
        } finally {
            return 12;
        }

    }


}
