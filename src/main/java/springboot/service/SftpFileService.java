package springboot.service;

import java.io.BufferedReader;
import java.util.List;

import springboot.bean.Response;
import springboot.model.FileContent;
import springboot.model.FileProcess;

public interface SftpFileService {

	public Response readFileList(List<String> fileNameList);
	public List<FileContent> loadDataFile(FileProcess fileProcess, BufferedReader br);
	public FileProcess validateHeaderFile(FileProcess fileProcess, String[] data);
	public FileContent validateDetailFile(FileProcess fileProcess, String[] data);
	
}
