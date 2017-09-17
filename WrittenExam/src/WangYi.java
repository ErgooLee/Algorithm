import java.util.HashSet;
import java.util.Set;

public class WangYi {
    public static void main(String[] args) {
        String s = "(())()";
        Set<String> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String w = s.substring(0, i) + s.substring(i + 1);
            for (int j = 0; j < len - 1; j++) {
                String u = w.substring(0, j) + s.charAt(i) + w.substring(j);
                int temp = 0;

                for (int k = 0; k < len; k++) {
                    temp += (u.charAt(k) == '(' ? 1 : -1);
                    if (temp < 0) {
                        break;
                    }
                }

                if (temp >= 0) {
                    set.add(u);
                }
            }
        }
        System.out.println(set.size() - 1);
    }
}
