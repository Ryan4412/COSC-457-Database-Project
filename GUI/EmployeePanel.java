import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmployeePanel implements ActionListener {

    JPanel main;
    GUI frame;
    JPanel panel = new JPanel();
    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "SSN";
    JLabel first = new JLabel();
    JTextField firstTxt = new JTextField();
    String firstS = "FIRST";
    JLabel minit = new JLabel();
    JTextField minitTxt = new JTextField();
    String minitS = "MINIT";
    JLabel last = new JLabel();
    JTextField lastTxt = new JTextField();
    String lastS = "LAST";
    JLabel jobType = new JLabel();
    JTextField jobTypeTxt = new JTextField();
    String jobTypeS = "JOB_TYPE";
    JLabel salary = new JLabel();
    JTextField salaryTxt = new JTextField();
    String salaryS = "SALARY";
    JLabel department = new JLabel();
    JTextField departmentTxt = new JTextField();
    String departmentS = "DEPARTMENT";
    JLabel address = new JLabel();
    JTextField addressTxt = new JTextField();
    String addressS = "ADDRESS";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String table = "DBP_EMPLOYEE";
    String[] column = { "SSN", "FIRST", "MINIT", "LAST", "JOB_TYPE", "SALARY", "DEPARTMENT", "ADDRESS" };
    String insert = "INSERT INTO rkraft3db.DBP_EMPLOYEE(SSN, FIRST, MINIT, LAST, JOB_TYPE, SALARY, DEPARTMENT, ADDRESS)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_EMPLOYEE WHERE ";
    String queryS = "SELECT * FROM rkraft3db.DBP_CUSTOMER WHERE ";
    boolean sqlType;
    boolean sqlQuery;
    int deleteCount = 0;

    public EmployeePanel() {
        // ssn elements
        ssn.setText("Employee ssn:");
        ssn.setBounds(10, 10, 300, 25);
        ssnTxt.setBounds(230, 10, 150, 25);
        // first elements
        first.setText("Firest name:");
        first.setBounds(10, 40, 300, 25); // add 30 to the JLabel y-value
        firstTxt.setBounds(230, 40, 150, 25); // add 30 to the JTextField y-value
        // minit elements
        minit.setText("Middle initial:");
        minit.setBounds(10, 70, 300, 25);
        minitTxt.setBounds(230, 70, 150, 25);
        // last elements
        last.setText("Last name:");
        last.setBounds(10, 100, 300, 25);
        lastTxt.setBounds(230, 100, 150, 25);
        // jobType elements
        jobType.setText("Job type:");
        jobType.setBounds(10, 130, 300, 25);
        jobTypeTxt.setBounds(230, 130, 150, 25);
        // salary elements
        salary.setText("Salary:");
        salary.setBounds(10, 160, 300, 25);
        salaryTxt.setBounds(230, 160, 150, 25);
        // department elements
        department.setText("Department:");
        department.setBounds(10, 190, 300, 25);
        departmentTxt.setBounds(230, 190, 150, 25);
        // address elements
        address.setText("Address:");
        address.setBounds(10, 220, 300, 25);
        addressTxt.setBounds(230, 220, 150, 25);
        // submit button
        submit.addActionListener(this);
        submit.setText("Submit");
        submit.setBounds(415, 370, 80, 25);
        submit.setFocusable(false);
        submit.setVisible(true);
        // cancle button
        cancle.addActionListener(this);
        cancle.setText("Cancle");
        cancle.setBounds(415, 335, 80, 25);
        cancle.setFocusable(false);
        cancle.setVisible(true);
        // add elements to panel
        panel.setVisible(true);
        panel.setBackground(new Color(200, 200, 200));
        panel.setLayout(null);
        panel.add(ssn);
        panel.add(ssnTxt);
        panel.add(first);
        panel.add(firstTxt);
        panel.add(minit);
        panel.add(minitTxt);
        panel.add(last);
        panel.add(lastTxt);
        panel.add(jobType);
        panel.add(jobTypeTxt);
        panel.add(salary);
        panel.add(salaryTxt);
        panel.add(department);
        panel.add(departmentTxt);
        panel.add(address);
        panel.add(addressTxt);
        panel.add(submit);
        panel.add(cancle);
    }

    public void sendMain(JPanel main, GUI frame, boolean sqlType, boolean sqlQuery) {
        this.main = main;
        this.frame = frame;
        this.sqlType = sqlType;
        this.sqlQuery = sqlQuery;
        main.removeAll();
        main.add(panel);
        main.revalidate();
        main.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancle) {
            frame.setMain();
        }
        if (e.getSource() == submit) {
            System.out.println(
                    addressTxt.getText());
            frame.setMain();
        }
        // insert submit
        if (e.getSource() == submit && sqlType == true) {
            insert += "'" + ssnTxt.getText() + "', '" + firstTxt.getText() + "', '" + minitTxt.getText() + "', '"
                    + lastTxt.getText() + "', '" + jobTypeTxt.getText() + "', '" + salaryTxt.getText() + "', '"
                    + departmentTxt.getText() + "', '" + addressTxt.getText() + "');";
            System.out.println(insert);
            SqlObject query = new SqlObject(frame, main, insert, table, column);
            query.updateQuery();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == false && sqlQuery == false) {
            if (ssnTxt.getText().length() > 0) {
                deleteCount += 1;
                delete += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
            }

            if (firstTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + firstS + "=" + "'" + firstTxt.getText() + "')";
                else
                    delete += "(" + firstS + "=" + "'" + firstTxt.getText() + "')";

            }

            if (minitTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + minitS + "=" + "'" + minitTxt.getText() + "')";
                else
                    delete += "(" + minitS + "=" + "'" + minitTxt.getText() + "')";
            }

            if (lastTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + lastS + "=" + "'" + lastTxt.getText() + "')";
                else
                    delete += "(" + lastS + "=" + "'" + lastTxt.getText() + "')";
            }

            if (jobTypeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + jobTypeS + "=" + "'" + jobTypeTxt.getText() + "')";
                else
                    delete += "(" + jobTypeS + "=" + "'" + jobTypeTxt.getText() + "')";
            }
            if (salaryTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + salaryS + "=" + "'" + salaryTxt.getText() + "')";
                else
                    delete += "(" + salaryS + "=" + "'" + salaryTxt.getText() + "')";
            }

            if (departmentTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + departmentS + "=" + "'" + departmentTxt.getText() + "')";
                else
                    delete += "(" + departmentS + "=" + "'" + departmentTxt.getText() + "')";

            }

            if (addressTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + addressS + "=" + "'" + addressTxt.getText() + "')";
                else
                    delete += "(" + addressS + "=" + "'" + addressTxt.getText() + "')";
            }
            delete += ";";
            SqlObject query = new SqlObject(frame, main, delete, table, column);
            query.updateQuery();

        }
        if (e.getSource() == submit && sqlType == false && sqlQuery == true) {
            if (ssnTxt.getText().length() > 0) {
                deleteCount += 1;
                queryS += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
            }

            if (firstTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + firstS + "=" + "'" + firstTxt.getText() + "')";
                else
                    queryS += "(" + firstS + "=" + "'" + firstTxt.getText() + "')";

            }

            if (minitTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + minitS + "=" + "'" + minitTxt.getText() + "')";
                else
                    queryS += "(" + minitS + "=" + "'" + minitTxt.getText() + "')";
            }

            if (lastTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + lastS + "=" + "'" + lastTxt.getText() + "')";
                else
                    queryS += "(" + lastS + "=" + "'" + lastTxt.getText() + "')";
            }

            if (jobTypeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + jobTypeS + "=" + "'" + jobTypeTxt.getText() + "')";
                else
                    queryS += "(" + jobTypeS + "=" + "'" + jobTypeTxt.getText() + "')";
            }
            if (salaryTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + salaryS + "=" + "'" + salaryTxt.getText() + "')";
                else
                    queryS += "(" + salaryS + "=" + "'" + salaryTxt.getText() + "')";
            }

            if (departmentTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + departmentS + "=" + "'" + departmentTxt.getText() + "')";
                else
                    queryS += "(" + departmentS + "=" + "'" + departmentTxt.getText() + "')";

            }

            if (addressTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + addressS + "=" + "'" + addressTxt.getText() + "')";
                else
                    queryS += "(" + addressS + "=" + "'" + addressTxt.getText() + "')";
            }
            queryS += ";";
            SqlObject query = new SqlObject(frame, main, queryS, table, column);
            query.updateQuery();

        }
    }

}
