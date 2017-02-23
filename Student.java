package base;
//edited on thursday 23 feb

import java.util.Calendar;

/**
 * Created by L00113337 stanley nyadzayo on 20/02/17.
 */
public class Student {
    private int stu_ID;
    private String firstName, lastName;
    private Calendar DOB;
    private String emailAdd;

    public Student() {}

    public Student(String firstName) {
        this.firstName = firstName;
    }

    public Student(int stu_ID, String firstName, String lastName, Calendar dOB, String emailAdd) {
        this.stu_ID = stu_ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = dOB;
        this.emailAdd = emailAdd;
    }

    public int getStu_ID() {
        return stu_ID;
    }

    public void setStu_ID(int stu_ID) {
        this.stu_ID = stu_ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getDOB() {
        return DOB;
    }

    public void setDOB(Calendar DOB) {
        this.DOB = DOB;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_ID=" + stu_ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", emailAdd='" + emailAdd + '\'' +
                '}';
    }
}
