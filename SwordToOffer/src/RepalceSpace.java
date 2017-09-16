
/**
 * Created by lichao on 11/07/2017.
 * 题目描述
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class RepalceSpace {
    public static String replaceSpace(StringBuffer str) {
        int count = 0;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                count++;
            }
            i++;
        }
        str.ensureCapacity(str.length() + 2 * count);
        str.setLength(str.length() + 2 * count);
        i = i - 1;
        while (count > 0) {
            if (str.charAt(i)!=' '){
                str.setCharAt(i + 2 * count, str.charAt(i));
            }else{
                str.setCharAt(i + 2 * count, '0');
                str.setCharAt(i + 2 * count -1,'2');
                str.setCharAt(i + 2 * count- 2,'%');
                count--;
            }
            i--;
        }
        return str.toString();
    }
}
