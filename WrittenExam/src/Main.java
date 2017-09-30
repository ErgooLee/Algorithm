import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Integer a = 555;
        Integer b = 666;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);

    }

    public static void swap(Integer a, Integer b) {
        if (a == null || b == null) {
            return;
        }
        //获得a的class对象
        Class<Integer> integerClass = (Class<Integer>) a.getClass();
        try {
            //获得value属性
            Field value=integerClass.getDeclaredField("value");
            //设置权限为可访问
            value.setAccessible(true);
            //交换
            int temp=a;
            value.setInt(a,b);
            value.setInt(b,temp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

