package yaml;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;
import java.util.Properties;

/**
 * @ClassName YamlUtil
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/7 10:25
 * @Version 1.0
 **/
public class YamlUtil {
    /*
     * Spring提供的yaml工具只能解析出map和properties，如果想解析生成java bean就有点力不从心了。
     *
     * */
    public static Map<String, Object> yaml2Map(String yamlSource) {
        /*
        * 1、加载yaml
        * Spring Framework提供了两个方便的类，可以用加载yaml文档。
        * YamlPropertiesFactoryBean将Yaml作为Properties加载;
        * YamlMapFactory将Yaml作为Map加载；
        * */

        // YamlMapFactory将Yaml作为Map加载
        YamlMapFactoryBean bean = new YamlMapFactoryBean();
        // 可以加载多个yaml文件
        // 使用ClassPathResource 访问类加载路径下的资源
        bean.setResources(new ClassPathResource(yamlSource));
        return bean.getObject();
    }

    public static Properties yaml2Properties(String yamlSource) {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(yamlSource));
        return yaml.getObject();
    }

}
