package lib.commons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: December 26, 2014
 * Time: 11:02
 */
public class HttpClient {

	public static void main(String... args) {

		URI uri = null;
		try {
			uri = new URIBuilder()
					.setScheme("http")
					.setHost("api.map.baidu.com")
					.setPath("/geocoder/v2/")
					.setParameter("address", "中国海洋大学")
					.setParameter("output", "json")
					.setParameter("ak", "OSuWvASS1KBObk88XMrMulqd")
					.setParameter("callback", "")
					.build();

			System.out.println(uri.toString());

			HttpGet httpget = new HttpGet(uri);

			org.apache.http.client.HttpClient client = HttpClients.createMinimal();
			HttpResponse response = client.execute(httpget);

			String json = EntityUtils.toString(response.getEntity());
			System.out.println(json);
			JSONObject result = JSON.parseObject(json);
			result.getJSONObject("result").getJSONObject("location").getDouble("lng");

		} catch(URISyntaxException e) {
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

	class BaiduApiResult {

		int status;

		Geolocation location;

		int precise;

		int confidence;

		String level;

		public BaiduApiResult() {

		}

		public int getStatus() {

			return status;
		}

		public void setStatus(int status) {

			this.status = status;
		}

		public Geolocation getLocation() {

			return location;
		}

		public void setLocation(Geolocation location) {

			this.location = location;
		}

		public int getPrecise() {

			return precise;
		}

		public void setPrecise(int precise) {

			this.precise = precise;
		}

		public int getConfidence() {

			return confidence;
		}

		public void setConfidence(int confidence) {

			this.confidence = confidence;
		}

		public String getLevel() {

			return level;
		}

		public void setLevel(String level) {

			this.level = level;
		}
	}

	class Geolocation {

		double latitude;

		double longitude;


		public Geolocation(double latitude, double longitude) {

			this.latitude = latitude;
			this.longitude = longitude;
		}

		public double getLongitude() {

			return longitude;
		}


		public double getLatitude() {

			return latitude;
		}

	}
}
