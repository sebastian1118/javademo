package basic.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sebastian MA
 */
public class Stream {


	public static void main(String... args) {

		List<Integer> list = Arrays.asList(1, 2, 3);


		List<Integer> result = list.stream().map((x) -> Arrays.asList(x, x, x))
		                           .flatMap(Collection::stream)
		                           .collect(Collectors.toList());

		System.out.println(result);
	}
}
