package personal.wrui.test.test_mongo.config;


//package personal.wrui.test.test_mongo.config;
//
//import java.math.BigDecimal;
//
//import org.bson.types.Decimal128;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.ReadingConverter;
//import org.springframework.data.convert.WritingConverter;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
//import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
//import org.springframework.stereotype.Component;
//
///**
// * for mongo 3.0.1.RELEASE
// * @author wrui
// *
// */
//@Component
//@Configuration
//public class ApplicationConfig {
//	
//	private  MongoDatabaseFactory factory;
//	
//	@Bean
//	@Autowired
//    public MongoTemplate mongoTemplate(@Lazy MappingMongoConverter converter) throws Exception {
//        return new MongoTemplate(factory, converter);
//    }
//	
//	@Autowired
//    public MappingMongoConverter mappingMongoConverter(@Lazy MongoMappingContext mongoCongtext) throws Exception {
//		DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
//        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoCongtext);
//        MongoCustomConversions conversions = MongoCustomConversions.create((item)->{
//        	item.registerConverter(new BigDecimalToDecimal128Converter());
//        	item.registerConverter(new Decimal128ToBigDecimalConverter());
//        });
//        converter.setCustomConversions(conversions);
//        return converter;
//    }
//
//	public MongoDatabaseFactory getFactory() {
//		return factory;
//	}
//
//	@Autowired
//	public void setFactory(MongoDatabaseFactory factory) {
//		this.factory = factory;
//	}
//	
//	@ReadingConverter
//	@WritingConverter
//	public class BigDecimalToDecimal128Converter implements Converter<BigDecimal, Decimal128> {
//		 
//	    public Decimal128 convert(BigDecimal bigDecimal) {
//	        return new Decimal128(bigDecimal);
//	    }
//	    
//	}
//	
//	@ReadingConverter
//	@WritingConverter
//	public class Decimal128ToBigDecimalConverter implements Converter<Decimal128, BigDecimal> {
//	 
//		public BigDecimal convert(Decimal128 decimal128) {
//			return decimal128.bigDecimalValue();
//		}
//	}
//
//
//}
//package personal.wrui.test.test_mongo.config;
//
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Component;


/**
 * for mongo 3.0.1.RELEASE
 * @author wrui
 *
 */
@Component
@Configuration
public class ApplicationConfig {
	
	public MongoTemplate mongoTemplate;

	@Bean
	@Autowired@Lazy
    public MongoTemplate mongoTemplate(  MongoDbFactory factory, MongoMappingContext mongoCongtext) throws Exception {
		return new MongoTemplate(factory, mappingMongoConverter(factory,mongoCongtext));
    }
	
	private MappingMongoConverter mappingMongoConverter(MongoDbFactory factory,MongoMappingContext mongoCongtext) throws Exception {
        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoCongtext);
        List<Object> list = new ArrayList<>();
        list.add(new BigDecimalToDecimal128Converter());//自定义的类型转换器
        list.add(new Decimal128ToBigDecimalConverter());//自定义的类型转换器
        converter.setCustomConversions(new CustomConversions(list));
        return converter;
    }
	
	
	@Bean
    public CustomConversions mongoCustomConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new BigDecimalToDecimal128Converter());
        converterList.add(new Decimal128ToBigDecimalConverter());
        return new CustomConversions(converterList);
    }
	
	@ReadingConverter
	@WritingConverter
	public class BigDecimalToDecimal128Converter implements Converter<BigDecimal, Decimal128> {
		 
	    public Decimal128 convert(BigDecimal bigDecimal) {
	        return new Decimal128(bigDecimal);
	    }
	    
	}
	
	@ReadingConverter
	@WritingConverter
	public class Decimal128ToBigDecimalConverter implements Converter<Decimal128, BigDecimal> {
	 
		public BigDecimal convert(Decimal128 decimal128) {
			return decimal128.bigDecimalValue();
		}
	}


}
