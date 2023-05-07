import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReceptionistPanel implements ActionListener {

    JPanel main;
    GUI frame;
    JPanel panel = new JPanel();
    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "R_SSN";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String table = "DBP_RECEPTIONIST";
    String[] column = { "R_SSN" };
    String insert = "INSERT INTO rkraft3db.DBP_RECEPTIONIST(R_SSN)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_RECEPTIONIST WHERE ";
    String queryS = "SELECT * FROM rkraft3db.DBP_RECEPTIONIST WHERE ";
    boolean sqlType;
    boolean sqlQuery;

    public ReceptionistPanel() {
        // ssn elements
        ssn.setText("Receptionist ssn:");
        ssn.setBounds(10, 10, 300, 25);
        ssnTxt.setBounds(230, 10, 150, 25);
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
        panel.add(ssn);
        panel.add(ssnTxt);
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
            insert += "'" + ssnTxt.getText() + "');";
            SqlObject query = new SqlObject(frame, main, insert, table, column);
            query.updateQuery();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == false && sqlQuery == false) {
            if (ssnTxt.getText().length() > 0)
                delete += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
            delete += ";";
            SqlObject query = new SqlObject(frame, main, delete, table, column);
            query.updateQuery();
        }
        if (e.getSource() == submit && sqlType == false && sqlQuery == true) {
            if (ssnTxt.getText().length() > 0)
                queryS += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
            queryS += ";";
            SqlObject query = new SqlObject(frame, main, queryS, table, column);
            query.query();
        }
    }

}
