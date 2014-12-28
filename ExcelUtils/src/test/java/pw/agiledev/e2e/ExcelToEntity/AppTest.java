package pw.agiledev.e2e.ExcelToEntity;

import junit.framework.TestCase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pw.agiledev.e2e.ExcelHelper;
import pw.agiledev.e2e.exception.ExcelContentInvalidException;
import pw.agiledev.e2e.exception.ExcelParseException;
import pw.agiledev.e2e.exception.ExcelRegexpValidFailedException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static cn.jimmyshi.beanquery.BeanQuery.select;
import static cn.jimmyshi.beanquery.BeanQuery.value;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.startsWith;

/**
 * 功能说明： 单元测试
 * 参数说明：
 * @author 管宜尧
 * 2013-11-28 下午8:56:42
 */
public class AppTest extends TestCase {
	public AppTest() throws ExcelParseException{
		ExcelHelper.registerNewType(MyDataType.class);
		ExcelHelper.registerNewType(MyDataType2.class);
	}
	
    public void testApp() throws InvalidFormatException, IOException{
    	ExcelHelper eh = ExcelHelper.readExcel("F://model.xlsx");
		String[] headers = eh.getHeaders();
		String[][] datas = eh.getDatas();
		
		List<Demo> entitys  = null;
		try {
			entitys = eh.toEntitys(Demo.class);
			for (Demo d : entitys) {
				System.out.println(d.toString());
			}
		} catch (ExcelParseException e) {
			System.out.println(e.getMessage());
		} catch (ExcelContentInvalidException e) {
			System.out.println(e.getMessage());
		} catch (ExcelRegexpValidFailedException e) {
			System.out.println(e.getMessage());
		}
		
//		Assert.assertEquals(5, headers.length);
//		Assert.assertEquals(3, datas.length);
		//Assert.assertNotNull(entitys);
    }

	public static void main(String[] args) throws IOException, InvalidFormatException {
		ExcelHelper eh = ExcelHelper.readExcel("F://model.xlsx");

			String[] headers = eh.getHeaders();
			String[][] datas = eh.getDatas();

			List<Demo> entitys  = null;
			try {
				entitys = eh.toEntitys(Demo.class);
				List<Map<String,Object>> demos = select("propName","innerName").from(entitys).where(allOf(value("propName", startsWith("制造商")))).execute();
				for(Map<String,Object> demo : demos) {
					System.out.println(demo.get("propName") + " : " + demo.get("innerName"));
				}
		} catch (ExcelParseException e) {
			System.out.println(e.getCause().getLocalizedMessage());
		} catch (ExcelContentInvalidException e) {
			System.out.println(e.getMessage());
		} catch (ExcelRegexpValidFailedException e) {
			System.out.println(e.getMessage());
		}
	}

}
