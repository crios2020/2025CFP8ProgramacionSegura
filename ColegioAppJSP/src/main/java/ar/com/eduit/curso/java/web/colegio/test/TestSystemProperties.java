package ar.com.eduit.curso.java.web.colegio.test;

import ar.com.eduit.curso.java.web.colegio.utils.SystemProperties;

public class TestSystemProperties {
	public static void main(String[] args) {
		SystemProperties sp=new SystemProperties();
		System.out.println(sp.getFecha());
		System.out.println(sp.getJava());
		System.out.println(sp.getSystem());
		System.out.println(sp.getUbicacion());
		System.out.println(sp.getUser());
	}
}
