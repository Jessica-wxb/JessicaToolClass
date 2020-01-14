package xml;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/7 16:39
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        String path = "/Team3.0/00 Manage  Code/JessicaToolTestSecondTime/src/main/resources/test.xml";
        String tagName = "className";
        Object bean = XMLUtil.getBean(path, tagName);
        System.out.println(bean.getClass().getPackage());

    }
}
