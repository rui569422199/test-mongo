package personal.wrui.test.test_mongo.annotation;

import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(CLASS)
public @interface PrimaryAccess {
}
