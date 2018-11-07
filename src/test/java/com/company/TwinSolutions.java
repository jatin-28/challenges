package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 *
 */
public class TwinSolutions {
    // Complete the twins function below.
    static List<String> twins(List<String> a, List<String> b) {
        final List<String> returnList = new ArrayList<>();

        for(int i=0; i < a.size(); i++) {

            String aStr = a.get(i);
            String bStr = b.get(i);
            boolean isTwin = false;
            if (aStr.length() == bStr.length()) {
                char[] newChar = new char[aStr.length()];
                char[] chars = aStr.toCharArray();

                System.out.println(newChar);

                for (int j = 0; j < chars.length - 2; j+=2) {
                    System.out.println(":" + j);
                    char oneChar = chars[j];
                    char twoChar = chars[j + 2];
                    newChar[j] = twoChar;
                    newChar[j+2] = oneChar;
                }


                System.out.println(newChar);

                isTwin = bStr.equals(new String(newChar));
            }

            returnList.add(isTwin ? "Yes" : "No");
        }

        return returnList;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> a = new ArrayList<>();

        IntStream.range(0, aCount).forEach(i -> {
            try {
                a.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> b = new ArrayList<>();

        IntStream.range(0, bCount).forEach(i -> {
            try {
                b.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<String> res = twins(a, b);

        bufferedWriter.write(
                res.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    // Complete the counts function below.
    static List<Integer> counts(List<Integer> nums, List<Integer> maxes) {
        return maxes.stream().map(
                i -> {
                    int counter = 0;
                    for (Integer num : nums) {
                        if( i <= num) counter++;
                    }
                    return counter;
                }
        ).collect(Collectors.toList());

    }


//    protected List<Order> filterOrdersSmallerThan(List<Order> allOrders, String size) {
//
//        // can replace this with a stream:
//        return allOrders.stream().filter( o -> o.toNumber(size)).collect(Collectors.toList())
//
//              List<Order> filtered = new ArrayList<Order>();
//              for (int i = 0; i <= allOrders.size(); i++) {
//                int number = orders.get(i).toNumber(size);
//
//                if (allOrders.get(i).getSize() <= number) {
//                        continue;
//                    } else {
//                        filtered.add(orders.get(i));
//                    }
//            }
//
//              return filtered;
//          }



}
