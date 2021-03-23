package editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5164 👎 0
//使用动态规划和哈希表（HashMap）实现，仔细思考，构建合适的状态转移函数。思路，以某个字符为结尾的所有字串，以此遍历整个字符串。

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
//        Map<Character,Integer> dic=new HashMap<>();
//        int res=0;
//        int tmp=0;
//        for(int j=0;j<s.length();j++){
//            int i=dic.getOrDefault(s.charAt(j),-1);
//            dic.put(s.charAt(j),j);
//            tmp=tmp<j-i?tmp+1:j-i;
//            res=Math.max(res,tmp);
//        }
//        return res;
        int res=0;
        int tmp=0;
        Map<Character,Integer> dic = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int closestSame = dic.getOrDefault(s.charAt(i),-1);
            dic.put(s.charAt(i),i);
            tmp=tmp<i-closestSame?tmp+1:i-closestSame;
            res = Math.max(res,tmp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
