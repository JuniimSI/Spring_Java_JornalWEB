package br.ufc.criptofy;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
	
	public String criptografa(String senha){
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			try {
				byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
				StringBuilder sb = new StringBuilder();	
				for (byte b : messageDigest) {
					  sb.append(String.format("%02X", 0xFF & b));
				}
				return sb.substring(0);

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
