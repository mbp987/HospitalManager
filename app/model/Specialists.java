package app.model;

public class Specialists {

	private Integer id_spec;
	private String spec_name;
	private String spec_last;
	private String spec;
	
	public Specialists(Integer id_spec, String spec_name, String spec_last, String spec) {
		super();
		this.id_spec = id_spec;
		this.spec_name = spec_name;
		this.spec_last = spec_last;
		this.spec = spec;
	}

	public Integer getId_spec() {
		return id_spec;
	}
	public void setId_spec(Integer id_spec) {
		this.id_spec = id_spec;
	}
	public String getSpec_name() {
		return spec_name;
	}
	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}
	public String getSpec_last() {
		return spec_last;
	}
	public void setSpec_last(String spec_last) {
		this.spec_last = spec_last;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	
	
	
	
}

