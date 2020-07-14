package personal.wrui.test.test_mongo;

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
}
