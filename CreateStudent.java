package base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Created by L00113337 stanley nyadzayo on 20/02/17.
 */
public class CreateStudent extends JFrame implements ActionListener{
    private JLabel lbFirstN, lbSurN, lbDOB, lbEmail, lbStuID;
    private JTextField txtFirstN, txtLastN, txtDOB, txtEmail, txtStuID;
    private JButton btnMake, btnCancel;

    public CreateStudent() {
        setTitle("Create Student");
        setLayout(new BorderLayout());

        //The first panel
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6, 2));
        //Student name
        lbFirstN = new JLabel("First Name: ");
        txtFirstN = new JTextField();
        lbSurN = new JLabel("Last Name: ");
        txtLastN = new JTextField();
        p1.add(lbFirstN);
        p1.add(txtFirstN);
        p1.add(lbSurN);
        p1.add(txtLastN);

        //Student DOB
        lbDOB = new JLabel("DOB");
        txtDOB = new JTextField();
        p1.add(lbDOB);
        p1.add(txtDOB);

        //Student ID
        lbStuID = new JLabel("Student ID");
        txtStuID = new JTextField();
        p1.add(lbStuID);
        p1.add(txtStuID);

        //Student email address
        lbEmail = new JLabel("Email");
        txtEmail = new JTextField();
        p1.add(lbEmail);
        p1.add(txtEmail);

        p1.setBackground(Color.blue);
        p1.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(p1, BorderLayout.NORTH);

        //Panel 2
        JPanel p2 = new JPanel();
        btnCancel = new JButton("Cancel");
        btnMake = new JButton("Create");
        p2.add(btnCancel);
        p2.add(btnMake);
        add(p2, BorderLayout.CENTER);

        //Add action listeners to the buttons
        btnCancel.addActionListener(this);
        btnMake.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Create" :
                Calendar calendar = Calendar.getInstance();

        }
    }
}
