package lib;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: August 19, 2014
 * Time: 14:39
 */
public class Commons {

	public static void main(String... args) throws InvocationTargetException,
			IllegalAccessException {

		Target d = new Target();
		Original o = new Original();
		long start = System.currentTimeMillis();
		BeanUtils.copyProperties(d, o);
		BeanUtils.copyProperties(d, o);
		BeanUtils.copyProperties(d, o);
		System.out.println(System.currentTimeMillis() - start);

		start = System.currentTimeMillis();
		d.setId(o.getId());
		d.setName(o.getName());
		d.setDescription(o.getDescription());
		d.setId(o.getId());
		d.setName(o.getName());
		d.setDescription(o.getDescription());
		d.setId(o.getId());
		d.setName(o.getName());
		d.setDescription(o.getDescription());
		System.out.println(System.currentTimeMillis() - start);
	}

	static class Original {

		int id =1;

		String name = "13123123123123";

		String description = "123123123123123";

		public int getId() {

			return id;
		}

		public void setId(int id) {

			this.id = id;
		}

		public String getName() {

			return name;
		}

		public void setName(String name) {

			this.name = name;
		}

		public String getDescription() {

			return description;
		}

		public void setDescription(String description) {

			this.description = description;
		}
	}

	static class Target {

		int id;

		String name;

		String description;

		public int getId() {

			return id;
		}

		public void setId(int id) {

			this.id = id;
		}

		public String getName() {

			return name;
		}

		public void setName(String name) {

			this.name = name;
		}

		public String getDescription() {

			return description;
		}

		public void setDescription(String description) {

			this.description = description;
		}
	}
}
