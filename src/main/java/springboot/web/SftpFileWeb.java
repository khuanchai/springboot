package springboot.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/sftpfile")
public class SftpFileWeb {

	@PostMapping("/upload")
	public void sftpFileUpload() {
		try {
//			dsadsadadad
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
