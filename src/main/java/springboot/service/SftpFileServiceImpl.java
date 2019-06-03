package springboot.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.Response;
import springboot.dao.SftpFileDao;
import springboot.model.FileContent;
import springboot.model.FileProcess;

@Transactional
@Service
public class SftpFileServiceImpl implements SftpFileService {

	@Autowired
	private SftpFileDao sftpFileDao;

	public Response readFileList(List<String> fileNameList) {
		Response response = new Response();
		String tempDate = null;
		String dateFile = null;
		boolean isSuccess = true;
		String msgError = null;
		int fileCount = 0;

		for (String fileName : fileNameList) {
			File file;
			InputStream inputStream;
			InputStreamReader is;
			BufferedReader br;
			FileProcess fileProcess;

			try {

				file = new File(fileName);
				inputStream = new FileInputStream(file);
				is = new InputStreamReader(inputStream);
				br = new BufferedReader(is);
				fileProcess = new FileProcess();

				if (file.canRead() && br != null) {

//					System.out.println(file.getName());  // 201905301.csv
					String y = file.getName().substring(0, 4);
					String m = file.getName().substring(4, 6);
					String d = file.getName().substring(6, 8);

					dateFile = y + m + d;
					fileCount++;

					if (tempDate != null && !dateFile.equalsIgnoreCase(tempDate)) {
						System.out.println("insert master " + tempDate);

					}

			
					fileProcess.setFileName(file.getName());
					fileProcess.setProcessStatus("P");
					List<FileContent> fileContentList = loadDataFile(fileProcess, br);
					if (fileProcess.getProcessStatus().equalsIgnoreCase("P")) {
						System.out.println("insert temp :" + dateFile);
						this.sftpFileDao.saveTempFile(fileContentList);
					} else {
						msgError = fileProcess.getProcessMsg();
						isSuccess = false;
						break;
					}

					if (fileCount == fileNameList.size()) {
						System.out.println("insert master " + dateFile);
					}

					tempDate = dateFile;

				} else {
					msgError = "read file error:" + file.getName();
					isSuccess = false;
					break;
				}

			} catch (Exception e) {
				msgError = e.getMessage();
				isSuccess = false;
				e.printStackTrace();
				break;
			}
		}

		// exit loop
		if (isSuccess) {
			response.setResponseStatus("Success");
			response.setResponseMsg("Success");
			response.setResponseCode("200");
		} else {
			response.setResponseStatus("Fail");
			response.setResponseMsg(msgError);
			response.setResponseCode("400");
		}
		return response;
	}

	public List<FileContent> loadDataFile(FileProcess fileProcess, BufferedReader br) {
		List<FileContent> fileContentList = new ArrayList<FileContent>();
		try {
			String line;
			int row = 1;

			while ((line = br.readLine()) != null) {
				String[] data = line.trim().split(",");
				if (fileProcess.getProcessStatus().equalsIgnoreCase("P") && data.length > 0) {

					if (row == 1) {
						fileProcess = validateHeaderFile(fileProcess, data);
						fileProcess = this.sftpFileDao.saveFileProcess(fileProcess);
//						System.out.println(fileProcess.toString());
					} else {
						FileContent fileContent = validateDetailFile(fileProcess, data);
						fileContentList.add(fileContent);

						System.out.println(fileContent.toString());
					}
				}
				row++;
			}

		} catch (Exception e) {
			fileProcess.setProcessStatus("F");
			fileProcess.setProcessMsg(e.getMessage());
			e.printStackTrace();
		}

		if (fileProcess.getProcessStatus().equalsIgnoreCase("F")) {
			fileContentList = null;
		}

		return fileContentList;
	}

	public FileProcess validateHeaderFile(FileProcess fileProcess, String[] data) {
		try {
			fileProcess.setId(null);
			fileProcess.setProcessDate(null);
			fileProcess.setRowTotal(0);
			fileProcess.setRowFail(0);
			fileProcess.setRowSuccess(0);
			fileProcess.setProcessStatus("P");
			fileProcess.setProcessBy("System");
//			System.out.println(data.length);
			if (data.length == 6) {
				fileProcess.setRowTotal(58);
			} else {
				fileProcess.setProcessStatus("F");
				fileProcess.setProcessMsg("validate header fail");
			}
		} catch (Exception e) {
			fileProcess.setProcessStatus("F");
			fileProcess.setProcessMsg(e.getMessage());
			e.printStackTrace();
		}

		return fileProcess;
	}

	public FileContent validateDetailFile(FileProcess fileProcess, String[] data) {
		FileContent fileContent = new FileContent();
		try {
//			System.out.println(data.length);
			if (data.length == 6) {
				
				fileContent.setName(data[0]);
				fileContent.setPosition(data[1]);
				fileContent.setOffice(data[2]);
				fileContent.setAge(Integer.parseInt(data[3]));
				fileContent.setStartDate(data[4]);
				fileContent.setSalary(data[5]);
				fileContent.setProcessId(fileProcess.getId());
			} else {
				System.out.println(data[0]);
				fileProcess.setProcessStatus("F");
				fileProcess.setProcessMsg("validate detail fail");
			}
		} catch (Exception e) {
			fileProcess.setProcessStatus("F");
			fileProcess.setProcessMsg(e.getMessage());
			e.printStackTrace();
		}
		return fileContent;
	}

}
