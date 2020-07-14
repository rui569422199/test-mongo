package personal.wrui.test.test_mongo.service.impl;

import org.springframework.stereotype.Service;

import personal.wrui.test.test_mongo.service.ICalleeService;

@Service
public class CalleeServiceImpl implements ICalleeService {

	public boolean called() {
		return false;
	}

}
