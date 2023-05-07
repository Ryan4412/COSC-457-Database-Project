import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppointmentPanel implements ActionListener {
    GUI frame;
    JPanel main;
    JPanel panel = new JPanel();
    JLabel num = new JLabel();
    JTextField numTxt = new JTextField();
    String numS = "APPOINTMENT_NUM";
    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "CUSTOMER_SSN";
    JLabel stat = new JLabel();
    JTextField statTxt = new JTextField();
    String statS = "STATUS";
    JLabel type = new JLabel();
    JTextField typeTxt = new JTextField();
    String typeS = "TYPE";
    JLabel rep = new JLabel();
    JTextField repTxt = new JTextField();
    String repS = "REP_SSN";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String table = "DBP_APPOINTMENT";
    String[] column = { "APPOINTMENT_NUM", "CUSTOMER_SSN", "STATUS", "TYPE", "REP_SSN" };
    String insert = "INSERT INTO rkraft3db.DBP_APPOINTMENT(APPOINTMENT_NUM, CUSTOMER_SSN, STATUS, TYPE, REP_SSN)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_APPOINTMENT WHERE ";
    String queryS = "SELECT * FROM rkraft3db.DBP_APPOINTMENT WHERE ";
    boolean sqlType;
    boolean sqlQuery;
    int deleteCount = 0;

    public AppointmentPanel() {
        // Appointment_num elements
        num.setText("Apointment Number (int):");
        num.setBounds(10, 10, 300, 25);
        numTxt.setBounds(230, 10, 150, 25);
        // Customer_ssn elements
        ssn.setText("Customer SSN (123456789):");
        ssn.setBounds(10, 50, 300, 25); // add 40 to the JLabel y-value
        ssnTxt.setBounds(230, 50, 150, 25); // add 40 to the JTextField y-value
        // Status elements
        stat.setText("Status (Created, Initiated, Complete):");
        stat.setBounds(10, 90, 300, 25);
        statTxt.setBounds(230, 90, 150, 25);
        // Type elements
        type.setText("type (Consultation, Service):");
        type.setBounds(10, 130, 300, 25);
        typeTxt.setBounds(230, 130, 150, 25);
        // Rep_ssn
        rep.setText("Receptionist SSN:");
        rep.setBounds(10, 170, 300, 25);
        repTxt.setBounds(230, 170, 150, 25);
        // submit button
        submit.addActionListener(this);
        submit.setText("Submit");
        submit.setBounds(415, 370, 80, 25);
        submit.setFocusable(false);
        submit.setVisible(true);
        // cancle button
        cancle.addActionListener(this);
        cancle.setText("Cancel");
        cancle.setBounds(415, 335, 80, 25);
        cancle.setFocusable(false);
        cancle.setVisible(true);
        // add elements to panel
        panel.setVisible(true);
        panel.setBackground(new Color(200, 200, 200));
        panel.setLayout(null);
        panel.add(num);
        panel.add(numTxt);
        panel.add(ssn);
        panel.add(ssnTxt);
        panel.add(stat);
        panel.add(statTxt);
        panel.add(type);
        panel.add(typeTxt);
        panel.add(rep);
        panel.add(repTxt);
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
        // insert submit
        if (e.getSource() == submit && sqlType == true) {
            insert += "'" + numTxt.getText() + "', '" + ssnTxt.getText() + "', '" + statTxt.getText() + "', '"
                    + typeTxt.getText() + "', '" + repTxt.getText() + "');";
            // System.out.println(insert);
            SqlObject query = new SqlObject(frame, main, insert, table, column);
            query.updateQuery();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == false && sqlQuery == false) {
            if (numTxt.getText().length() > 0) {
                deleteCount += 1;
                delete += "(" + numS + "=" + "'" + numTxt.getText() + "')";
            }

            if (ssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
                else
                    delete += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";

            }

            if (statTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + statS + "=" + "'" + statTxt.getText() + "')";
                else
                    delete += "(" + statS + "=" + "'" + statTxt.getText() + "')";
            }

            if (typeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + typeS + "=" + "'" + typeTxt.getText() + "')";
                else
                    delete += "(" + typeS + "=" + "'" + typeTxt.getText() + "')";
            }

            if (repTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + repS + "=" + "'" + repTxt.getText() + "')";
                else
                    delete += "(" + repS + "=" + "'" + repTxt.getText() + "')";
            }
            delete += ";";
            // System.out.println(delete);
            SqlObject query = new SqlObject(frame, main, delete, table, column);
            query.updateQuery();
        }
        if (e.getSource() == submit && sqlType == false && sqlQuery == true) {
            if (numTxt.getText().length() > 0) {
                deleteCount += 1;
                queryS += "(" + numS + "=" + "'" + numTxt.getText() + "')";
            }

            if (ssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
                else
                    queryS += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";

            }

            if (statTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + statS + "=" + "'" + statTxt.getText() + "')";
                else
                    queryS += "(" + statS + "=" + "'" + statTxt.getText() + "')";
            }

            if (typeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + typeS + "=" + "'" + typeTxt.getText() + "')";
                else
                    queryS += "(" + typeS + "=" + "'" + typeTxt.getText() + "')";
            }

            if (repTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + repS + "=" + "'" + repTxt.getText() + "')";
                else
                    queryS += "(" + repS + "=" + "'" + repTxt.getText() + "')";
            }
            queryS += ";";
            // System.out.println(queryS);
            SqlObject query = new SqlObject(frame, main, queryS, table, column);
            query.query();
            frame.setMain();
        }

    }

}
