package springboot.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Connect {

	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(Connect.driver);
			conn = DriverManager.getConnection(Connect.url, Connect.username, Connect.password);
			System.out.println("Connect Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public String getDriver() {

		return driver;
	}

	@Value("${jdbc.driver}")
	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	@Value("${jdbc.url}")
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	@Value("${jdbc.username}")
	public void setUsername(String username) {
		Connect.username = username;
	}

	public String getPassword() {
		return password;
	}

	@Value("${jdbc.password}")
	public void setPassword(String password) {
		Connect.password = password;
	}

}
