package billtest;

/**
 * @ClassName multplication
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/8 14:46
 * @Version 1.0
 **/
public class Multplication {

    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j+"x"+i+"="+i*j+" ");
            }
            System.out.println();
        }
    }

}
