package com.cc.study.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 23树
 *
 * //todo 删除未做
 *
 * @Date: 2020/04/14 16:35
 */
public class ThreeNode {

    List<Integer> elems;

    List<ThreeNode> children;

    ThreeNode parent;


    public ThreeNode(Integer one) {
        this.elems = new ArrayList<>(Collections.singletonList(one));
    }

    public static ThreeNode insert(ThreeNode rNode, Integer value) {
        if (rNode == null) {
            return new ThreeNode(value);
        }
        insert0(rNode, value);
        return rNode.parent == null ? rNode : rNode.parent;
    }

    public static void insert0(ThreeNode rNode, Integer value) {

        if (isChildrenEmpty(rNode)) {
            addElemInOrder(rNode, value);
        } else {
            int shouldInsertPostion = findShouldInsertPostion(rNode, value);
            if (shouldInsertPostion != -1) {
                insert0(rNode.children.get(shouldInsertPostion), value);
            }
        }

        if (rNode.elems.size() == 3) {
            List<ThreeNode> children = rNode.children;
            ThreeNode parent = rNode.parent;
            List<Integer> elems = rNode.elems;
            if (parent == null) {
                parent = new ThreeNode(elems.get(1));
            } else {
                addElemInOrder(parent, elems.get(1));
            }

            rNode.elems = new ArrayList<>(Collections.singletonList(elems.get(0)));
            rNode.children = (children == null) ? null : new ArrayList<>(Arrays.asList(children.get(0), children.get(1)));
            rNode.parent = parent;
            ThreeNode otherNode = new ThreeNode(elems.get(2));
            otherNode.children = (children == null) ? null : new ArrayList<>(Arrays.asList(children.get(2), children.get(3)));
            if (otherNode.children != null) {
                otherNode.children.forEach(e -> e.parent = otherNode);
            }
            otherNode.parent = parent;
            parent.children = mergeChildren(parent.children, rNode, otherNode);
        }

    }

    private static List<ThreeNode> mergeChildren(List<ThreeNode> originChildren, ThreeNode one, ThreeNode two) {
        if (originChildren == null) {
            return new ArrayList<>(Arrays.asList(one, two));
        }
        for (int i = 0; i < originChildren.size(); i++) {
            if (originChildren.get(i).elems.get(0).equals(one.elems.get(0))) {
                originChildren.add(i + 1, two);
                break;
            }
        }
        return originChildren;
    }

    private static void addElemInOrder(ThreeNode threeNode, Integer value) {
        List<Integer> elems = threeNode.elems;
        if (value > elems.get(elems.size() - 1)) {
            elems.add(value);
        }
        if (value < elems.get(0)) {
            elems.add(0, value);
        }
        for (int i = 0; i < elems.size() - 1; i++) {
            if (value > elems.get(i) && value < elems.get(i + 1)) {
                elems.add(i + 1, value);
            }
        }
    }

    private static int findShouldInsertPostion(ThreeNode threeNode, Integer value) {
        for (int i = 0; i < threeNode.elems.size(); i++) {
            if (value < threeNode.elems.get(i)) {
                return i;
            } else if (value.equals(threeNode.elems.get(i))) {
                return -1;
            }
        }
        return threeNode.elems.size();
    }


    private static boolean isChildrenEmpty(ThreeNode threeNode) {
        return threeNode.children == null || threeNode.children.isEmpty();
    }

    public static List<Integer> midTraverse(ThreeNode threeNode) {
        List<Integer> list = new ArrayList<>();
        midTraverse(threeNode, list);
        return list;
    }

    public static void midTraverse(ThreeNode threeNode, List<Integer> list) {
        if (threeNode == null) {
            return;
        }
        if (threeNode.children != null) {
            midTraverse(threeNode.children.get(0), list);
            list.add(threeNode.elems.get(0));
            midTraverse(threeNode.children.get(1), list);
        } else {
            list.add(threeNode.elems.get(0));
        }
        if (threeNode.elems.size() == 2) {
            list.add(threeNode.elems.get(1));
            if (threeNode.children != null) {
                midTraverse(threeNode.children.get(2), list);
            }
        }
    }


    public static void main(String[] args) {
        Integer[] integers = {4, 10, 2, 7, 15, 30, 1, 3, 5, 9, 11, 18, 36, 40, 32};
        ThreeNode root = null;
        for (Integer integer : integers) {
            root = insert(root, integer);
            List<Integer> list = midTraverse(root);
            System.out.println(list);
        }
        int a = 3;
    }

}
