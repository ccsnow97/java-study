package com.cc.study.jdk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2020/06/19 11:43
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }


    public static TreeNode flatToTree(List<Integer> list){
        Map<Integer,TreeNode> map = new HashMap<>();
        for(int i=1;i<=list.size();i++){
            Integer value = list.get(i - 1);
            if(value!=null) {
                TreeNode node = new TreeNode(value);
                map.put(i,node);
                if(i==1)continue;
                TreeNode parent = map.get(i/2);
                if(i%2==0) parent.left=node;
                if(i%2==1) parent.right=node;
            }
        }
        return map.get(1);
    }
}
