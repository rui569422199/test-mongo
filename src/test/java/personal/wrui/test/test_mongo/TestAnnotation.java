package personal.wrui.test.test_mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
@Service
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAnnotation {
//	@Autowired
//	TestAnnotationService testAnnotationService;

	@PrometheusAnnotation
	public void test() {
		System.out.println("test");
	}
	
	@Test
	public void testAnnotations() {
		test();
	}
}
