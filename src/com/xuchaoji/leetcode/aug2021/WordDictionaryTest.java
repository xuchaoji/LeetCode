package com.xuchaoji.leetcode.aug2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordDictionaryTest {


    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("shit");
    }



    private class WordDictionary {
        Tree root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Tree();
        }

        public void addWord(String word) {
            //防止破坏头部节点，新定义一个head
            Tree head = root;
            for(char c : word.toCharArray()){
                int t = c - 'a';
                //当子节点不存在该字符时，新生成一个子节点
                if(head.nums[t] == null){
                    head.nums[t] = new Tree();
                }
                System.out.println(head.toString());
                //指向子节点
                head = head.nums[t];
            }
            //最后的head对应的就是该单词最后的字符，此时结束符为true，表示存在一个以该字符结尾的单词
            head.isOver = true;
        }

        public boolean search(String word) {
            Tree head = root;
            return dfs(word , 0 , head);
        }

        public boolean dfs(String word , int index , Tree head){
            //当遍历到所查询单词末尾时，刚好该字符为结束符，即查询命中，返回true，否则返回false
            if(index == word.length()){
                if(head.isOver) return true;
                return false;
            }
            char c = word.charAt(index);
            //遇到‘.’进行26个子节点的遍历，子节点不为null则进行递归，命中一次直接返回true
            if(c == '.'){
                for(int i = 0 ; i < 26 ; i++){
                    if(head.nums[i] != null){
                        if(dfs(word , index+1 , head.nums[i])) return true;
                    }
                }
            }else{
                //定向寻找，当对应子节点为null时直接返回false，否则进行递归
                int t = c - 'a';
                if(head.nums[t] != null){
                    if(dfs(word , index+1 , head.nums[t])) return true;
                }
            }
            return false;
        }
    }

    class Tree{
        //子节点集合，对应26个英文字母，大小为26
        Tree[] nums;
        //单词结束符，用来判断截至到该节点的单词是否存在
        boolean isOver = false;
        public Tree(){
            nums = new Tree[26];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int i = 0; i < 26; i++) {
                if (nums[i] != null) {
                    sb.append((char) ('a' + i));
                }
                sb.append(", ");
            }
            sb.append("}");
            return sb.toString();
        }
    }

}
