package lib.jxls;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: December 25, 2014
 * Time: 18:09
 */
public class Playground {


	public static void main(String... args) throws IOException, InvalidFormatException {

		HashMap beans = new HashMap();
		beans.put("a", "hello");


		List<Model> list = new ArrayList<>();
		list.add(new Model());
		list.add(new Model());
		list.add(new Model());
		beans.put("resultList", list);
		InputStream is = ClassLoader.getSystemResourceAsStream("jxls/template.xlsx");
		XLSTransformer transformer = new XLSTransformer();
		Workbook workbook = transformer.transformXLS(is, beans);


		File output = new File("output.xlsx");
		FileOutputStream out = new FileOutputStream(output);
		workbook.write(out);
	}


}
