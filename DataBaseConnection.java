package base;

import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by L00113337 stanley nyadzayo on 20/02/17.
 */
public class DataBaseConnection {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DataBaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dburl = "jdbc:mysql:localhost:3306/LockerDB";
            String user = "student";
            String password = "student";
            connection = DriverManager.getConnection(dburl,user, password);

            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Student> getStudents() {

        ArrayList<Student> studentsList = new ArrayList<>();

        try {
            String query = "select * from student;";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int stu_id = resultSet.getInt("stu_ID");
                String firstN = resultSet.getString("firstN");
                String surN = resultSet.getString("surN");
                String DOB = resultSet.getString("DOB");
                String email = resultSet.getString("email");

                Student student = new Student();
                student.setStu_ID(stu_id);
                student.setFirstName(firstN);
                student.setLastName(surN);


                //create a calender object then parse the date from the database
                Calendar calendar = Calendar.getInstance();
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    calendar.setTime(dateFormat.parse(DOB));
                }catch (ParseException e) {
                    e.printStackTrace();
                }
                student.setDOB(calendar);
                student.setEmailAdd(email);
                student.setStu_ID(stu_id);

                studentsList.add(student);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }
    public void createStudent(String fNameIn, String sNameIn, Calendar DOBIn, String emailIn) {
        try{
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,);");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, fNameIn);
            preparedStatement.setString(3, sNameIn );

            //create a date
            java.sql.Date sqlDate = new java.sql.Date(DOBIn.getTimeInMillis());
            //end create date

            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setString(5, emailIn);


            System.out.print( "Details; \n" +fNameIn +" "+ sNameIn+" "+sqlDate.toString()+ " "+ emailIn+" ");
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Catch");
        }
    }

    public void removeStudent(Student student) {
        try{
            String name = student.getFirstName();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE from student where stu_ID = ?;");
            preparedStatement.setInt(1, student.getStu_ID());
            int count = preparedStatement.executeUpdate();

            if (count > 0)
                JOptionPane.showMessageDialog(null, name + "has been removed.", "Success", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Student not removed.", "Error", JOptionPane.ERROR_MESSAGE);

        }catch (Exception e) {
            e.getStackTrace();
        }
    }
    public void updateStudent(Student student) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("UPDATE student SET fName = ?, sName = ?," + "DOB = ?, email = ?, WHERE stu_ID =" + student.setStu_ID()+";");
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2,student.getLastName());

            java.sql.Date sqlDate = new java.sql.Date(student.getDOB().getTimeInMillis());

            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, student.getEmailAdd());

            int count = preparedStatement.executeUpdate();

            if (count > 0)
                JOptionPane.showMessageDialog(null, "Student updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Student not updated.", "Error", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeDatabase() {
        try{
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}