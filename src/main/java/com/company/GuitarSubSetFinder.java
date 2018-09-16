package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class GuitarSubSetFinder {

    // inout:
    // 24
    //[12,1,61,5,9,2]

    //output
    //[12,9,2,1]

    public List<Integer> findGuitarSubList(List<Integer> input, int totalSum) {
        System.out.println(String.format("totalSum: %d, inputlist: %s", totalSum, input));

        if(input.isEmpty()) return new ArrayList<>();
        List<Integer> listCopy = new ArrayList<>(input); // TODO can be made faster with the sort and reverse at the same time
        listCopy.sort(Collections.reverseOrder());

        List<Integer> outputList = addCombinations(listCopy.get(0), listCopy.subList(1, listCopy.size()), totalSum);

        System.out.println("Output list: " + outputList);
        return outputList;
    }

    private List<Integer> addCombinations(Integer head, List<Integer> tail, int totalSum) {
        List<Integer> outputList = new ArrayList<>();

        if (totalSum - head >= 0) {
            outputList.add(head);
            totalSum -= head;
        }

        if( tail.size() == 1) {
            List<Integer> returnList = addCombinations(tail.get(0), emptyList(), totalSum);
            outputList.addAll(returnList);

        } if( tail.size() >= 2) {
            outputList.addAll(addCombinations(tail.get(0), tail.subList(1, tail.size()), totalSum));
        }
        return outputList;
    }



}
