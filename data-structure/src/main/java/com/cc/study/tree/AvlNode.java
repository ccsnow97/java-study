package com.cc.study.tree;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * 平衡二叉树节点
 *  插入删除的思路
 *  //todo 删除程序有bug, 导致getHeight()可能会出现 StackOverflowError
 *
 * @Date: 2020/04/10 15:13
 */
public class AvlNode<T extends Comparable<T>> {

    T elem;

    AvlNode<T> left;

    AvlNode<T> right;


    public AvlNode(T elem) {
        this.elem = elem;
    }

    //获取二叉树的高度
    public static int getHeight(AvlNode avlNode) {
        if (avlNode == null) {
            return 0;
        }
        int height = 1;
        height = Math.max(Math.max(height, getHeight(avlNode.left) + 1), getHeight(avlNode.right) + 1);
        return height;
    }

    //二叉树中序遍历
    public static <T extends Comparable<T>> List<T> midTraverse(AvlNode<T> avlNode) {
        if (avlNode == null) {
            return null;
        }
        List<T> result = new ArrayList<T>();
        midTraverse(avlNode, result);
        return result;
    }

    private static <T extends Comparable<T>> void midTraverse(AvlNode<T> avlNode, List<T> elemList) {
        if (avlNode == null) {
            return;
        }
        if (avlNode.left != null) {
            midTraverse(avlNode.left, elemList);
        }
        elemList.add(avlNode.elem);
        if (avlNode.right != null) {
            midTraverse(avlNode.right, elemList);
        }
    }

    public static <T extends Comparable<T>> void structurePrint(AvlNode<T> avlNode) {
        structurePrint(avlNode, 0);
    }

    static private <T extends Comparable<T>> void structurePrint(AvlNode<T> avlNode, int height) {
        if (avlNode == null) {
            return;
        }
        for (int i = 0; i < height; i++) {
            System.out.print("--");
        }
        System.out.println(avlNode.elem + "(" + height + ")");
        if (avlNode.left != null) {
            structurePrint(avlNode.left, height + 1);
        }
        if (avlNode.right != null) {
            structurePrint(avlNode.right, height + 1);
        }
    }

    //右单旋
    public static <T extends Comparable<T>> AvlNode<T> RR(AvlNode<T> root) {
        AvlNode<T> tempRoot = root;
        root = root.left;
        tempRoot.left = root.right;
        root.right = tempRoot;
        return root;
    }

    //左单旋
    public static <T extends Comparable<T>> AvlNode<T> LL(AvlNode<T> root) {
        AvlNode<T> tempRoot = root;
        root = root.right;
        tempRoot.right = root.left;
        root.left = tempRoot;
        return root;
    }

    //左右双旋
    public static <T extends Comparable<T>> AvlNode<T> LR(AvlNode<T> root) {
        root.left = LL(root.left);
        root = RR(root);
        return root;
    }

    //右左双旋
    public static <T extends Comparable<T>> AvlNode<T> RL(AvlNode<T> root) {
        root.right = RR(root.right);
        root = LL(root);
        return LL(root);
    }

    //插入
    public static <T extends Comparable<T>> AvlNode<T> insert(AvlNode<T> avlNode, T elem) {
        if (avlNode == null) {
            avlNode = new AvlNode<T>(elem);
        } else if (elem.compareTo(avlNode.elem) < 0) {
            avlNode.left = insert(avlNode.left, elem);
            if (getHeight(avlNode.left) > getHeight(avlNode.right) + 1) {
                if (elem.compareTo(avlNode.left.elem) < 0) {
                    avlNode = RR(avlNode);
                } else if (elem.compareTo(avlNode.left.elem) > 0) {
                    avlNode = LR(avlNode);
                }
            }
        } else if (elem.compareTo(avlNode.elem) > 0) {
            avlNode.right = insert(avlNode.right, elem);
            if (getHeight(avlNode.right) > getHeight(avlNode.left) + 1) {
                if (elem.compareTo(avlNode.right.elem) > 0) {
                    avlNode = LL(avlNode);
                } else if (elem.compareTo(avlNode.right.elem) < 0) {
                    avlNode = RL(avlNode);
                }
            }
        }
        return avlNode;
    }

    //删除
    public static <T extends Comparable<T>> DeleteSt<T> delete(DeleteSt<T> deleteSt, T elem) {
        AvlNode<T> root=deleteSt.root;
        AvlNode<T> avlNode=deleteSt.avlNode;
        if (avlNode == null || root==null) {
            return deleteSt;
        }
        if (avlNode.elem.compareTo(elem) == 0) {
            if (avlNode.left == null && avlNode.right == null) {
                return null;
            }
            int leftHeigth = getHeight(avlNode.left);
            int rightHeight = getHeight(avlNode.right);
            if (leftHeigth >= rightHeight) {
                AvlNode<T> max = findMax(avlNode.left);
                avlNode.elem = max.elem;
                avlNode.left = Optional.ofNullable(delete(new DeleteSt<T>(root,avlNode.left), max.elem)).map(e->e.avlNode).orElse(null);
            } else {
                AvlNode<T> min = findMin(avlNode.right);
                avlNode.elem = min.elem;
                avlNode.right = Optional.ofNullable(delete(new DeleteSt<T>(root,avlNode.right), min.elem)).map(e->e.avlNode).orElse(null);
            }
        } else if (avlNode.elem.compareTo(elem) < 0) {
            avlNode.right = Optional.ofNullable(delete(new DeleteSt<T>(root,avlNode.right), elem)).map(e->e.avlNode).orElse(null);
        } else {
            avlNode.left = Optional.ofNullable(delete(new DeleteSt<T>(root,avlNode.left), elem)).map(e->e.avlNode).orElse(null);
        }

        int leftHeigth = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeigth > rightHeight + 1) {
            root = RR(root);
        } else if (leftHeigth + 1 < rightHeight) {
            root = LL(root);
        }
        return new DeleteSt<>(root,avlNode);
    }

    @AllArgsConstructor
    static class DeleteSt<T extends Comparable<T>>{
        AvlNode<T> root;
        AvlNode<T> avlNode;
    }

    //找到最大值节点
    public static <T extends Comparable<T>> AvlNode<T> findMax(AvlNode<T> avlNode) {
        if (avlNode == null) {
            return null;
        }
        if (avlNode.right != null) {
            return findMax(avlNode.right);
        }
        return avlNode;
    }

    //找到最小值节点
    public static <T extends Comparable<T>> AvlNode<T> findMin(AvlNode<T> avlNode) {
        if (avlNode == null) {
            return null;
        }
        if (avlNode.left != null) {
            return findMin(avlNode.left);
        }
        return avlNode;
    }

    public static void main(String[] args) {
        AvlNode<Integer> root = new AvlNode<Integer>(2);
        int[] arr = {2, 11, 14, 15, 21, 23, 26, 31};
        int length = arr.length;
        length = 100;
        for (int i = 1; i <= length; i++) {
            int random = new Random().nextInt(30) + 10;
//           random=arr[i-1];
            root = insert(root, random);
        }
        structurePrint(root);
        System.out.println("***************");
        System.out.println(midTraverse(root));
        System.out.println("高度差：" + Math.abs(getHeight(root.left) - getHeight(root.right)));
        AvlNode<Integer> max = findMax(root);
        System.out.println("max=" + max.elem);
        System.out.println("*******************");
        for (int i = 1; i <= length; i++) {
            int random = new Random().nextInt(30) + 10;
//            random=31;
            root = Optional.ofNullable(delete(new DeleteSt<>(root,root), random)).map(e->e.root).orElse(null);
            System.out.println("***************");
            System.out.println("删除：" + random);
            if(root==null){
                break;
            }
            System.out.println(midTraverse(root));
            System.out.println("高度差：" + Math.abs(getHeight(root.left) - getHeight(root.right)));
            if(Math.abs(getHeight(root.left) - getHeight(root.right))>1){
                throw new RuntimeException("高度差大于1");
            }
            structurePrint(root);

        }
    }

}
