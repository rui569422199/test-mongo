package personal.wrui.test.test_mongo.service;

import personal.wrui.test.test_mongo.pojo.TestDao;

/**
 * 测试表
 * @author wrui
 */
public interface ITestService {

	void insert(TestDao test);
	
	void findById(String id);
}
