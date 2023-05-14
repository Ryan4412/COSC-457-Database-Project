import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalesrepresentativePanel implements ActionListener {

    JPanel main;
    GUI frame;
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    JLabel make = new JLabel();
    JTextField makeTxt = new JTextField();
    String makeS = "MAKE";

    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "SR_SSN";
    JLabel num = new JLabel();
    JTextField numTxt = new JTextField();
    String numS = "NO_CAR_SALES";
    JLabel com = new JLabel();
    JTextField comTxt = new JTextField();
    String comS = "COMMISSION";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String table = "DBP_SALES_REP";
    String[] column = { "SR_SSN", "NO_CAR_SALES", "COMMISSION" };
    String insert = "INSERT INTO rkraft3db.DBP_SALES_REP(SR_SSN, NO_CAR_SALES, COMMISSION)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_SALES_REP WHERE ";
    String queryS = "SELECT * FROM rkraft3db.DBP_SALES_REP WHERE ";
    String updateS = "UPDATE rkraft3db.DBP_SALES_REP SET ";
    String whatCustS = "SELECT FIRST, MINIT, LAST FROM DBP_CUSTOMER WHERE C_SSN IN (SELECT CUST_SSN FROM DBP_SALE WHERE SALE_VIN IN (SELECT VIN FROM DBP_CAR WHERE MAKE = '#'))";
    String whoBoughtS = "SELECT FIRST, LAST FROM DBP_CUSTOMER WHERE C_SSN IN (SELECT CUST_SSN FROM DBP_SALE WHERE SREP_SSN IN (SELECT SR_SSN FROM DBP_SALES_REP WHERE SR_SSN IN (SELECT SSN FROM DBP_EMPLOYEE WHERE FIRST = '!' AND LAST = '^')))";
    String where = " WHERE ";
    int sqlType;
    int deleteCount = 0;

    public SalesrepresentativePanel() {
        // ssn elements
        ssn.setText("Sales representative ssn:");
        ssn.setBounds(10, 10, 300, 25);
        ssnTxt.setBounds(230, 10, 150, 25);
        // num elements
        num.setText("Number of cars sold:");
        num.setBounds(10, 50, 300, 25);
        numTxt.setBounds(230, 50, 150, 25);
        // com elements
        com.setText("Commission:");
        com.setBounds(10, 90, 300, 25);
        comTxt.setBounds(230, 90, 150, 25);
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
        panel.add(num);
        panel.add(numTxt);
        panel.add(com);
        panel.add(comTxt);
        panel.add(submit);
        panel.add(cancle);
        // add elements to panel2
        make.setText("Customer, make bought:");
        make.setBounds(10, 50, 300, 25);
        makeTxt.setBounds(230, 50, 150, 25);

        panel2.setVisible(true);
        panel2.setBackground(new Color(200, 200, 200));
        panel2.setLayout(null);
        panel2.add(ssn);
        panel2.add(ssnTxt);
        panel2.add(make);
        panel2.add(makeTxt);
        panel2.add(submit);
        panel2.add(cancle);
    }

    public void sendMain(JPanel main, GUI frame, int sqlType) {
        this.main = main;
        this.frame = frame;
        this.sqlType = sqlType;
        main.removeAll();
        if (sqlType == 5)
            main.add(panel2);
        else
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
        if (e.getSource() == submit && sqlType == 1) {
            insert += "'" + ssnTxt.getText() + "', '" + numTxt.getText() + "', '" + comTxt.getText() + "');";
            SqlObject query = new SqlObject(frame, main, insert, table, column);
            query.updateQuery();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == 2) {
            if (ssnTxt.getText().length() > 0) {
                deleteCount += 1;
                delete += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
            }
            if (numTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + numS + "=" + "'" + numTxt.getText() + "')";
                else
                    delete += "(" + numS + "=" + "'" + numTxt.getText() + "')";

            }

            if (comTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + comS + "=" + "'" + comTxt.getText() + "')";
                else
                    delete += "(" + comS + "=" + "'" + comTxt.getText() + "')";
            }
            SqlObject query = new SqlObject(frame, main, delete, table, column);
            query.updateQuery();
        }
        //
        if (e.getSource() == submit && sqlType == 3) {
            if (ssnTxt.getText().length() > 0) {
                deleteCount += 1;
                queryS += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
            }
            if (numTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + numS + "=" + "'" + numTxt.getText() + "')";
                else
                    queryS += "(" + numS + "=" + "'" + numTxt.getText() + "')";

            }

            if (comTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + comS + "=" + "'" + comTxt.getText() + "')";
                else
                    queryS += "(" + comS + "=" + "'" + comTxt.getText() + "')";
            }

            if (deleteCount == 0) {
                queryS = queryS.replace(" WHERE ", "");
            }

            SqlObject query = new SqlObject(frame, main, queryS, table, column);
            query.query();
        }

        if (e.getSource() == submit && sqlType == 4) {
            if (ssnTxt.getText().length() > 0) {
                where += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "');";
            }
            if (numTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    updateS += "," + numS + "=" + "'" + numTxt.getText() + "'";
                else
                    updateS += numS + "=" + "'" + numTxt.getText() + "'";

            }

            if (comTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    updateS += "," + comS + "=" + "'" + comTxt.getText() + "'";
                else
                    updateS += comS + "=" + "'" + comTxt.getText() + "'";
            }

            updateS += where;
            System.out.println(updateS);
            SqlObject query = new SqlObject(frame, main, updateS, table, column);
            query.updateQuery();
        }

        if (e.getSource() == submit && sqlType == 7) {
            if (ssnTxt.getText().length() > 0) {
                where += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "');";
            }
            if (makeTxt.getText().length() > 0) {
                whatCustS = whatCustS.replace("#", makeTxt.getText());
            }

            System.out.println(updateS);
            SqlObject query = new SqlObject(frame, main, whatCustS, table, column);
            query.updateQuery();
        }

    }

}
