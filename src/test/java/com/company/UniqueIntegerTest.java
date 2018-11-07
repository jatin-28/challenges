package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class UniqueIntegerTest {

    public String getUniqueCount(String input){
        if( input == null || input.isEmpty()) return "{}";

        String[] intStr = input.split(" ");
        Map<Integer,Integer> integerMap = new HashMap<>();

        Arrays.stream(intStr).forEach(i -> {
            try {
                int parsedInt = Integer.parseInt(i);
                Integer intValue = integerMap.get(parsedInt);

                if (intValue == null) intValue = 0;

                integerMap.put(parsedInt, ++intValue );
            } catch (NumberFormatException e) {
                // ignore
            }

        });

        return integerMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(", "));
    }


    public static void main(String[] args) throws IOException {
        UniqueIntegerTest m = new UniqueIntegerTest();
        String line;
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        line=inp.readLine();

        System.out.println(m.getUniqueCount(line));
    }

    /*
    select e.empname, d.deptname
from employee e, department d
where e.deptid = d.deptid
and e.deptid in
(
select deptid
from employee e
group by deptid
having count(deptid) >= 4
)
order by e.empname asc
     */
}
