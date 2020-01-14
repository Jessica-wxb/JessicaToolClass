package pdf;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/14 8:50
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        String path = "/Team3.0/00 Manage  Code/JessicaToolTestSecondTime/src/test/jiayou.pdf";
        File file = new File(path);
        file.createNewFile();
        new PdfUtil(file).generatePDF();
    }
}
