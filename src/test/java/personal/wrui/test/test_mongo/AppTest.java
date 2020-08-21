package personal.wrui.test.test_mongo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

import personal.wrui.test.test_mongo.pojo.TestDao;
import personal.wrui.test.test_mongo.service.ITestService;

/**
 * used test-resource application.properties
 * @author wrui
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	
	@Autowired@Lazy
	private ITestService testService;
	
	@Test
	public void testInsert() {
		TestDao test=new TestDao();
		test.setId("wrui1113");
		testService.insert(test);
	}
	
	@Test
	public void testFind() {
		testService.findById("wrui1113");
	}
	
	
	public static void main(String[] args) {
		Calendar cl=Calendar.getInstance();
		cl.set(Calendar.YEAR, 2020);
		cl.set(Calendar.DAY_OF_MONTH, 22);
		cl.set(Calendar.MONTH, Calendar.JULY);
		cl.add(Calendar.YEAR, 1);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cl.getTime()));
		cl.add(Calendar.YEAR, 1);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cl.getTime()));
		cl.add(Calendar.YEAR, 1);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cl.getTime()));
	}
}
