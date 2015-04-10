package lib.mongodb;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: November 18, 2014
 * Time: 10:57
 */
public class Playground {

	public static void main(String... args) {

		Mongo mongo = null;
		try {
			mongo = new MongoClient("dev.triiskelion.org");
			DB db = mongo.getDB("test");

			DBCollection collection = db.getCollection("user");
			DBCursor c = collection.find();

			System.out.println(c.next());
			collection.update(new BasicDBObject().append("name", "admin"), new BasicDBObject()
					.append("name", "admin").append("sex", "f"));
			mongo.close();
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
