package com.company;

import java.util.*;

/**
 *
 */
public class HolidaySolution {

    static void OutputMostPopularDestination(int count, Scanner in) {
        Map<String, Holiday> holidayMap = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String holidayName = in.nextLine();
            Holiday holiday = holidayMap.get(holidayName);
            if (holiday == null) {
                holiday = new Holiday(holidayName);
                holidayMap.put(holidayName, holiday);
            }
            holiday.increment();
        }

        Collection<Holiday> holidayCollection = holidayMap.values();

        TreeSet<Holiday> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1.count == o2.count) return 0;

            return o1.count > o2.count ? -1 : 1;
        });
        treeSet.addAll(holidayCollection);

        System.out.println(treeSet.first());
    }


static class Holiday {
    private int count = 0;
    private final String holiday;

    public Holiday(String holiday) {
        this.holiday = holiday;
    }

    void increment() {
        count++;
    }
}

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int _count;
        _count = Integer.parseInt(in.nextLine());

        OutputMostPopularDestination(_count, in);
    }

}
