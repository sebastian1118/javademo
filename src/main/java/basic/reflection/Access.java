//package basic.reflection;
//
//import basic.Dummy;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.*;
//
///**
// * Created with IntelliJ IDEA.
// * User: Sebastian MA
// * Date: August 24, 2014
// * Time: 12:20
// */
//public class Access {
//
//	public static <T> Map<String, Set<Object>> enumerateProperties(List<T> list,
//	                                                               String... names) throws
//			NoSuchFieldException, IllegalAccessException, NoSuchMethodException,
//			InvocationTargetException {
//
//		Map<String, Set<Object>> map = new HashMap<>();
//		for(T t : list) {
//			for(String name : names) {
//				if(map.get(name) == null) {
//					map.put(name, new HashSet<>());
//				}
//				map.get(name).add(
//						t.getClass().getDeclaredMethod("get" + name.substring(0,
//								1).toUpperCase() + name.substring(1)).invoke(t));
//			}
//		}
//		return map;
//	}
//
//	public static void main(String... args) throws NoSuchFieldException, IllegalAccessException,
//			NoSuchMethodException, InvocationTargetException {
//		StopWatch sw = new StopWatch().start();
//		List<Dummy> list = new ArrayList<>();
//		for(int i = 0; i < 10000000; i++) {
//			list.add(new Dummy(i, "a"));
//		}
//		sw.mark("done list");
//
//		Map<String, Set<Object>> result = enumerateProperties(list, "id", "name");
//		sw.mark("end");
//		sw.prettyPrint();
//	}
//}
