package com.company

import java.util.*

class GuitarSubSetFinderKot : GuitarSubSetFinder {

    // inout:
    // 24
    //[12,1,61,5,9,2]

    //output
    //[12,9,2,1]

    override fun findGuitarSubList(input: List<Int>, targetNumber: Int): List<Int> {
        println(String.format("targetNumber: %d, inputlist: %s", targetNumber, input))

        val currentTotalList = ArrayList<Int>()

        val outputList = input
                .sortedDescending()
                .filter({ i -> currentTotalList.sum() + i <= targetNumber && currentTotalList.add(i) })
                .toList()

        println("Java 8: Output list: $outputList")
        return outputList
    }

    override fun isGuitarSet(input: List<Int>, targetNumber: Int): Boolean {
        val outputList = findGuitarSubList(input, targetNumber)
        return outputList.sum() == targetNumber
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)

            print("Enter target number: ")
            val targetNumber = scanner.nextInt()

            println("Enter input list S (e.g. 12,1,61,5,9,2):")
            val inputListStr = scanner.next()

            val inputList = inputListStr.split(",".toRegex()).map { it.toInt() }

            val guitarSubSetFinder = GuitarSubSetFinderKot()
            val isGuitarSubSet = guitarSubSetFinder.isGuitarSet(inputList, targetNumber)

            println("Is guitar subset: $isGuitarSubSet")
        }
    }

}
