package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class GuitarSubSetFinderJava8 implements GuitarSubSetFinder{

    // inout:
    // 24
    //[12,1,61,5,9,2]

    //output
    //[12,9,2,1]

    public List<Integer> findGuitarSubList(List<Integer> input, int targetNumber) {
        System.out.println(String.format("targetNumber: %d, inputlist: %s", targetNumber, input));

        final List<Integer> currentTotalList = new ArrayList<>();

        List<Integer> outputList = input.stream()
                .sorted(Collections.reverseOrder())
                .filter(i -> {
                            boolean isWanted = currentTotalList.stream().mapToInt(s -> s).sum() + i <= targetNumber;
                            if (isWanted) currentTotalList.add(i);
                            return isWanted;
                        }
                ).collect(Collectors.toList());

        System.out.println("Java 8: Output list: " + outputList);
        return outputList;
    }

    @Override
    public boolean isGuitarSet(List<Integer> input, int targetNumber) {
        List<Integer> outputList = findGuitarSubList(input, targetNumber);
        return outputList.stream().mapToInt(s -> s).sum() == targetNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target number: ");
        Integer targetNumber = scanner.nextInt();

        System.out.println("Enter input list S (e.g. 12,1,61,5,9,2):");
        String inputListStr = scanner.next();

        List<Integer> inputList = Arrays.stream(inputListStr.split(","))
                                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        GuitarSubSetFinder guitarSubSetFinder = new GuitarSubSetFinderJava8();
        boolean isGuitarSubSet = guitarSubSetFinder.isGuitarSet(inputList, targetNumber);

        System.out.println("Is guitar subset: " + isGuitarSubSet);
    }

}
