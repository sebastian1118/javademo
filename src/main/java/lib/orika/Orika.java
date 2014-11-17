package lib.orika;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: September 29, 2014
 * Time: 9:22
 */
public class Orika {

	public static void main(String... args) throws InvocationTargetException, IllegalAccessException {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(SourceObject.class, DestinationObject.class)
		             .byDefault()
		             .register();

		MapperFacade mapper = mapperFactory.getMapperFacade();

		SourceObject sourceObject = new SourceObject();
		sourceObject.setA(1);
		sourceObject.setB("2");

		long start = System.currentTimeMillis();
		DestinationObject dest = mapper.map(sourceObject, DestinationObject.class);
		System.out.println(System.currentTimeMillis() - start);

		start = System.currentTimeMillis();

		BeanUtils.copyProperties(dest, sourceObject);
		System.out.println(System.currentTimeMillis() - start);
	}
}
