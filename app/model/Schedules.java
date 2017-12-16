package app.model;

public class Schedules {

	private String mon_start;
	private String mon_end;
	private String tue_start;
	private String tue_end;
	private String wed_start;
	private String wed_end;
	private String thu_start;
	private String thu_end;
	private String fri_start;
	private String fri_end;
	
	public Schedules(String mon_start, String mon_end, String tue_start, String tue_end,
			String wed_start, String wed_end, String thu_start, String thu_end, String fri_start, String fri_end) {
		super();
		this.mon_start = mon_start;
		this.mon_end = mon_end;
		this.tue_start = tue_start;
		this.tue_end = tue_end;
		this.wed_start = wed_start;
		this.wed_end = wed_end;
		this.thu_start = thu_start;
		this.thu_end = thu_end;
		this.fri_start = fri_start;
		this.fri_end = fri_end;
	
	
	}

	public Schedules() {
		super();
	}

	
/*
	public Integer getId_spec() {
		return id_spec;
	}

	public void setId_spec(Integer id_spec) {
		this.id_spec = id_spec;
	}
*/
	public String getMon_start() {
		return mon_start;
	}

	public void setMon_start(String mon_start) {
		this.mon_start = mon_start;
	}

	public String getMon_end() {
		return mon_end;
	}

	public void setMon_end(String mon_end) {
		this.mon_end = mon_end;
	}

	public String getTue_start() {
		return tue_start;
	}

	public void setTue_start(String tue_start) {
		this.tue_start = tue_start;
	}

	public String getTue_end() {
		return tue_end;
	}

	public void setTue_end(String tue_end) {
		this.tue_end = tue_end;
	}

	public String getWed_start() {
		return wed_start;
	}

	public void setWed_start(String wed_start) {
		this.wed_start = wed_start;
	}

	public String getWed_end() {
		return wed_end;
	}

	public void setWed_end(String wed_end) {
		this.wed_end = wed_end;
	}

	public String getThu_start() {
		return thu_start;
	}

	public void setThu_start(String thu_start) {
		this.thu_start = thu_start;
	}

	public String getThu_end() {
		return thu_end;
	}

	public void setThu_end(String thu_end) {
		this.thu_end = thu_end;
	}

	public String getFri_start() {
		return fri_start;
	}

	public void setFri_start(String fri_start) {
		this.fri_start = fri_start;
	}

	public String getFri_end() {
		return fri_end;
	}

	public void setFri_end(String fri_end) {
		this.fri_end = fri_end;
	}
	
	
	
	
	
}
