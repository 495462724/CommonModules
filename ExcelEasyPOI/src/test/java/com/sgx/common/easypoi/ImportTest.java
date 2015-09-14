package com.sgx.common.easypoi;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Developer on 2015/9/14.
 */
public class ImportTest {

    @Test
    public void testMapImport(){
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        long start = new Date().getTime();
        List<Map<String, Object>> list = ExcelImportUtil.importExcel(new File("d:/tt.xlsx"),
                Map.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.get(1).get("sex3"));
    }

}
