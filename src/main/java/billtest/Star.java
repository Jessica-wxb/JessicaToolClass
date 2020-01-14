package billtest;

/**
 * @ClassName Star
 * @Description TODO
 * @Author 王小波
 *
 *
 * @Date 2020/1/8 15:07
 * @Version 1.0
 **/
public class Star {

    public static final int INT = 6;
    public static final int INT1 = 5;

    public static void main(String[] args) {
        for (int i = 1; i < INT; i++) {

            for (int j = 0; j < INT1 -i  ; j++) {
                System.out.print(" ");
            }

            for (int j =0; j < 2*i-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }
}
