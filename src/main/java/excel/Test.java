package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/10 10:36
 * @Version 1.0
 **/
public class Test {
    /**
     * 读取少于1000行的excels
     */
    @org.junit.Test
    public void readLessThan1000Row() {
        String filePath = "/Users/Administrator/Desktop/Jessica.xlsx";
        List<Object> objects = ExcelUtil.readLessThan1000Row(filePath);
        objects.forEach(System.out::println);
    }

    /**
     * 读取少于1000行的excel,可以指定sheet和从几行读起
     */
    @org.junit.Test
    public void readLessThan1000RowBySheet() {
        String filePath = "/Users/Administrator/Desktop/Jessica.xlsx";
        Sheet sheet = new Sheet(1, 1);
        List<Object> objects = ExcelUtil.readLessThan1000RowBySheet(filePath,sheet);
        objects.forEach(System.out::println);
    }

    /**
     * 读取大于1000行的excel
     * 带sheet参数的方法可参照测试方法readLessThanRowsBySheet()
     */
    @org.junit.Test
    public void readMoreThan1000Row() {
        String filePath = "/Users/Administrator/Desktop/Jessica.xlsx";
        List<Object> objects = ExcelUtil.readMoreThan1000Row(filePath);
        objects.forEach(System.out::println);
    }

    @org.junit.Test
    public void writeBySimple() {
        String filePath = "/Team3.0/00 Manage  Code/JessicaToolTestSecondTime/template.xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("111", "222", "333"));
        data.add(Arrays.asList("111", "222", "333"));
        data.add(Arrays.asList("111", "222", "333"));
        List<String> head = Arrays.asList("表头1", "表头2", "表头2");
        ExcelUtil.writeBySimple(filePath,data,head);
    }

    /**
     * 生成excel，带用模型
     * 带sheet参数的方法可参照测试方法readLessThan1000RowBySheet()
     */
    @org.junit.Test
    public void writeWithTemple() {
        String filePath = "/Team3.0/00 Manage  Code/JessicaToolTestSecondTime/test2.xlsx";
        ArrayList<TableHeaderExcelProperty> data = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
            tableHeaderExcelProperty.setName("cmj" + i);
            tableHeaderExcelProperty.setAge(22 + i);
            tableHeaderExcelProperty.setSchool("北京大学" + i);
            data.add(tableHeaderExcelProperty);
        }
        ExcelUtil.writeWithTemplate(filePath,data);

    }
    /**
     * 生成excel,带用模型，带多个sheet
     */
    @org.junit.Test
    public void writeWithMultipleSheet() {
        ArrayList<ExcelUtil.MultipleSheelPropety> list1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ArrayList<TableHeaderExcelProperty> list = new ArrayList<>();
            for (int j = 0; j <4 ; j++) {
                TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
                tableHeaderExcelProperty.setName("cmj" + i);
                tableHeaderExcelProperty.setAge(22 + i);
                tableHeaderExcelProperty.setSchool("清华大学" + i);
                list.add(tableHeaderExcelProperty);
            }
            Sheet sheet = new Sheet(i, 0);
            sheet.setSheetName("sheet" + i);

            ExcelUtil.MultipleSheelPropety multipleSheelPropety = new ExcelUtil.MultipleSheelPropety();
            multipleSheelPropety.setData(list);
            multipleSheelPropety.setSheet(sheet);

            list1.add(multipleSheelPropety);
        }
        ExcelUtil.writeWithMultipleSheet("/Team3.0/00 Manage  Code/JessicaToolTestSecondTime/test2.xlsx",list1);

    }

    /*******************匿名内部类，实际开发中该对象要提取出去**********************/


    /**
     * @description:
     * @author: chenmingjian
     * @date: 19-4-3 14:44
     */
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class TableHeaderExcelProperty extends BaseRowModel {

        /**
         * value: 表头名称
         * index: 列的号, 0表示第一列
         */
        @ExcelProperty(value = "姓名", index = 0)
        private String name;

        @ExcelProperty(value = "年龄",index = 1)
        private int age;

        @ExcelProperty(value = "学校",index = 2)
        private String school;
    }
}
