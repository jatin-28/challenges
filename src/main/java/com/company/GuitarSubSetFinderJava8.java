package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GuitarSubSetFinderJava8 implements GuitarSubSetFinder{

    // inout:
    // 24
    //[12,1,61,5,9,2]

    //output
    //[12,9,2,1]

    public List<Integer> findGuitarSubList(List<Integer> input, int totalSum) {
        System.out.println(String.format("totalSum: %d, inputlist: %s", totalSum, input));

        if(input.isEmpty()) return new ArrayList<>();

        final List<Integer> currentTotalList = new ArrayList<>();

        List<Integer> outputList = input.stream()
                .sorted(Collections.reverseOrder())
                .filter(i -> {
                            boolean isWanted = currentTotalList.stream().mapToInt(s -> s).sum() + i <= totalSum;
                            if (isWanted) currentTotalList.add(i);
                            return isWanted;
                        }
                ).collect(Collectors.toList());

        System.out.println("Java 8: Output list: " + outputList);
        return outputList;
    }

}
