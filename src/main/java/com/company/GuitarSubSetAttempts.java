package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class GuitarSubSetAttempts {

    // inout:
    // 24
    //[12,1,61,5,9,2]

    //output
    //[12,9,2,1]

    // first attempt
    public List<Integer> findGuitarSubListFirstAttempt(List<Integer> input, int totalSum) {
        List<Integer> outputList = new ArrayList<>();

        addCombinationsFirstAttempt(outputList, input.get(0), input.subList(1, input.size()), totalSum);

        return outputList;
    }

    private void addCombinationsFirstAttempt(List<Integer> outputList, Integer head, List<Integer> input, int totalSum) {
        if (totalSum - head >= 0) {
            outputList.add(head);
            totalSum -= head;
        }

        if( input.size() == 1) {
            addCombinationsFirstAttempt(outputList, input.get(0), emptyList(), totalSum);
        }

        if( input.size() >= 2) {
            addCombinationsFirstAttempt(outputList, input.get(0), input.subList(1, input.size()), totalSum);
        }
    }


    // second attempt
    public List<Integer> findGuitarSubListSecondAttempt(List<Integer> input, int totalSum) {
        return addCombinationsSecondAttempt(input.get(0), input.subList(1, input.size()), totalSum);
    }

    private List<Integer> addCombinationsSecondAttempt(Integer head, List<Integer> input, int totalSum) {
        List<Integer> outputList = new ArrayList<>();

        if (totalSum - head >= 0) {
            outputList.add(head);
            totalSum -= head;
        }

        if(totalSum == 0) {
            System.out.println("first_totalSum output: " +outputList);
            return outputList;
        }

        if( input.isEmpty()) {
            System.out.println("first_isEmpty output: " +outputList);
            return outputList;
        }

        if( input.size() == 1) {
            List<Integer> returnList = addCombinationsSecondAttempt(input.get(0), emptyList(), totalSum);
            outputList.addAll(returnList);

            //if(outputList.stream)

        }

        if( input.size() >= 2) {
            outputList.addAll(addCombinationsSecondAttempt(input.get(0), input.subList(1, input.size()), totalSum));
        }


        return outputList;
    }



}
