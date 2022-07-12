/**
 * @author : Isuru Lakmal G K A
 * Date    : $(DATE)
 **/

package controller;

import model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentService {
    public boolean saveStudent(Student s) throws SQLException, ClassNotFoundException;
    public boolean updateStudent(Student s) throws SQLException, ClassNotFoundException;
    public boolean deleteStudent(Student s) throws SQLException, ClassNotFoundException;
    public boolean getStudent(Student s) throws SQLException, ClassNotFoundException;
    public ArrayList<Student> getAllStudent() throws SQLException, ClassNotFoundException;
}
