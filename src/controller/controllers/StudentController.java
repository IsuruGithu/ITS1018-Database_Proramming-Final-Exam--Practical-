/**
 * @author : Isuru Lakmal G K A
 * Date    : $(DATE)
 **/

package controller.controllers;

import controller.StudentService;
import db.Dbconnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController implements StudentService {
    @Override
    public boolean saveStudent(Student s) throws SQLException, ClassNotFoundException {
        Connection con = Dbconnection.getInstance().getConnection();
        String query = "INSERT INTO Student VALUES (?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,s.getId());
        stm.setObject(2,s.getName());
        stm.setObject(3,s.getEmail());
        stm.setObject(4,s.getContact());
        stm.setObject(5,s.getAddress());
        stm.setObject(6,s.getNic());

        return stm.executeUpdate()>0;
    }

    @Override
    public boolean updateStudent(Student s) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = Dbconnection.getInstance().getConnection().prepareStatement("UPDATE Student SET student_name=?, email=?, contact=?, address=?, nic=? WHERE student_id=?");
        stm.setObject(1,s.getName());
        stm.setObject(2,s.getEmail());
        stm.setObject(3,s.getContact());
        stm.setObject(4,s.getAddress());
        stm.setObject(5,s.getNic());
        stm.setObject(6,s.getId());

        return stm.executeUpdate()>0;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        if (Dbconnection.getInstance().getConnection().prepareStatement("DELETE FROM Student WHERE student_id='"+id+"'").executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Student getStudent(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = Dbconnection.getInstance().getConnection().prepareStatement("SELECT * FROM Student WHERE student_id=?");
        stm.setObject(1,id);
        ResultSet set =  stm.executeQuery();

        if (set.next()){
            return new Student(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6)
            );

        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = Dbconnection.getInstance().getConnection().prepareStatement("SELECT * FROM Student");
        ResultSet rst = stm.executeQuery();

        ArrayList<Student> customers = new ArrayList<>();
        while (rst.next()){
            customers.add(new Student(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return customers;
    }
}

