package word;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/9 15:51
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        // 将数据存到map中
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("username", "张三");
        dataMap.put("sex", "男");
        String templateFile = "/Team3.0/00 Manage  Code/JessicaToolTestSecondTime/template.ftl";
        String exportFile = "/Team3.0/00 Manage  Code/JessicaToolTestSecondTime/src/test3.doc";
        WordUtil.getInstance().createDocFile(templateFile, dataMap, exportFile, 1);
    }
}
