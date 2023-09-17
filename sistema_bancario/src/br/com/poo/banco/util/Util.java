package br.com.poo.banco.util;

import java.text.DecimalFormat;

public class Util {	
	
	private Util() {
	}
	
	static DecimalFormat df = new DecimalFormat("#,###.##");
	
	public static String dfFormat(double valor) {
		DecimalFormat df = new DecimalFormat("#,###.##");
		return df.format(valor);
	}
}
