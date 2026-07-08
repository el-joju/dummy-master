package com.endpoint.dummy;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class Puerto implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		Integer port = null;
		do {
			try {
				port = ThreadLocalRandom.current().nextInt(9004, 9300);
			} catch (Exception e) {
			}
		} while (!habilitado(port));
		factory.setPort(port);
	}

	public static boolean habilitado(Integer port) {
		ServerSocket ss = null;
		DatagramSocket ds = null;
		try {
			ss = new ServerSocket(port);
			ss.setReuseAddress(true);
			ds = new DatagramSocket(port);
			ds.setReuseAddress(true);
			return true;
		} catch (Exception e) {
		} finally {
			if (ds != null) {
				ds.close();
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return false;
	}

}
