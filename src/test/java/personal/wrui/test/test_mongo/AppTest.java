package personal.wrui.test.test_mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import personal.wrui.test.test_mongo.pojo.TestDao;
import personal.wrui.test.test_mongo.service.ITestService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	
	@Autowired@Lazy
	private ITestService testService;
	
	@Autowired@Lazy
	private MongoTemplate mongoTemplate;

	@Test
	public void insert() {
		try {
			TestDao test=new TestDao();
			test.setId("wrui111");
			mongoTemplate.insert(test);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		TestDao test=new TestDao();
		test.setId("wrui1112");
		testService.insert(test);
	}
}
