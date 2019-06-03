package springboot;

import java.io.File;

import springboot.model.Unit;

public class main {

	public static void main(String[] args) {
		
		File file = new File(System.getProperty("user.home"),"package-lock.json");
		if(file.exists()) {
			System.out.println(file.getAbsolutePath());
		}
	}
	
	

}
