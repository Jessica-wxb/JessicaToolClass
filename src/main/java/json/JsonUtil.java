package json;


import net.sf.json.JSONArray;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.xml.XMLSerializer;
import java.util.List;

/**
 * @ClassName JsonUtil
 * @Description 处理json数据格式的工具类
 * @Author 王小波
 * @Date 2020/1/9 15:10
 * @Version 1.0
 **/
public class JsonUtil {
    /**
     * 将数组转换成String类型的Json数据格式
     *
     * @param objects
     * @return
     */
    public static String array2json(Object[] objects){

        JSONArray jsonArray = JSONArray.fromObject(objects);
        return jsonArray.toString();

    }

    /**
     * 将list集合转换成String类型的JSON数据格式
     *
     * @param list
     * @return
     */
   /* public static String list2json(List list) {
        JSONArray jsonArray=JSONArray
    }*/


}
