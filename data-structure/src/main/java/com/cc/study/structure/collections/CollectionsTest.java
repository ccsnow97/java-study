package com.cc.study.structure.collections;

import java.util.*;

/**
 * @Date: 2020/05/25 10:07
 */
public class CollectionsTest {

    static void testRotate(List<Integer> list){
        Collections.rotate(list,3);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9)));

        list.sort(Integer::compareTo);
      list.listIterator();
        list.removeIf(e->e==1);


        Iterator<Integer> iterator = list.iterator();
        boolean b = iterator.hasNext();
        Integer next = iterator.next();

    }

}
