package basic.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 26/1/14
 * Time: 15:23
 */
@XmlRootElement(name = "model")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlModel {

	@XmlAttribute
	private Integer id;

	private String name;

	private Integer age;

	public XmlModel() {

	}

	public XmlModel(Integer id, String name, Integer age) {

		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String toString() {

		return "[" + super.toString() + " id=" + id + " name=" + name + " age=" + age + "]";
	}

	public static void main(String... args) {

		XmlModel model = new XmlModel(1, "Alice", 25);

		String xml = marshal(model);
		XmlModel model1 = (XmlModel) unmarshal(model.getClass(), xml);
		System.out.println(model1);

	}

	private static String marshal(Object model) {

		try {
			JAXBContext jaxbContext = null;
			jaxbContext = JAXBContext.newInstance(model.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			marshaller.marshal(model, System.out);
			marshaller.marshal(model, sw);
			return sw.toString();
		} catch(JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Object unmarshal(Class clazz, String xml) {

		try {
			JAXBContext jaxbContext = null;
			jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller marshaller = jaxbContext.createUnmarshaller();
			return marshaller.unmarshal(new StringReader(xml));
		} catch(JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
