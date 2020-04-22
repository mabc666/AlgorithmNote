package pers.ma.jianzhioffer;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题7
 *
 * 问题：根据二叉树的前序遍历结果和中序遍历结果构建二叉树
 *
 * 例子：
 * 假设这里我们的前序和中序遍历分别为{1，2，4，7，3，5，6，8}、{4，7，2，1，5，3，8，6}
 * 然后我们根据这两个序列构建一颗二叉树
 *          1
 *       2     3
 *     4     5    6
 *       7       8
 *
 *  解决方案：
 * 首先要清楚前序遍历和中序遍历的遍历顺序分别为，根左右和左根右，这样我们可以根据前序中的根然后再中序遍历中将其左右子树进行区分
 * 然后这样可以进行递归的构建二叉树。
 *  时间复杂度：
 *  这题时间复杂度不太好估计这个根树的结构有关，空间复杂度应该是个O(N)的级别(N是树的结点个数)
 *
 * @author mabc
 * @date 2020/4/21
 */

public class ConstructBinaryTree {
    //构造结点类
    static class TreeNode {
        //简化一下树的结构，只使用结点
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
    }

    public static TreeNode buildBinaryTree(List<Integer> preorder, List<Integer> inorder) {
        //生成返回的根节点
        TreeNode root = null;
        if (preorder.size() != 0 && inorder.size() != 0 && preorder != null && inorder != null) {
            root = new TreeNode();
            //根节点数据肯定是前序遍历的第一个数据
            root.data = preorder.get(0);
            if (preorder.size() == 1 && inorder.size() == 1) {
                //这里判断一下该序列是否只有一个数据，只有一个数据的话说明是个叶子结点了
                root.leftChild = null;
                root.rightChild = null;

            } else {
                //确定根节点在中序遍历中的位置，这里就是找一个划分点
                int rootIndexInInorder = inorder.indexOf(root.data);
                //进行前序序列和中序序列的划分，将左子树和右子树的前序和中序序列分别截取出来
                //左子树的前序和中序
                List<Integer> newLeftPreorder = preorder.subList(1, rootIndexInInorder + 1);
                List<Integer> newLeftInorder = inorder.subList(0, rootIndexInInorder);
                //右子树的前序和中序
                List<Integer> newRightPreorder = preorder.subList(rootIndexInInorder + 1, preorder.size());
                List<Integer> newRightInorder = inorder.subList(rootIndexInInorder + 1, inorder.size());
                //基于上述两个参数进行左右子树的递归构造
                root.leftChild = buildBinaryTree(newLeftPreorder, newLeftInorder);
                root.rightChild = buildBinaryTree(newRightPreorder, newRightInorder);

            }
        }
        return root;
    }
    //前序打印
    public static void preorderPrint(TreeNode root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preorderPrint(root.leftChild);
            preorderPrint(root.rightChild);
        }
    }
    //中序打印
    public static void inorderPrint(TreeNode root) {
        if(root != null) {
            inorderPrint(root.leftChild);
            System.out.print(root.data + " ");
            inorderPrint(root.rightChild);
        }
    }
    //后序打印
    public static void postorderPrint(TreeNode root) {
        if(root != null) {
            postorderPrint(root.leftChild);
            postorderPrint(root.rightChild);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        //前序遍历序列
        List<Integer> preorder = Arrays.asList(1, 2, 4, 7, 3, 5, 6, 8);
        //中序遍历序列
        List<Integer> inorder = Arrays.asList(4, 7, 2, 1, 5, 3, 8, 6);
        //创建树根结点
        TreeNode root = buildBinaryTree(preorder, inorder);
        //下面几个函数主要用于验证我们创建的树是否正确
        preorderPrint(root);
        System.out.println();
        inorderPrint(root);
        System.out.println();
        postorderPrint(root);



    }


}
