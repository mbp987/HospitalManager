package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.mysql.jdbc.ResultSetMetaData;

import app.database.DBConnect;
import app.model.Patients;
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

	//combo list to be rebuild
	ObservableList<String> spec1 = FXCollections.observableArrayList("cardiologist", "dermatologist", "gynaecologist", "neurologist", "oculist", "orthopaedist", "paediatrician");
	ObservableList<String> spec1last = FXCollections.observableArrayList("Adamczyk", "Barańska", "Cember", "Dior", "Etan", "Flis", "Grzegorczyk", "Holm", "Imo", "Jasińska");
	
	ObservableList<String> cardiologists = FXCollections.observableArrayList("Cember", "Jasińska");
	ObservableList<String> dermatologists = FXCollections.observableArrayList("Adamczyk", "Etan");
	ObservableList<String> gynaecologists = FXCollections.observableArrayList("Holm");
	ObservableList<String> neurologists = FXCollections.observableArrayList("Dior");
	ObservableList<String> oculists = FXCollections.observableArrayList("Flis");
	ObservableList<String> orthopaedists = FXCollections.observableArrayList("Grzegorczyk");
	ObservableList<String> paediatricians = FXCollections.observableArrayList("Barańska", "Imo");
	
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
    AnchorPane visits_view;
    @FXML
    ComboBox<String> spec_combo;
	@FXML
    ComboBox<String> spec_last_combo;
    @FXML
    Button show_visits;
    @FXML
    DatePicker visit_date_picker;
    @FXML
    Button btn_selected_visits;
    @FXML
    TableView<Visits> visits_table_view;
    @FXML
    TableColumn<Visits, Integer> id_visit;
    @FXML
    TableColumn<Visits, Integer> v_id_patient;
    @FXML
    TableColumn<Visits, Integer> v_id_spec;
    @FXML
    TableColumn<Visits, String> visit_date;
    @FXML
    TableColumn<Visits, String> visit_start;
    @FXML
    TableColumn<Visits, String> visit_end;
	
	
	
	@FXML
    private Button btn_patients;
	@FXML
    private Button btn_specialists;
	@FXML
    private Button btn_visits;

	
	@FXML
	void showPatients (MouseEvent event) throws IOException, SQLException{
		
		patients = FXCollections.observableArrayList();
		patients_table_view.setVisible(true);
		specialists_table_view.setVisible(false);
		visits_view.setVisible(false);
		
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM patients;");
		
		while (rs.next()) {
			patients.add(new Patients(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		System.out.println(patients);
		
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
		
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM specialists;");

		while (rs.next()) {
			specialists.add(new Specialists(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		System.out.println(patients);
		
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
		visits_table_view.setVisible(true);

    }
	
	@FXML
    void showSelectedVists(MouseEvent event) throws IOException, SQLException{
		String spec = spec_combo.getValue();
		String spec_last = spec_last_combo.getValue();
		System.out.println(spec);
		System.out.println(spec_last);
		LocalDate visit_date1 = visit_date_picker.getValue();
		System.out.println(visit_date1);
		
		
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id_visit, id_patient, id_spec, visit_date, visit_start, visit_end FROM visits LEFT JOIN specialists USING (id_spec) WHERE spec_last='"+spec_last+"' AND visit_date='"+visit_date1+"';");
		//rsmd - used only as reference, to be removed after solving problem
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		
		System.out.println(rs);
		
		System.out.println(rsmd);
		
		//PROBLEM PROBLEM PROBLEM PROBLEM PROBLEM PROBLEM PROBLEM PROBLEM line 191
		
		while (rs.next()) {
			visits.add(new Visits(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}
	
		System.out.println(visits);
			
		visits_table_view.setItems(null);
		visits_table_view.setItems(visits);
		System.out.println(visits);
		System.out.println(visits_table_view);
		
		
		rs.close();
		stmt.close();
		conn.close();
		
		
		
		
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
			spec_last_combo.setValue("Barańska");
			spec_last_combo.setItems(paediatricians);
		}	
		else {
			spec_last_combo.setItems(spec1last);
		}
	
	}
	
	public void initialize() {
		db = new DBConnect();
		id_patient.setCellValueFactory(new PropertyValueFactory<Patients, Integer>("id_patient"));
		pat_name.setCellValueFactory(new PropertyValueFactory<Patients, String>("pat_name"));
		pat_last.setCellValueFactory(new PropertyValueFactory<Patients, String>("pat_last"));
		
		id_spec.setCellValueFactory(new PropertyValueFactory<Specialists, Integer>("id_spec"));
		spec_name.setCellValueFactory(new PropertyValueFactory<Specialists, String>("spec_name"));
		spec_last.setCellValueFactory(new PropertyValueFactory<Specialists, String>("spec_last"));
		spec.setCellValueFactory(new PropertyValueFactory<Specialists, String>("spec"));
		
		id_visit.setCellValueFactory(new PropertyValueFactory<Visits, Integer>("id_visit"));
		v_id_patient.setCellValueFactory(new PropertyValueFactory<Visits, Integer>("id_patient"));
		v_id_spec.setCellValueFactory(new PropertyValueFactory<Visits, Integer>("id_spec"));
		visit_date.setCellValueFactory(new PropertyValueFactory<Visits, String>("visit_date"));
		visit_start.setCellValueFactory(new PropertyValueFactory<Visits, String>("visit_start"));
		visit_end.setCellValueFactory(new PropertyValueFactory<Visits, String>("visit_end"));
		
		spec_combo.setItems(spec1);
		spec_last_combo.setItems(spec1last);
	}
	
}
