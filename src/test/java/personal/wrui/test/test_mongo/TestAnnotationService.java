package personal.wrui.test.test_mongo;

import org.springframework.stereotype.Service;

@Service
public class TestAnnotationService {
	
	@PrometheusAnnotation
	public void test() {
		System.out.println("test");
	}

}
