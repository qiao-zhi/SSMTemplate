package cn.qs.utils.securty;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.xmlbeans.impl.util.Base64;

/**
 * 非对称加密RSA算法(公钥可以在网络上传输，私钥存在自己服务器。客户端用公钥加密，服务端用私钥解密)
 * 
 * @author Administrator
 *
 */
public class RSAUtils {

	private static final String PUBLIC_KEY = "";

	private static final String PRIVATE_KEY = "";

	/**
	 * 生成秘钥对
	 * 
	 * @throws Exception
	 */
	public static void generateKey() throws Exception {
		// 生成RSA密钥对
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(512);
		KeyPair kp = kpg.generateKeyPair();
		PublicKey pk = kp.getPublic();
		PrivateKey prk = kp.getPrivate();

		// 将公钥私钥用Base64编码为能读懂的英文字符串
		// 获取公钥采用的算法
		// String algorithm = pk.getAlgorithm();
		// 获取到code，可以调用Hex.encodeHexString(encoded)转为16进制字符串或者调用Base64进行编码
		byte[] pkEncoded = pk.getEncoded();
		byte[] pkEncodedBase64Encode = Base64.encode(pkEncoded);
		String pkEncodedBase64EncodeStr = new String(pkEncodedBase64Encode);
		System.out.println("publicKey\t" + pkEncodedBase64EncodeStr);

		byte[] prkEncoded = prk.getEncoded();
		byte[] prkEncodedBase64Encode = Base64.encode(prkEncoded);
		String prkEncodedBase64EncodeStr = new String(prkEncodedBase64Encode);
		System.out.println("privateKey\t" + prkEncodedBase64EncodeStr);
	}

	public static byte[] encrypt(byte[] bytes, String publicKey) {
		return null;
	}

	public static PublicKey getPub(String publicKey) throws Exception {
		byte[] bytes = publicKey.getBytes();
		byte[] decode = Base64.decode(bytes);
		return getPub(decode);
	}

	/**
	 * 读取公钥字节数组转换为对象
	 * 
	 * @throws Exception
	 */
	public static PublicKey getPub(byte[] publicKeyBytes) throws Exception {
		X509EncodedKeySpec x = new X509EncodedKeySpec(publicKeyBytes);
		KeyFactory fac = KeyFactory.getInstance("RSA");
		return fac.generatePublic(x);
	}

	/**
	 * 读取私钥字节数组转换为对象
	 * 
	 * @throws Exception
	 */
	public PrivateKey getPri(byte[] bt) throws Exception {
		PKCS8EncodedKeySpec x = new PKCS8EncodedKeySpec(bt);
		KeyFactory fac = KeyFactory.getInstance("RSA");
		return fac.generatePrivate(x);

	}
	/*
	 * public static void main(String[] args) throws Exception { // 公钥加密 Cipher
	 * cip = Cipher.getInstance("RSA"); cip.init(Cipher.ENCRYPT_MODE, pk);
	 * byte[] mw = cip.doFinal(str.getBytes()); String cryptedStr = new
	 * String(Base64.encode(mw)); System.out.println(cryptedStr);
	 * 
	 * // 私钥解密 Cipher cip1 = Cipher.getInstance("RSA");
	 * cip1.init(Cipher.DECRYPT_MODE, prk); byte[] bytes =
	 * cryptedStr.getBytes(); byte[] decode = Base64.decode(bytes); String
	 * string = new String(cip1.doFinal(decode)); System.out.println(string); }
	 */

}
