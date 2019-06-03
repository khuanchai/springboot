package springboot.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_file_process")
public class FileProcess {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "filename")
	private String fileName;

	@Column(name = "row_total")
	private Integer rowTotal;

	@Column(name = "row_success")
	private Integer rowSuccess;

	@Column(name = "row_fail")
	private Integer rowFail;

	@Column(name = "process_by")
	private String processBy;

	@Column(name = "process_status")
	private String processStatus;

	@Column(name = "process_msg")
	private String processMsg;

	@Column(name = "process_date")
	private Timestamp processDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getRowTotal() {
		return rowTotal;
	}

	public void setRowTotal(Integer rowTotal) {
		this.rowTotal = rowTotal;
	}

	public Integer getRowSuccess() {
		return rowSuccess;
	}

	public void setRowSuccess(Integer rowSuccess) {
		this.rowSuccess = rowSuccess;
	}

	public Integer getRowFail() {
		return rowFail;
	}

	public void setRowFail(Integer rowFail) {
		this.rowFail = rowFail;
	}

	public String getProcessBy() {
		return processBy;
	}

	public void setProcessBy(String processBy) {
		this.processBy = processBy;
	}

	public Timestamp getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Timestamp processDate) {
		this.processDate = processDate;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getProcessMsg() {
		return processMsg;
	}

	public void setProcessMsg(String processMsg) {
		this.processMsg = processMsg;
	}

	@Override
	public String toString() {
		return "FileProcess [id=" + id + ", fileName=" + fileName + ", rowTotal=" + rowTotal + ", rowSuccess="
				+ rowSuccess + ", rowFail=" + rowFail + ", processBy=" + processBy + ", processStatus=" + processStatus
				+ ", processMsg=" + processMsg + ", processDate=" + processDate + "]";
	}

}
