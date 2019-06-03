package springboot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.model.FileContent;
import springboot.model.FileProcess;
import springboot.util.Connect;

@Repository
public class SftpFileDaoImpl implements SftpFileDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void saveTempFile(List<FileContent> fileContentList) {
		try {

			Connection conn = Connect.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO tb_w20_temp (name,position,office,age,start_date,salary,process_id)");
			sql.append(" values(?,?,?,?,?,?,?) ");
			PreparedStatement ps = conn.prepareStatement(sql.toString());

			final int batchSize = 10;
			int count = 0;

			for (FileContent item : fileContentList) {

				ps.setObject(1, item.getName());
				ps.setObject(2, item.getPosition());
				ps.setObject(3, item.getOffice());
				ps.setObject(4, item.getAge());
				ps.setObject(5, item.getStartDate());
				ps.setObject(6, item.getSalary());
				ps.setObject(7, item.getProcessId());

				ps.addBatch();

				if (++count % batchSize == 0) {
					ps.executeBatch();
				}
			}

			ps.executeBatch(); // insert remaining records

			ps.close();
			conn.close();
//
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void printStatus(int[] rows) {
		for (int item : rows) {
			System.out.println(item);
		}
	}

	@Override
	public FileProcess saveFileProcess(FileProcess fileProcess) {
		try {
			Session session = entityManager.unwrap(Session.class);
			session.saveOrUpdate(fileProcess);
			fileProcess.setProcessMsg("Save Process File Success");
		} catch (Exception e) {
			e.printStackTrace();
			fileProcess.setId(null);
			fileProcess.setProcessStatus("F");
			fileProcess.setProcessMsg("Save Process File Fail");
		}
		return fileProcess;
	}

}
