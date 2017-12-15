package app.model;

public class Visits {

	private Integer id_visit;
	private Integer id_patient;
	private Integer id_spec;
	private String visit_date;
	private String visit_start;
	private String visit_end;
	
	
	public Visits(Integer id_visit, Integer id_patient, Integer id_spec, String visit_date, String visit_start, String visit_end) {
		super();
		this.id_visit = id_visit;
		this.id_patient = id_patient;
		this.id_spec = id_spec;
		this.visit_date = visit_date;
		this.visit_start = visit_start;
		this.visit_end = visit_end;
	}

	public Visits() {
		super();
	}

	public Integer getId_visit() {
		return id_visit;
	}
	public void setId_visit(Integer id_visit) {
		this.id_visit = id_visit;
	}
	public Integer getId_patient() {
		return id_patient;
	}
	public void setId_patient(Integer id_patient) {
		this.id_patient = id_patient;
	}
	public Integer getId_spec() {
		return id_spec;
	}
	public void setId_spec(Integer id_spec) {
		this.id_spec = id_spec;
	}
	public String getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}
	public String getVisit_start() {
		return visit_start;
	}
	public void setVisit_start(String visit_start) {
		this.visit_start = visit_start;
	}
	public String getVisit_end() {
		return visit_end;
	}
	public void setVisit_end(String visit_end) {
		this.visit_end = visit_end;
	}
	
}


