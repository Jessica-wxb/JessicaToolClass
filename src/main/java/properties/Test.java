package properties;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/7 14:55
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        String path = "test.properties";
        String key = "username1";
        String defaultValue = "password";
        String result = PropertiesUtil.getProperty(path, key, defaultValue);
        String result1 = PropertiesUtil.getProperties(path, key);
        System.out.println("result   "+result);
        System.out.println("result1   "+result1);
    }
}
