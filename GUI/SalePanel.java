import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalePanel implements ActionListener {
    GUI frame;
    JPanel main;
    JPanel panel = new JPanel();
    JLabel num = new JLabel();
    JTextField numTxt = new JTextField();
    String numS = "SALE_NUM";
    JLabel cssn = new JLabel();
    JTextField cssnTxt = new JTextField();
    String cssnS = "CUST_SSN";
    JLabel srssn = new JLabel();
    JTextField srssnTxt = new JTextField();
    String srssnS = "SREP_SSN";
    JLabel smssn = new JLabel();
    JTextField smssnTxt = new JTextField();
    String smssnS = "SMAN_SSN";
    JLabel vinNum = new JLabel();
    JTextField vinNumTxt = new JTextField();
    String vinNumS = "SALE_VIN";
    JLabel type = new JLabel();
    JTextField typeTxt = new JTextField();
    String typeS = "TYPE";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String table = "DBP_SALE";
    String[] column = { "SALE_NUM", "CUST_SSN", "SREP_SSN", "SMAN_SSN", "SALE_VIN", "TYPE" };
    String insert = "INSERT INTO rkraft3db.DBP_SALE(SALE_NUM, CUST_SSN, SREP_SSN, SMAN_SSN, SALE_VIN, TYPE)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_SALE WHERE ";
    String queryS = "SELECT * FROM rkraft3db.DBP_SALE WHERE ";
    String updateS = "UPDATE rkraft3db.DBP_SALE SET ";
    String where = " WHERE ";
    int sqlType;
    int deleteCount = 0;

    public SalePanel() {
        // num elements
        num.setText("Sale number:");
        num.setBounds(10, 10, 300, 25);
        numTxt.setBounds(230, 10, 150, 25);
        // cssn elements
        cssn.setText("Customer ssn:");
        cssn.setBounds(10, 50, 300, 25); // add 40 to the JLabel y-value
        cssnTxt.setBounds(230, 50, 150, 25); // add 40 to the JTextField y-value
        // srssn elements
        srssn.setText("Sales Representative ssn:");
        srssn.setBounds(10, 90, 300, 25);
        srssnTxt.setBounds(230, 90, 150, 25);
        // smssn elements
        smssn.setText("Sales Manager ssn:");
        smssn.setBounds(10, 130, 300, 25);
        smssnTxt.setBounds(230, 130, 150, 25);
        // vinNum elements
        vinNum.setText("Sales vin number:");
        vinNum.setBounds(10, 170, 300, 25);
        vinNumTxt.setBounds(230, 170, 150, 25);
        // type elements
        type.setText("Sales type:");
        type.setBounds(10, 210, 300, 25);
        typeTxt.setBounds(230, 210, 150, 25);
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
        panel.add(cssn);
        panel.add(cssnTxt);
        panel.add(srssn);
        panel.add(srssnTxt);
        panel.add(smssn);
        panel.add(smssnTxt);
        panel.add(vinNum);
        panel.add(vinNumTxt);
        panel.add(type);
        panel.add(typeTxt);
        panel.add(submit);
        panel.add(cancle);
    }

    public void sendMain(JPanel main, GUI frame, int sqlType) {
        this.main = main;
        this.frame = frame;
        this.sqlType = sqlType;
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
        if (e.getSource() == submit && sqlType == 1) {
            insert += "'" + numTxt.getText() + "', '" + cssnTxt.getText() + "', '" + srssnTxt.getText() + "', '"
                    + smssnTxt.getText() + "', '" + vinNumTxt.getText() + "', '" + typeTxt.getText() + "');";
            SqlObject query = new SqlObject(frame, main, insert, table, column);
            query.updateQuery();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == 2) {
            if (numTxt.getText().length() > 0) {
                deleteCount += 1;
                delete += "(" + numS + "=" + "'" + numTxt.getText() + "')";
            }

            if (cssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + cssnS + "=" + "'" + cssnTxt.getText() + "')";
                else
                    delete += "(" + cssnS + "=" + "'" + cssnTxt.getText() + "')";

            }

            if (srssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + srssnS + "=" + "'" + srssnTxt.getText() + "')";
                else
                    delete += "(" + srssnS + "=" + "'" + srssnTxt.getText() + "')";
            }

            if (smssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + smssnS + "=" + "'" + smssnTxt.getText() + "')";
                else
                    delete += "(" + smssnS + "=" + "'" + smssnTxt.getText() + "')";
            }

            if (vinNumTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + vinNumS + "=" + "'" + vinNumTxt.getText() + "')";
                else
                    delete += "(" + vinNumS + "=" + "'" + vinNumTxt.getText() + "')";
            }
            if (typeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + typeS + "=" + "'" + typeTxt.getText() + "')";
                else
                    delete += "(" + typeS + "=" + "'" + typeTxt.getText() + "')";
            }
            SqlObject query = new SqlObject(frame, main, delete, table, column);
            query.updateQuery();

        }
        if (e.getSource() == submit && sqlType == 3) {
            if (numTxt.getText().length() > 0) {
                deleteCount += 1;
                queryS += "(" + numS + "=" + "'" + numTxt.getText() + "')";
            }

            if (cssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + cssnS + "=" + "'" + cssnTxt.getText() + "')";
                else
                    queryS += "(" + cssnS + "=" + "'" + cssnTxt.getText() + "')";

            }

            if (srssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + srssnS + "=" + "'" + srssnTxt.getText() + "')";
                else
                    queryS += "(" + srssnS + "=" + "'" + srssnTxt.getText() + "')";
            }

            if (smssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + smssnS + "=" + "'" + smssnTxt.getText() + "')";
                else
                    queryS += "(" + smssnS + "=" + "'" + smssnTxt.getText() + "')";
            }

            if (vinNumTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + vinNumS + "=" + "'" + vinNumTxt.getText() + "')";
                else
                    queryS += "(" + vinNumS + "=" + "'" + vinNumTxt.getText() + "')";
            }
            if (typeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + typeS + "=" + "'" + typeTxt.getText() + "')";
                else
                    queryS += "(" + typeS + "=" + "'" + typeTxt.getText() + "')";
            }

            if (deleteCount == 0) {
                queryS = queryS.replace(" WHERE ", "");
            }

            SqlObject query = new SqlObject(frame, main, queryS, table, column);
            query.query();
        }

        if (e.getSource() == submit && sqlType == 4) {
            if (numTxt.getText().length() > 0) {
                deleteCount += 1;
                where += "(" + numS + "=" + "'" + numTxt.getText() + "');";
            }

            if (cssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + cssnS + "=" + "'" + cssnTxt.getText() + "')";
                else
                    queryS += "(" + cssnS + "=" + "'" + cssnTxt.getText() + "')";

            }

            if (srssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + srssnS + "=" + "'" + srssnTxt.getText() + "')";
                else
                    queryS += "(" + srssnS + "=" + "'" + srssnTxt.getText() + "')";
            }

            if (smssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + smssnS + "=" + "'" + smssnTxt.getText() + "')";
                else
                    queryS += "(" + smssnS + "=" + "'" + smssnTxt.getText() + "')";
            }

            if (vinNumTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + vinNumS + "=" + "'" + vinNumTxt.getText() + "')";
                else
                    queryS += "(" + vinNumS + "=" + "'" + vinNumTxt.getText() + "')";
            }
            if (typeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + typeS + "=" + "'" + typeTxt.getText() + "')";
                else
                    queryS += "(" + typeS + "=" + "'" + typeTxt.getText() + "')";
            }

            if (deleteCount == 0) {
                queryS = queryS.replace(" WHERE ", "");
            }

            SqlObject query = new SqlObject(frame, main, queryS, table, column);
            query.query();
        }

        if (e.getSource() == submit && sqlType == 4) {
            if (numTxt.getText().length() > 0) {
                where += "(" + numS + "=" + "'" + numTxt.getText() + "');";
            }

            if (cssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    updateS += "," + cssnS + "=" + "'" + cssnTxt.getText() + "'";
                else
                    updateS += cssnS + "=" + "'" + cssnTxt.getText() + "'";

            }

            if (srssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    updateS += "," + srssnS + "=" + "'" + srssnTxt.getText() + "'";
                else
                    updateS += srssnS + "=" + "'" + srssnTxt.getText() + "'";
            }

            if (smssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    updateS += "," + smssnS + "=" + "'" + smssnTxt.getText() + "'";
                else
                    updateS += smssnS + "=" + "'" + smssnTxt.getText() + "'";
            }

            if (vinNumTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    updateS += "," + vinNumS + "=" + "'" + vinNumTxt.getText() + "'";
                else
                    updateS += vinNumS + "=" + "'" + vinNumTxt.getText() + "'";
            }
            if (typeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    updateS += "," + typeS + "=" + "'" + typeTxt.getText() + "'";
                else
                    updateS += typeS + "=" + "'" + typeTxt.getText() + "'";
            }

            updateS += where;
            System.out.println(updateS);
            SqlObject query = new SqlObject(frame, main, updateS, table, column);
            query.updateQuery();
        }

    }

}
