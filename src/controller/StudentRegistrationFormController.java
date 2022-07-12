/**
 * @author : Isuru Lakmal G K A
 * Date    : $(DATE)
 **/

package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import view.TM.StudentTM;

import java.util.ArrayList;

public class StudentRegistrationFormController {
    public JFXTextField txtid;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtnic;

    public TableView<StudentTM> tblStudent;
    public TableColumn clmid;
    public TableColumn clmname;
    public TableColumn clmemail;
    public TableColumn clmcontact;
    public TableColumn clmaddress;
    public TableColumn clmnic;

    public void studentSaveOnAction(ActionEvent actionEvent) {
        Student s1 = new Student(
                txtid.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText(),txtnic.getText()
        );
        if (saveStudent(s1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Success").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }

    }
    boolean saveStudent(Student s){
        return new StudentRegistrationFormController().saveStudent(s);
    }

    public void studentDeleteOnAction(ActionEvent actionEvent) {
    }

    public void studentUpdateOnAction(ActionEvent actionEvent) {
    }

    public void searchStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnclearOnAction(ActionEvent actionEvent) {
    }
    public void initialize(){
        clmid.setCellValueFactory(new PropertyValueFactory<>("Id"));
        clmname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        clmemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        clmcontact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        clmaddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        clmnic.setCellValueFactory(new PropertyValueFactory<>("NIC"));

        setStudentstoTable(new StudentRegistrationFormController().getA);
    }
    private void setStudentstoTable(ArrayList<Student> students){
        ObservableList<StudentTM> obList = FXCollections.observableArrayList();
        students.forEach(e->{
            obList.add(new StudentTM(e.getId(),e.getName(),e.getEmail(),e.getContact(),e.getAddress(),e.getNic()));
        });
        tblStudent.setItems(obList);
    }
    private void txtClear(){
        txtid.clear();
        txtName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtnic.clear();
    }
}
