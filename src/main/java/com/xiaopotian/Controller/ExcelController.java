package com.xiaopotian.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 导出Excel控制层
 *
 * @Author  Bob Simon
 * @Date 2018-01-08 17:45
 */
@RestController
public class ExcelController {
    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    public void excel(HttpServletResponse response) throws Exception {
        ExcelData data = new ExcelData();
        /*
          需要特别注意的是：
            这里的titles的size()要和每个row的size()要一样；
            在这里titles和row指的该方法的List
        */
        
        /**
         * excel页标签名
         */
        data.setName("hello");
        
        /**
         * excel标题
         */
        List<String> titles = new ArrayList();
        titles.add("a1");
        titles.add("a2");
        titles.add("a3");
        data.setTitles(titles);

        /**
         * excel对应每列的数据
         */
        List<List<Object>> rows = new ArrayList();
        List<Object> row = new ArrayList();
        row.add("11111111111");
        row.add("22222222222");
        row.add("3333333333");
        rows.add(row);

        data.setRows(rows);


        //生成本地
        /*File f = new File("c:/test.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();*/
        ExportExcelUtils.exportExcel(response,"hello.xlsx",data);
    }
}
