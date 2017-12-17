package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;

import app.database.DBConnect;
import app.model.Patients;
import app.model.Schedules;
import app.model.Specialists;
import app.model.Visits;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



public class ManagerController {

	DBConnect db;

	public ObservableList<Patients> patients;
	public ObservableList<Specialists> specialists;
	public ObservableList<Visits> visits;
	public ObservableList<Schedules> schedules;

	//used for comboboxes
	ObservableList<String> spec1 = FXCollections.observableArrayList();    
	ObservableList<String> spec1last = FXCollections.observableArrayList();   
	ObservableList<String> patient1last = FXCollections.observableArrayList();   
	ObservableList<String> hours = FXCollections.observableArrayList("08:00-09:00", "09:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00"); 
	
	
	ObservableList<String> cardiologists = FXCollections.observableArrayList("Cember", "Jasny");
	ObservableList<String> dermatologists = FXCollections.observableArrayList("Adamczyk", "Etan");
	ObservableList<String> gynaecologists = FXCollections.observableArrayList("Holm");
	ObservableList<String> neurologists = FXCollections.observableArrayList("Dior");
	ObservableList<String> oculists = FXCollections.observableArrayList("Flis");
	ObservableList<String> orthopaedists = FXCollections.observableArrayList("Grzegorczyk");
	ObservableList<String> paediatricians = FXCollections.observableArrayList("Baranowska", "Imo");
	
	//window elements for Patients
	@FXML
	TableView<Patients> patients_table_view;
	@FXML
	TableColumn<Patients, Integer> id_patient;
	@FXML
	TableColumn<Patients, String> pat_name;
	@FXML
	TableColumn<Patients, String> pat_last;
	
	//window elements for Specialists
	@FXML
	TableView<Specialists> specialists_table_view;
	@FXML
	TableColumn<Specialists, Integer> id_spec;
	@FXML
	TableColumn<Specialists, String> spec_name;
	@FXML
	TableColumn<Specialists, String> spec_last;
	@FXML
	TableColumn<Specialists, String> spec;

	//window elements for Visits
    @FXML
    private AnchorPane visits_view;
    @FXML
    private ComboBox<String> spec_combo;
	@FXML
	private ComboBox<String> spec_last_combo;
    @FXML
    private Button show_visits;
    @FXML
    private DatePicker visit_date_picker;
    @FXML
    private Button btn_selected_visits;
    @FXML
    private TableView<Visits> visits_table_view;
    @FXML
    private TableColumn<Visits, Integer> id_visit;
    @FXML
    private TableColumn<Visits, Integer> v_id_patient;
    @FXML
    private TableColumn<Visits, Integer> v_id_spec;
    @FXML
    private TableColumn<Visits, String> visit_date;
    @FXML
    private TableColumn<Visits, Integer> visit_term;
    
    
    //window elements for New Visit
    @FXML
    private AnchorPane new_visit_view;
    @FXML
    private ComboBox<String> nv_spec_combo;
    @FXML
    private ComboBox<String> nv_spec_last_combo;
    @FXML
    private DatePicker nv_visit_date_picker;
    @FXML
    private ComboBox<String> nv_hour_combo;
    @FXML
    private ComboBox<String> nv_patient_last_combo;
    @FXML
    private Button nv_set_new_visit;
    @FXML
    private Button nv_btn_show_available;
    @FXML
    private TableView<Schedules> nv_visits_table_view;
    @FXML
    private TableColumn<Schedules, String> nv_monday;
    @FXML
    private TableColumn<Schedules, String> nv_tuesday;
    @FXML
    private TableColumn<Schedules, String> nv_wednesday;
    @FXML
    private TableColumn<Schedules, String> nv_thursday;
    @FXML
    private TableColumn<Schedules, String> nv_friday;
    
    
    //general window elements for all views
	@FXML
    private Button btn_patients;
	@FXML
    private Button btn_specialists;
	@FXML
    private Button btn_visits;
	@FXML
    private Button btn_new_visit;
	
	@FXML
	void showPatients (MouseEvent event) throws IOException, SQLException{
		
		patients = FXCollections.observableArrayList();
		patients_table_view.setVisible(true);
		specialists_table_view.setVisible(false);
		visits_view.setVisible(false);
		new_visit_view.setVisible(false);
		
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM patients;");
		
		while (rs.next()) {
			patients.add(new Patients(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		
		patients_table_view.setItems(null);
		patients_table_view.setItems(patients);
		System.out.println(patients);
		System.out.println(patients_table_view);
	}
	
	@FXML
	void showSpecialists (MouseEvent event) throws IOException, SQLException{
		
		specialists = FXCollections.observableArrayList();
		patients_table_view.setVisible(false);
		specialists_table_view.setVisible(true);
		visits_view.setVisible(false);
		new_visit_view.setVisible(false);
		
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM specialists;");

		while (rs.next()) {
			specialists.add(new Specialists(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		
		specialists_table_view.setItems(null);
		specialists_table_view.setItems(specialists);
		System.out.println(specialists);
		System.out.println(specialists_table_view);
	}
	
	
	@FXML
    void showVisits(MouseEvent event) {
		patients_table_view.setVisible(false);
		specialists_table_view.setVisible(false);
		visits_view.setVisible(true);
		new_visit_view.setVisible(false);

    }
	
	@FXML
    void showSelectedVists(MouseEvent event) throws IOException, SQLException{
		String spec = spec_combo.getValue();
		String spec_last = spec_last_combo.getValue();
		System.out.println(spec);
		System.out.println(spec_last);
		LocalDate visit_date1 = visit_date_picker.getValue();
		System.out.println(visit_date1);
		
		visits = FXCollections.observableArrayList();
		
		

		ps = conn.prepareStatement("SELECT id_visit, id_patient, id_spec, visit_date, visit_term FROM visits LEFT JOIN specialists USING (id_spec) WHERE spec_last= ? AND visit_date= ? ;");
		ps.setString(1, spec_last);
		ps.setString(2, visit_date1.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Visits sc = new Visits(rs.getInt(1), 
										rs.getInt(2), 
										rs.getInt(3), 
										rs.getString(4), 
										rs.getInt(5));
		
		
			
		//ResultSet rs = stmt.executeQuery("SELECT id_visit, id_patient, id_spec, visit_date, visit_start, visit_end FROM visits LEFT JOIN specialists USING (id_spec) WHERE spec_last='"+spec_last+"' AND visit_date='"+visit_date1+"';");
	
		
		id_visit.setCellValueFactory(new PropertyValueFactory<Visits, Integer>("id_visit"));
		v_id_patient.setCellValueFactory(new PropertyValueFactory<Visits, Integer>("id_patient"));
		v_id_spec.setCellValueFactory(new PropertyValueFactory<Visits, Integer>("id_spec"));
		visit_date.setCellValueFactory(new PropertyValueFactory<Visits, String>("visit_date"));
		visit_term.setCellValueFactory(new PropertyValueFactory<Visits, Integer>("visit_term"));
	
		
		}
/*
		//rs.close();
		//stmt.close();
		//conn.close();
		
		
*/		
		
	}
	
	
	
	@FXML
	void showNewVisit(MouseEvent event) throws IOException, SQLException{
		patients_table_view.setVisible(false);
		specialists_table_view.setVisible(false);
		visits_view.setVisible(false);
		new_visit_view.setVisible(true);
		
		
	}

	
	@FXML
    void showSelectedSchedule(MouseEvent event) throws IOException, SQLException{

	String spec = nv_spec_combo.getValue();
	String spec_last = nv_spec_last_combo.getValue();
	System.out.println(spec);
	System.out.println(spec_last);
	schedules = FXCollections.observableArrayList();
	ps = conn.prepareStatement("SELECT mon, tue, wed, thu, fri FROM schedules LEFT JOIN specialists USING (id_spec) WHERE spec_last= ? ");
	ps.setString(1, spec_last);
	ResultSet rs = ps.executeQuery();
		while(rs.next()){
	Schedules sc = new Schedules(rs.getString(1),
		rs.getString(2),
		rs.getString(3),
		rs.getString(4),
		rs.getString(5)
		);
	schedules.add(sc);
	}
	nv_monday.setCellValueFactory(new PropertyValueFactory<Schedules, String>("mon"));
	nv_tuesday.setCellValueFactory(new PropertyValueFactory<Schedules, String>("tue"));
	nv_wednesday.setCellValueFactory(new PropertyValueFactory<Schedules, String>("wed"));
	nv_thursday.setCellValueFactory(new PropertyValueFactory<Schedules, String>("thu"));
	nv_friday.setCellValueFactory(new PropertyValueFactory<Schedules, String>("fri"));
	nv_visits_table_view.setItems(schedules);
	// nvrs.close();
	// conn.close();
	}
	
	
	
	
	PreparedStatement ps1, ps2, ps3;
	int id_spec_SQL, id_p_SQL;
	
	HashMap<String, String> hours_to_num = new HashMap<>();
	
	
	@FXML
    void setNewVisit(MouseEvent event) throws IOException, SQLException{
		//"08:00-09:00", "09:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00"
		hours_to_num.put("08:00-09:00","1");
		hours_to_num.put("09:00-10:00","2");
		hours_to_num.put("10:00-11:00","3");
		hours_to_num.put("11:00-12:00","4");
		hours_to_num.put("12:00-13:00","5");
		hours_to_num.put("13:00-14:00","6");
		hours_to_num.put("14:00-15:00","7");
		hours_to_num.put("15:00-16:00","8");
		
		String spec = nv_spec_combo.getValue();
		String spec_last = nv_spec_last_combo.getValue();
		String patient_last = nv_patient_last_combo.getValue();
		LocalDate nv_visit_date = nv_visit_date_picker.getValue();
		String hour = nv_hour_combo.getValue();
		System.out.println(spec);
		System.out.println(spec_last);
		System.out.println(patient_last);
		System.out.println(nv_visit_date);
		System.out.println(hour);
		
		
		Connection conn = db.getConnection();
		//Statement nvstmt1 = conn.createStatement();
		ps1 = conn.prepareStatement("select id_patient from patients where pat_last = ?");
		ps1.setString(1, patient_last);
		ResultSet id_s = ps1.executeQuery();
		if(id_s.next()) {
		id_spec_SQL = id_s.getInt("id_patient");
		System.out.println(id_spec_SQL);
		}
		ps2 = conn.prepareStatement("select id_spec from specialists where spec_last = ?");
		ps2.setString(1, spec_last);
		ResultSet id_p = ps2.executeQuery();
		if(id_p.next()) {
		id_p_SQL = id_p.getInt("id_spec");
		System.out.println(id_p_SQL);
		}

		ps3 = conn.prepareStatement("INSERT into visits(id_patient, id_spec, visit_date, visit_term) VALUES(?,?,?,?)");// + patient_last + ", " + spec_last + ", " + nv_visit_date + ", " + hour + "; ");
		ps3.setString(1, String.valueOf(id_p_SQL));
		ps3.setString(2, String.valueOf(id_spec_SQL));
		ps3.setString(3, String.valueOf(nv_visit_date));
		ps3.setString(4, hours_to_num.get(hour));
		ps3.executeUpdate();		
	}
	
	@FXML
    void nvChooseLast(ActionEvent event) {
		
		if (nv_spec_combo.getValue().equals("cardiologist")){
			nvRefresh();
		}
		else if(nv_spec_combo.getValue().equals("dermatologist")){
			nvRefresh();
		}
		else if(nv_spec_combo.getValue().equals("gynaecologist")){
			nvRefresh();
		}
		else if(nv_spec_combo.getValue().equals("neurologist")){
			nvRefresh();
		}
		else if(nv_spec_combo.getValue().equals("oculist")){
			nvRefresh();
		}
		else if(nv_spec_combo.getValue().equals("orthopaedist")){
			nvRefresh();
		}
		else if(nv_spec_combo.getValue().equals("paediatrician")){
			nvRefresh();
		}
		else {
			nv_spec_last_combo.setItems(spec1last);
		}	
    }
	
	public void nvRefresh() {
		if (nv_spec_combo.getValue().equals("cardiologist")){
			nv_spec_last_combo.setValue("Cember");
			nv_spec_last_combo.setItems(cardiologists);
		}
		else if (nv_spec_combo.getValue().equals("dermatologist")){
			nv_spec_last_combo.setValue("Adamczyk");
			nv_spec_last_combo.setItems(dermatologists);
		}	
		else if (nv_spec_combo.getValue().equals("gynaecologist")){
			nv_spec_last_combo.setValue("Holm");
			nv_spec_last_combo.setItems(gynaecologists);
		}	
		else if (nv_spec_combo.getValue().equals("neurologist")){
			nv_spec_last_combo.setValue("Dior");
			nv_spec_last_combo.setItems(neurologists);
		}	
		else if (nv_spec_combo.getValue().equals("oculist")){
			nv_spec_last_combo.setValue("Flis");
			nv_spec_last_combo.setItems(oculists);
		}	
		else if (nv_spec_combo.getValue().equals("orthopaedist")){
			nv_spec_last_combo.setValue("Grzegorczyk");
			nv_spec_last_combo.setItems(orthopaedists);
		}	
		else if (nv_spec_combo.getValue().equals("paediatrician")){
			nv_spec_last_combo.setValue("Baranowska");
			nv_spec_last_combo.setItems(paediatricians);
		}	
		else {
			nv_spec_last_combo.setItems(spec1last);
		}
	
	}

	@FXML
    void chooseLast(ActionEvent event) {
		
		if (spec_combo.getValue().equals("cardiologist")){
			refresh();
		}
		else if(spec_combo.getValue().equals("dermatologist")){
			refresh();
		}
		else if(spec_combo.getValue().equals("gynaecologist")){
			refresh();
		}
		else if(spec_combo.getValue().equals("neurologist")){
			refresh();
		}
		else if(spec_combo.getValue().equals("oculist")){
			refresh();
		}
		else if(spec_combo.getValue().equals("orthopaedist")){
			refresh();
		}
		else if(spec_combo.getValue().equals("paediatrician")){
			refresh();
		}
		else {
			spec_last_combo.setItems(spec1last);
		}	
    }
	
	public void refresh() {
		if (spec_combo.getValue().equals("cardiologist")){
			spec_last_combo.setValue("Cember");
			spec_last_combo.setItems(cardiologists);
		}
		else if (spec_combo.getValue().equals("dermatologist")){
			spec_last_combo.setValue("Adamczyk");
			spec_last_combo.setItems(dermatologists);
		}	
		else if (spec_combo.getValue().equals("gynaecologist")){
			spec_last_combo.setValue("Holm");
			spec_last_combo.setItems(gynaecologists);
		}	
		else if (spec_combo.getValue().equals("neurologist")){
			spec_last_combo.setValue("Dior");
			spec_last_combo.setItems(neurologists);
		}	
		else if (spec_combo.getValue().equals("oculist")){
			spec_last_combo.setValue("Flis");
			spec_last_combo.setItems(oculists);
		}	
		else if (spec_combo.getValue().equals("orthopaedist")){
			spec_last_combo.setValue("Grzegorczyk");
			spec_last_combo.setItems(orthopaedists);
		}	
		else if (spec_combo.getValue().equals("paediatrician")){
			spec_last_combo.setValue("Baranowska");
			spec_last_combo.setItems(paediatricians);
		}	
		else {
			spec_last_combo.setItems(spec1last);
		}
	
	}
	
	PreparedStatement ps;

	Connection conn;
	public void initialize() throws SQLException {
		db = new DBConnect();
		conn = db.getConnection();
		id_patient.setCellValueFactory(new PropertyValueFactory<Patients, Integer>("id_patient"));
		pat_name.setCellValueFactory(new PropertyValueFactory<Patients, String>("pat_name"));
		pat_last.setCellValueFactory(new PropertyValueFactory<Patients, String>("pat_last"));
		
		id_spec.setCellValueFactory(new PropertyValueFactory<Specialists, Integer>("id_spec"));
		spec_name.setCellValueFactory(new PropertyValueFactory<Specialists, String>("spec_name"));
		spec_last.setCellValueFactory(new PropertyValueFactory<Specialists, String>("spec_last"));
		spec.setCellValueFactory(new PropertyValueFactory<Specialists, String>("spec"));
		
		
		
		//setting values for spec1 and spec1last used in comboboxes
		ps = conn.prepareStatement("SELECT DISTINCT spec FROM specialists");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			spec1.add(rs.getString("spec"));
			//spec1last.add(rs.getString("spec_last"));
		}
		spec1 = spec1.sorted();
		ps = conn.prepareStatement("SELECT spec_last FROM specialists");
		ResultSet rs1 = ps.executeQuery();
		
		while(rs1.next()){
			//spec1.add(rs.getString("spec"));
			spec1last.add(rs1.getString("spec_last"));
		}
		spec1last = spec1last.sorted();
		
		spec_combo.setItems(spec1);
		spec_last_combo.setItems(spec1last);
		
		nv_spec_combo.setItems(spec1);
		nv_spec_last_combo.setItems(spec1last);
		
		//setting values for  and patient1last used in combobox
		ps2 = conn.prepareStatement("SELECT pat_last FROM patients");
		ResultSet rs2 = ps2.executeQuery();
		
		while(rs2.next()){
			patient1last.add(rs2.getString("pat_last"));
		
		}
		
		nv_patient_last_combo.setItems(patient1last);
		
		//stiff values for hours combobox
		nv_hour_combo.setItems(hours);
	}
	
}
