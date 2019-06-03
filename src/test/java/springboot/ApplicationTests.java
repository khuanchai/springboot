package springboot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.bean.Response;
import springboot.model.FileProcess;
import springboot.service.SftpFileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private SftpFileService sftpFileService;

	// controller
	@Test
	public void testReadFile() {
		Response response = new Response();
		try {
			List<String> fileNameList = new ArrayList<String>();
			fileNameList.add("C:\\dnc\\201905301.csv");
//			fileNameList.add("C:\\dnc\\201905302.csv");
//			fileNameList.add("C:\\dnc\\201905313.csv");

			if (fileNameList.size() > 0) {
				response = sftpFileService.readFileList(fileNameList);
			} else {
				response.setResponseStatus("F");
				response.setResponseMsg("file list not empty");
			}

		} catch (Exception e) {
			response.setResponseStatus("F");
			response.setResponseMsg(e.getMessage());
			e.printStackTrace();
		}

		System.out.println(response.toString());

	}

	
	

	
	
}
