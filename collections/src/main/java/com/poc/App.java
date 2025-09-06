package com.poc;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        int[] num = new int[10];
        num[0] = 1;
        //num[11] = 3;


        List<Integer> nums = new ArrayList(); // 10 + 5
        nums.add(1);
        nums.add(3);
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(1);
        nums.add(3);
        nums.add(1);
        nums.add(3);
        nums.add(1);
        nums.add(3);
        nums.add(4);
        nums.add(4);

        nums.contains(1);

        LinkedList nums2 = new LinkedList();
        Collections.synchronizedList(nums);

        nums.forEach(i -> System.out.println(i));



        Collections.sort(nums);


        Set set = new HashSet();
        set.add(null);
        set.add("Chandan");
        set.add(null);

        System.out.println("--------------");



        Map map = new HashMap();
        System.out.println(map.put(1, "Chandan"));
        System.out.println(map.put(2, 2.3));



        Iterator itr = map.values().iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        Collections.synchronizedMap(map);

    }
}
