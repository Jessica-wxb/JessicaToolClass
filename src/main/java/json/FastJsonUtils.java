package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * @ClassName FastJson
 * @Description 基于fastjson封装的json转换工具类
 * @Author 王小波
 * @Date 2020/1/9 14:43
 * @Version 1.0
 **/
public class FastJsonUtils {
    /**
     * 功能描述：把Json数据转换成指定的java对象
     *
     * @param jsonData       Json数据
     * @param clazz 指定的java对象
     * @return 指定的java对象
     */
    public static <T> T getJsonToBean(String jsonData, Class<T> clazz) {
        return JSON.parseObject(jsonData, clazz);
    }

    /**
     * 功能描述：把java对象转换成JSON数据
     *
     * @param object java对象
     * @Return JSON数据
     */
    public static String getBeanToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象列表
     *
     * @param jsonData JSON数据
     * @param clazz    指定的java对象
     * @return List<T>
     */
    public static <T> List<T> getJsonToList(String jsonData, Class<T> clazz) {
        return JSON.parseArray(jsonData, clazz);
    }

    /**
     * 功能描述：把JSON数据转换成为复杂的List<Map<String,Object>>
     *
     * @param jsonData JSON数据
     * @return List<Map < String, Object>>
     */
    public static List<Map<String, Object>> getJsonToListMap(String jsonData) {
        return JSON.parseObject(jsonData,new TypeReference<List<Map<String, Object>>>(){


        });
    }

}
