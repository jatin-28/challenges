package com.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
@RunWith(Parameterized.class)
public class GuitarSubSetFinderParameterizedTest {

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {24, emptyList(), new Integer[] {}}, // fail none in list
                {24, Arrays.asList(12, 1,61,5,9,2), new Integer[] {12,9,2,1 }},
                {43, singletonList(43), new Integer[] {43}},
                {43, singletonList(42), new Integer[] {42}}, // fail - i.e. none in list
                {43, Arrays.asList(1,1,20,60,20,1), new Integer[] {1,1,20,20,1 }},
                {43, Arrays.asList(100,48,57), new Integer[] {}},
                {43, Arrays.asList(1,1,60,20,20), new Integer[] {1,1,20,20}} // fail - not enough in list
        });
    }


    private GuitarSubSetFinder testObjKotlin = new GuitarSubSetFinderKot();
    private GuitarSubSetFinder testObjJava7 = new GuitarSubSetFinderJava7();
    private GuitarSubSetFinder testObjJava8 = new GuitarSubSetFinderJava8();

    private int sum;
    private List<Integer> input;
    private Integer[] expected;

    public GuitarSubSetFinderParameterizedTest(int sum, List<Integer> input, Integer[] expected) {
        this.sum = sum;
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void executeTest() {
        assertThat(testObjKotlin.findGuitarSubList(input, sum)).containsExactlyInAnyOrder(expected);
        assertThat(testObjJava7.findGuitarSubList(input, sum)).containsExactlyInAnyOrder(expected);
        assertThat(testObjJava8.findGuitarSubList(input, sum)).containsExactlyInAnyOrder(expected);
    }

}
