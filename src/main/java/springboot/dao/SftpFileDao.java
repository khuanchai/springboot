package springboot.dao;

import java.util.List;

import springboot.model.FileContent;
import springboot.model.FileProcess;

public interface SftpFileDao {
	public void saveTempFile(List<FileContent> fileContentList);
	public FileProcess saveFileProcess(FileProcess fileProcess);
}
