package personal.wrui.test.test_mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import personal.wrui.test.test_mongo.annotation.ReplicaSetAccess;
import personal.wrui.test.test_mongo.service.ICalleeService;
import personal.wrui.test.test_mongo.service.ICallerService;
@Service
public class CallerServiceImpl implements ICallerService {
	
	@Autowired
	@Lazy
	private ICalleeService calleeService;
	
	@ReplicaSetAccess
	public boolean call() {
		return calleeService.called();
	}
	
}
