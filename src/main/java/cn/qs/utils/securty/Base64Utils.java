package cn.qs.utils.securty;

import org.apache.xmlbeans.impl.util.Base64;

/**
 * Base64就是一种基于64个可打印字符来表示二进制数据的方法。
 * 
 * @author Administrator
 *
 */
public class Base64Utils {

	public static String encode(String str) {
		byte[] encode = Base64.encode(str.getBytes());
		return new String(encode);
	}

	public static String decode(String str) {
		byte[] decode = Base64.decode(str.getBytes());
		return new String(decode);
	}

	public static void main(String[] args) {
		System.out.println(encode("qlqlqlq"));
		System.out.println(decode(encode("qlqlqlq")));
	}
}
