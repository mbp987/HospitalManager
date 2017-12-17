package app.model;

public class Visits {

	private Integer id_visit;
	private Integer id_patient;
	private Integer id_spec;
	private String visit_date;
	private Integer visit_term;
	
	
	public Visits(Integer id_visit, Integer id_patient, Integer id_spec, String visit_date, Integer visit_term) {
		super();
		this.id_visit = id_visit;
		this.id_patient = id_patient;
		this.id_spec = id_spec;
		this.visit_date = visit_date;
		this.visit_term = visit_term;

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
	public Integer getVisit_start() {
		return visit_term;
	}
	public void setVisit_start(Integer visit_term) {
		this.visit_term = visit_term;
	}
}


