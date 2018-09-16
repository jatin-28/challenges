package com.company;

import java.util.List;

/**
 *
 */
public interface GuitarSubSetFinder {

    List<Integer> findGuitarSubList(List<Integer> input, int totalSum);

    boolean isGuitarSet(List<Integer> input, int targetNumber);
}
