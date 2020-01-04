package cn.skylaker.leetcode.stack;

import org.junit.jupiter.api.Test;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class L20_CorrectBrackets {
    @Test
    public void test(){
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{[{()}]}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()"));
        System.out.println(isValid("("));
        System.out.println(isValid(")"));
    }

    public boolean isValid(String s) {
        if(null == s || "" == s){
            return true;
        }

        char[] chars = s.toCharArray();

        char[] stack = new char[chars.length];
        int current = -1;

        for(int i = 0; i < chars.length; i++){
            if("(".equals(String.valueOf(chars[i])) || "[".equals(String.valueOf(chars[i])) || "{".equals(String.valueOf(chars[i]))){
                stack[++current] = chars[i];
            }

            if(")".equals(String.valueOf(chars[i]))){
                if(-1 == current){
                    return false;
                }
                char top = stack[current];
                if("(".equals(String.valueOf(top))){
                    current--;
                } else {
                    return false;
                }
            }
            if("]".equals(String.valueOf(chars[i]))){
                if(-1 == current){
                    return false;
                }
                char top = stack[current];
                if("[".equals(String.valueOf(top))){
                    current--;
                } else {
                    return false;
                }
            }
            if("}".equals(String.valueOf(chars[i]))){
                if(-1 == current){
                    return false;
                }
                char top = stack[current];
                if("{".equals(String.valueOf(top))){
                    current--;
                } else {
                    return false;
                }
            }
        }

        if(-1 != current){
            return false;
        }

        return true;
    }
}
