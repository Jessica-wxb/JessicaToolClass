package properties;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName PropertiesUtil
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/7 14:54
 * @Version 1.0
 **/
public class PropertiesUtil {
    private static Properties props;

    /**
     * 方式1.通过context:property-placeholder加载配置文件jdbc.properties中的内容
     * 注意：这种方式下，如果你在spring-mvc.xml文件中有如下配置，则一定不能缺少下面的红色部分，关于它的作用以及原理，参见另一篇博客：context:component-scan标签的use-default-filters属性的作用以及原理分析
     * 方式2.使用注解的方式注入，主要用在java代码中使用注解注入properties文件中相应的value值
     * 方式3.使用util:properties标签进行暴露properties文件中的内容
     * 方式4.通过PropertyPlaceholderConfigurer在加载上下文的时候暴露properties到自定义子类的属性中以供程序中使用
     * 使用方式：在需要使用的类中使用@Autowired注解注入即可
     * 方式5.自定义工具类PropertyUtil，并在该类的static静态代码块中读取properties文件内容保存在static属性中以供别的程序使用
     * @param path
     */
    synchronized static private void loadProps(String path) {
        System.out.println("开始加载properties文件内容.......");
        props = new Properties();
        InputStream inputStream =null;
        try {

            // 第一种：通过类加载器进行获取properties文件流
            inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
            // 第二种：通过类进行获取properties文件流
            //inputStream = PropertiesUtil.class.getResourceAsStream("jdbc.properties");
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("properties文件未找到");
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.printf("jdbc.properties文件流关闭出现异常");
                }
            }
        }

        System.out.println("加载properties文件内容完成");
        System.out.println("properties文件内容："+props);
    }
    /*
    * 第四种方式：实现方式获取properties文件中指定key的value
    * */

    public static String getProperties(String path, String key) {
        if (props == null) {
            loadProps(path);
        }
        return props.getProperty(key);

    }

    /*
    * 第五种实现方式获取properties文件中指定的key的value
    * */

    public static String getProperty(String path, String key, String defaultValue) {
        if (props == null) {
            loadProps(path);
        }
        return props.getProperty(key, defaultValue);
    }
}
