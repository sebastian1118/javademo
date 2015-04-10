package lib.jxls;

import org.apache.commons.collections.map.HashedMap;
import org.joda.time.DateTime;

import java.util.Map;

/**
 * @author Sebastian MA
 */
public class Model {

	DateTime date = DateTime.now();

	Map<String, String> map = new HashedMap();

	public Model() {

		map.put("a", "hello");
		map.put("b", "world");
	}

	public DateTime getDate() {

		return date;
	}

	public void setDate(DateTime date) {

		this.date = date;
	}

	public Map<String, String> getMap() {

		return map;
	}

	public void setMap(Map<String, String> map) {

		this.map = map;
	}
}
