package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * 基于com.google.code.gson转换工具类
 *
 * @ClassName GsonUtil
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/9 9:13
 * @Version 1.0
 **/


public class GsonUtil {
    private static Gson gson = null;
    static{
        if (gson==null) {
            gson = new Gson();
        }
    }

    public GsonUtil() {
    }

    /**
     * 对象换成json
     *
     * @param object
     * @return json
     */
    public static String gsonString(Object object) {
        String gsonString = null;
        if (gson !=null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * Json转成对象
     *
     * @param gsonString
     * @param cls
     * @return 对象
     */
    public static <T> T gsonToBean(String gsonString,Class<T> cls) {
        T t = null;
        if (gson !=null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * json转成list<T>
     *
     * @param gsonString
     * @param cls
     * @return list<T>
     */
    public static <T> List<T> gsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson!=null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * json转成list中有map的
     *
     * @param gsonString
     * @return List<Map < Stirng, T>>
     */
    public static <T> List<Map<String, T>> gsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson!=null) {
            list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
            }.getType());
        }
        return list;
    }

    /**
     * json转成map的
     *
     * @param gsonString
     * @return map<String, T>
     */
    public static <T> Map<String, T> gsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson!=null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String,T>>(){}.getType());
        }
        return map;
    }
}
