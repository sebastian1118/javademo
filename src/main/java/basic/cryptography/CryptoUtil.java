package basic.cryptography;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 26/1/14
 * Time: 13:36
 */
public class CryptoUtil {

	private String key;

	private SecretKey generatedKey;

	CryptoUtil(String key) {

		this.key = key;

		KeyGenerator generator = null;
		try {
			generator = KeyGenerator.getInstance("DES");

			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(key.getBytes());
			generator.init(secureRandom);
			generatedKey = generator.generateKey();
			generator = null;
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public byte[] encrypt(byte[] array) {

		byte[] result = null;
		Cipher cipher;

		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, generatedKey);
			result = cipher.doFinal(array);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public byte[] decrypt(byte[] array) {

		Cipher cipher;
		byte[] result = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, generatedKey);
			result = cipher.doFinal(array);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return result;
	}

	public static byte[] encode(CharSequence string) {

		try {
			ByteBuffer bytes
					= Charset.forName("UTF-8").newEncoder().encode(CharBuffer.wrap(string));
			byte[] bytesCopy = new byte[bytes.limit()];
			System.arraycopy(bytes.array(), 0, bytesCopy, 0, bytes.limit());

			return bytesCopy;
		} catch(CharacterCodingException e) {
			throw new IllegalArgumentException("Encoding failed", e);
		}
	}

	public String md5(String raw) throws NoSuchAlgorithmException {

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(raw.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for(int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if(i < 0) {
					i += 256;
				}
				if(i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			//32位加密
			return buf.toString();
			// 16位的加密
			//return buf.toString().substring(8, 24);
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}


	public static void main(String... args) {

		String key = "trii";
		CryptoUtil util = new CryptoUtil(key);
		CryptoUtil util2 = new CryptoUtil(key);

		String source = "Hello world";
		System.out.println("Original string: " + source);
		byte[] result = util.encrypt(source.getBytes());
		System.out.println("Encrypted string: " + new String(result));

		byte[] decryted = util2.decrypt(result);
		if(decryted != null) {
			System.out.println("Decrypted string: " + new String(decryted));
		}

		try {
			System.out.println(util.md5("123456"));
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}
}
