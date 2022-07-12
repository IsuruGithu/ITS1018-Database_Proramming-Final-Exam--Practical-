/**
 * @author : Isuru Lakmal G K A
 * Date    : $(DATE)
 **/

package controller;

import com.jfoenix.controls.JFXTextField;
import controller.controllers.StudentController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import view.TM.StudentTM;

import java.sql.SQLException;
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

    public void studentSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Student s1 = new Student(
                txtid.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText(),txtnic.getText()
        );
        if (saveStudent(s1)){
            new Alert(Alert.AlertType.CONFIRMATION,"Success").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }

    }
    boolean saveStudent(Student s) throws SQLException, ClassNotFoundException {
        return new StudentController().saveStudent(s);
    }

    public void studentDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (new StudentController().deleteStudent(txtid.getText())){
            txtClear();
            initialize();
            new Alert(Alert.AlertType.CONFIRMATION,"Success").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }
    }

    public void studentUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Student s1 = new Student(
                txtid.getText(),
                txtName.getText(),
                txtEmail.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtnic.getText()
        );

        if (new StudentController().updateStudent(s1)){
            initialize();
            new Alert(Alert.AlertType.CONFIRMATION,"Success").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }
    }

    public void searchStudentOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {String customerId=txtid.getText();
        String studentId=txtid.getText();
        Student s1 = new StudentController().getStudent(customerId);
        if (s1==null){

        }else {
            setData(s1);
        }
    }

    public void btnclearOnAction(ActionEvent actionEvent) {
        txtClear();
    }
    public void initialize(){
        try {
            clmid.setCellValueFactory(new PropertyValueFactory<>("Id"));
            clmname.setCellValueFactory(new PropertyValueFactory<>("Name"));
            clmemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
            clmcontact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
            clmaddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
            clmnic.setCellValueFactory(new PropertyValueFactory<>("NIC"));

            setStudentstoTable(new StudentController().getAllStudent());
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    void setData(Student s1){
        txtid.setText(s1.getId());
        txtName.setText(s1.getName());
        txtEmail.setText(s1.getEmail());
        txtContact.setText(s1.getContact());
        txtAddress.setText(s1.getAddress());
        txtnic.setText(s1.getNic());
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
