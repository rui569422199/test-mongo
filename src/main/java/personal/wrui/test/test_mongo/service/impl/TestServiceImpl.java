package personal.wrui.test.test_mongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.ReadPreference;
import com.mongodb.client.model.DBCollectionFindOptions;

import personal.wrui.test.test_mongo.pojo.TestDao;
import personal.wrui.test.test_mongo.service.ITestService;

/**
 * 测试表
 * @author wrui
 */
@Service
public class TestServiceImpl implements ITestService {
	
	@Autowired@Lazy
	private MongoTemplate mongoTemplate;

	@Override
	public void insert(TestDao test) {
		mongoTemplate.insert(test);
	}

	@Override
	public void findById(String id) {
//		Bson obj=new BsonDocument();
//		TransactionOptions option = TransactionOptions.builder().readPreference(ReadPreference.secondaryPreferred()).build();
//		ClientSessionOptions options=ClientSessionOptions.builder(options).build();
//		ClientSession session=ClientSession.class.newInstance();
//		mongoTemplate.find(new Query(), TestDao.class);
//		MongoCollection<Document> collection = mongoTemplate.getDb().getCollection("");
//		collection.find(clientSession, filter)
//		FindIterable<TestDao> result = mongoTemplate.getCollection("").find(session, obj);
		
		BasicDBObject obj=new BasicDBObject();
		obj.append("_id", id);
		DBCollectionFindOptions options=new DBCollectionFindOptions();
		options.readPreference(ReadPreference.secondaryPreferred());
		List<DBObject> result = mongoTemplate.getCollection("tb_test_wrui").find(obj, options).toArray();
		System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(result));
	}

}
