package yaml;

import java.util.Map;
import java.util.Properties;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/7 10:26
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        String path = "test.yaml";
        Map<String, Object> stringObjectMap = YamlUtil.yaml2Map(path);
        System.out.println(stringObjectMap);

        Properties properties = YamlUtil.yaml2Properties(path);
        System.out.println(properties);
    }
}
