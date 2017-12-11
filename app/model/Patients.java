package app.model;

public class Patients {

	private Integer id_patient;
	private String pat_name;
	private String pat_last;
	
	public Patients(Integer id_patient, String pat_name, String pat_last) {
		super();
		this.id_patient = id_patient;
		this.pat_name = pat_name;
		this.pat_last = pat_last;
	}

	public Integer getId_patient() {
		return id_patient;
	}
	public void setId_patient(Integer id_patient) {
		this.id_patient = id_patient;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public String getPat_last() {
		return pat_last;
	}
	public void setPat_last(String pat_last) {
		this.pat_last = pat_last;
	}
}
