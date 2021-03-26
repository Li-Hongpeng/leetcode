package editor.cn;
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
//字符串长度与生成的数组长度的公式为：列数=（（s.length（）/（numRows+numRows-2））*（numRows-2+1）+（余数/4）*1+（（余数-4）/1）*1）
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1076 👎 0


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if(s.length()<numRows) return s;
        if(numRows==1) return s;
//        （（s.length（）/（numRows+numRows-2））*（numRows-2+1）+（余数/4）*1+（（余数-4）/1）*1）
        int columnLength = 0;
        int t = (s.length()/(2*numRows-2))*(numRows-1);//有多少个勾周期列，可以为0
        int r = s.length()%(2*numRows-2);//减去勾周期后还剩多少个剩余
        StringBuilder ret = new StringBuilder("");
        if(r>numRows) columnLength=t+1+r-numRows; //如果剩余的元素超过行数 每多一个添加一列
        else columnLength=t+1;
        char[][] zForm = new char[numRows][columnLength];//创建大小合适的二维表
        for(int i=0;i<s.length();i++){  //遍历整个字符串
            int x=0;
            int y=0;
            if(i%(2*numRows-2)<=numRows-1){
                x = i%(2*numRows-2);
                y=(i/(2*numRows-2))*(numRows-1);
                zForm[x][y] = s.charAt(i);
            }
            else{
                x=2*(numRows-1)-i%(2*numRows-2);
                y=(i/(2*numRows-2))*(numRows-1)+i%(2*numRows-2)-numRows+1;
                zForm[x][y]=s.charAt(i);
            }
        }
        for(int i=0;i<zForm.length;i++){
            for(int j=0;j<zForm[i].length;j++){
                if(zForm[i][j]!='\0') ret.append(zForm[i][j]);
            }
        }
        return ret.toString();



    }
}
//leetcode submit region end(Prohibit modification and deletion)
