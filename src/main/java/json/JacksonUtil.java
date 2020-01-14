package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Data;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName JacksonUtil
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/13 17:52
 * @Version 1.0
 **/
public class JacksonUtil {

    private Product product2;

    // 将Product转换json
    @Test
    public void test1() {
        Product product = new Product();
        product.setId(1);
        product.setName("TV");
        product.setReleaseDate(new Date());

        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        String json = null;
        try {
            json = mapper.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    // 将List<Product>转换成json
    @Test
    public void test2() {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("电视机");
        product1.setPrice(2000);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("电视机");
        product2.setPrice(3000);

        List<Product> ps = new ArrayList<>();
        ps.add(product1);
        ps.add(product2);

        ObjectMapper mapper = new ObjectMapper();
        // 处理过滤属性
        FilterProvider fp = new SimpleFilterProvider().addFilter("productFilter", SimpleBeanPropertyFilter.serializeAllExcept("id", "name"));
        mapper.setFilters(fp);
        String json = null;
        try {
            json = mapper.writeValueAsString(ps);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    @Data
    public class Product {
        private int id;
        private String name;
        private double price;
        private Date releaseDate;
    }

}
