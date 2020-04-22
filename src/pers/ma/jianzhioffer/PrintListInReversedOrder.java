package pers.ma.jianzhioffer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题6
 *
 * 问题：从尾到头访问链表中的内容
 *
 * 例子：
 * 问题比较简单不做过多的阐述
 *
 *
 *  解决方案：
 * 这里我假设我们不改变链表的结构的话，我们可以使用栈结构，使用其先进后出的特性很容易就能够实现反向访问了。
 *
 *  时间复杂度：
 *  时间复杂度O(n) 空间复杂度O(n)
 *
 * @author mabc
 * @date 2020/4/21
 */
public class PrintListInReversedOrder {
    public static void reversePrint(List<Character> list)
    {
        Stack<Character> stack  = new Stack<>();
        for (Character temp: list) {
            stack.push(temp);
        }
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
    public static void main(String[] args)
    {
        List<Character> list = new LinkedList<>();
        list.add('h');
        list.add('e');
        list.add('l');
        list.add('l');
        list.add('o');
        reversePrint(list);
    }
}
