package org.jeecgframework.poi.test.excel.read;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Map导入测试
 * @author JueYue
 * @date 2015年6月21日 下午10:56:03
 */
public class ExcelMapImportTest {

    @Test
    public void mapTest() {

        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        params.setDataHanlder(new MapImportHanlder());
        long start = new Date().getTime();
        List<Map<String, Object>> list = ExcelImportUtil.importExcel(new File("d:/tt.xlsx"),
            Map.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(list.get(0));

    }

}
