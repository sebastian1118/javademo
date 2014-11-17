package basic.java8;


import basic.hierarchy.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: March 27, 2014
 * Time: 13:02
 */
public class Lamda {

	public static void main(String... args) {

		List<String> data = Arrays.asList("abc", "ab", "a", "abcd");
		Collections.sort(data, (a, b) -> {
			if(a.length() > b.length())
				return 1;
			else if(a.length() < b.length())
				return -1;
			else
				return 0;
		});
		data.forEach(System.out::println);

		new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end");
		}).start();


		Predicate<String> p = (s) -> true;


		Function<String, Integer> f1 = (s) -> 1;
		Function<Integer, Integer> func = (s) -> s + 1;
		func.compose(f1);

		Supplier<Person> sp = Person::new;

		Optional<String> optional = Optional.of("bam");

		System.out.println(optional);
	}
}
