package lib.poi;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Sebastian MA
 */
public class WordTemplate {

	public static void main(String... args) throws IOException, OpenXML4JException, XmlException {

		InputStream is = ClassLoader.getSystemResourceAsStream("t.docx");

		XWPFDocument document = new XWPFDocument(is);

		HashMap<String, String> param = new HashMap<>();
		param.put("plateNumber", "鲁B 123456");


		document.getBodyElements().forEach((x) -> {
			if(x instanceof XWPFTable) {
				XWPFTable table = ((XWPFTable) x);
				table.getRows().forEach(
						(row) -> row.getTableCells().forEach(
								(cell) -> cell.getParagraphs().forEach(
										(p) -> p.getRuns().forEach(
												(run) -> {

													String text = run.getText(0);
													System.out.println(text);
													if(text != null) {
														Iterator<String> it = param.keySet()
														                           .iterator();
														while(it.hasNext()) {
															String key = it.next();
															text = text.replaceAll(
																	"\\$" + key,
																	param.get(key)
															                      );
														}
														run.setText(text, 0);
													}
												}))));
			}

		});


		File output = new File("output.docx");
		if(output.exists()) {
			output.delete();
		}
		FileOutputStream out = new FileOutputStream(output);
		document.write(out);

	}
}
