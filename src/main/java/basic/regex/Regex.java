package basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 14/2/14
 * Time: 15:39
 */
public class Regex {

	public static void main(String... args) {

		System.out.println("123@abc.com".matches(".*@.*\\..*"));
		System.out.println("008615211111111".matches("(((00)|\\+)86)?[0-9]{11}"));

		System.out.println(System.class.getSimpleName());

		System.out.println(("pS5kb2N4.docx")
				.matches(".*\\.(docx|doc)$"));


		String review
				=
				"商品是否给力？快分享你的购买心得吧~不愧是这个销量最大的买家，全五星好评！东西质量非常好，卖家服务态度也很好！前段时间网络故障，所以付款晚了，不好意思啊！！！" +
						" " +
						"质量非常好，服务更是没话说，送的东西也非常好，全五星好评，我已经推荐朋友了，他们都要买这个，估计需要20" +
						"个左右，我下次还会来的，祝生意红火！呵呵谢谢！";

		String ANY_SIGN = "([,\\.;?，。？；]*)";

		System.out.println("1=" + review.matches("？*"));

		String report = "aaaaaaa NBA1234 合格aaaaaaaaaaaa";
		System.out.println("b=" + report.matches(".*NBA1234.{0,20}合格.*"));


		System.out.println("c=" + "2014-01-02".matches("[0-9一二三四五六七八九十零〇]{2," +
				"4}-[0-9一二三四五六七八九十零〇]{1," +
				"2}-[0-9一二三四五六七八九十零〇]{1,2}"));

		Pattern p
				= Pattern.compile("[0-9一二三四五六七八九十零〇]{2,4}[年|/|-][0-9一二三四五六七八九十零〇]{1," +
				"2}(月|-|/)[0-9一二三四五六七八九十零〇]{1,2}日?");
		Matcher m = p.matcher("发饰发带发到付一二年三月五日的撒一二年三月五日发发2012-02-13钱未付2012/02/13啊啊啊");

		while(m.find()) {
			System.out.println(m.group(0));
		}




		Pattern pattern
				= Pattern.compile("[0-9]+--");


		Matcher mm = pattern.matcher("http://zone.suning" +
				".com/review/product_review/000000000107307012-0-190--" +
				".html");
		while(mm.find()) {
			System.out.println(mm.group(0).substring(0,mm.group(0).length()-2));
		}
	}
}
