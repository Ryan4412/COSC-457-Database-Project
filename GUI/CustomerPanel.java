import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerPanel implements ActionListener {

    JPanel main;
    GUI frame;
    JPanel panel = new JPanel();
    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "C_SSN";
    JLabel first = new JLabel();
    JTextField firstTxt = new JTextField();
    String firstS = "FIRST";
    JLabel minit = new JLabel();
    JTextField minitTxt = new JTextField();
    String minitS = "MINIT";
    JLabel last = new JLabel();
    JTextField lastTxt = new JTextField();
    String lastS = "LAST";
    JLabel occupation = new JLabel();
    JTextField occupationTxt = new JTextField();
    String occupationS = "OCCUPATION";
    JLabel creditScore = new JLabel();
    JTextField creditScoreTxt = new JTextField();
    String creditScoreS = "CREDIT_SCORE";
    JLabel gmi = new JLabel();
    JTextField gmiTxt = new JTextField();
    String gmiS = "GMI";
    JLabel recentEmployer = new JLabel();
    JTextField recentEmployerTxt = new JTextField();
    String recentEmployerS = "RECENT_EMPLOYER";
    JLabel licenseNum = new JLabel();
    JTextField licenseNumTxt = new JTextField();
    String licenseNumS = "LICENSE_NUM";
    JLabel paymentType = new JLabel();
    JTextField paymentTypeTxt = new JTextField();
    String paymentTypeS = "PAYMENT_TYPE";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String table = "DBP_CUSTOMER";
    String[] column = { "C_SSN", "FIRST", "MINIT", "LAST", "OCCUPATION", "CREDIT_SCORE", "GMI", "RECENT_EMPLOYER",
            "LICENSE_NUM", "PAYMENT_TYPE" };
    String insert = "INSERT INTO rkraft3db.DBP_CUSTOMER(C_SSN, FIRST, MINIT, LAST, OCCUPATION, CREDIT_SCORE, GMI, RECENT_EMPLOYER, LICENSE_NUM, PAYMENT_TYPE)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_CUSTOMER WHERE ";
    String queryS = "SELECT * FROM rkraft3db.DBP_CUSTOMER WHERE ";
    boolean sqlType;
    boolean sqlQuery;
    int deleteCount = 0;

    public CustomerPanel() {
        // ssn elements
        ssn.setText("Customer ssn:");
        ssn.setBounds(10, 10, 300, 25);
        ssnTxt.setBounds(230, 10, 150, 25);
        // first elements
        first.setText("First name:");
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
        // creditScore_first
        creditScore.setText("Credit score:");
        creditScore.setBounds(10, 130, 300, 25);
        creditScoreTxt.setBounds(230, 130, 150, 25);
        // gmi elements
        gmi.setText("Gross monthly income:");
        gmi.setBounds(10, 160, 300, 25);
        gmiTxt.setBounds(230, 160, 150, 25);
        // recentEmployer elements
        recentEmployer.setText("Most recent employer:");
        recentEmployer.setBounds(10, 190, 300, 25);
        recentEmployerTxt.setBounds(230, 190, 150, 25);
        // licenseNum elements
        licenseNum.setText("License number:");
        licenseNum.setBounds(10, 220, 300, 25);
        licenseNumTxt.setBounds(230, 220, 150, 25);
        // paymentType elements
        paymentType.setText("payment type:");
        paymentType.setBounds(10, 250, 300, 25);
        paymentTypeTxt.setBounds(230, 250, 150, 25);
        // occupation elements
        occupation.setText("Occupation:");
        occupation.setBounds(10, 280, 300, 25);
        occupationTxt.setBounds(230, 280, 150, 25);
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
        panel.add(occupation);
        panel.add(occupationTxt);
        panel.add(creditScore);
        panel.add(creditScoreTxt);
        panel.add(gmi);
        panel.add(gmiTxt);
        panel.add(recentEmployer);
        panel.add(recentEmployerTxt);
        panel.add(licenseNum);
        panel.add(licenseNumTxt);
        panel.add(paymentType);
        panel.add(paymentTypeTxt);
        panel.add(last);
        panel.add(lastTxt);
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
            insert += "'" + ssnTxt.getText() + "', '" + firstTxt.getText() + "', '" + minitTxt.getText() + "', '"
                    + lastTxt.getText() + "', '" + occupationTxt.getText() + "', '" + creditScoreTxt.getText() + "', '"
                    + gmiTxt.getText() + "', '" + recentEmployerTxt.getText() + "', '" + licenseNumTxt.getText()
                    + "', '"
                    + paymentTypeTxt.getText() + "');";
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

            if (occupationTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + occupationS + "=" + "'" + occupationTxt.getText() + "')";
                else
                    delete += "(" + occupationS + "=" + "'" + occupationTxt.getText() + "')";
            }
            if (creditScoreTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + creditScoreS + "=" + "'" + creditScoreTxt.getText() + "')";
                else
                    delete += "(" + creditScoreS + "=" + "'" + creditScoreTxt.getText() + "')";
            }

            if (gmiTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + gmiS + "=" + "'" + gmiTxt.getText() + "')";
                else
                    delete += "(" + gmiS + "=" + "'" + gmiTxt.getText() + "')";

            }

            if (recentEmployerTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + recentEmployerS + "=" + "'" + recentEmployerTxt.getText() + "')";
                else
                    delete += "(" + recentEmployerS + "=" + "'" + recentEmployerTxt.getText() + "')";
            }

            if (licenseNumTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + licenseNumS + "=" + "'" + licenseNumTxt.getText() + "')";
                else
                    delete += "(" + licenseNumS + "=" + "'" + licenseNumTxt.getText() + "')";
            }

            if (paymentTypeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + paymentTypeS + "=" + "'" + paymentTypeTxt.getText() + "')";
                else
                    delete += "(" + paymentTypeS + "=" + "'" + paymentTypeTxt.getText() + "')";
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

            if (occupationTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + occupationS + "=" + "'" + occupationTxt.getText() + "')";
                else
                    queryS += "(" + occupationS + "=" + "'" + occupationTxt.getText() + "')";
            }
            if (creditScoreTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + creditScoreS + "=" + "'" + creditScoreTxt.getText() + "')";
                else
                    queryS += "(" + creditScoreS + "=" + "'" + creditScoreTxt.getText() + "')";
            }

            if (gmiTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + gmiS + "=" + "'" + gmiTxt.getText() + "')";
                else
                    queryS += "(" + gmiS + "=" + "'" + gmiTxt.getText() + "')";

            }

            if (recentEmployerTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + recentEmployerS + "=" + "'" + recentEmployerTxt.getText() + "')";
                else
                    queryS += "(" + recentEmployerS + "=" + "'" + recentEmployerTxt.getText() + "')";
            }

            if (licenseNumTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + licenseNumS + "=" + "'" + licenseNumTxt.getText() + "')";
                else
                    queryS += "(" + licenseNumS + "=" + "'" + licenseNumTxt.getText() + "')";
            }

            if (paymentTypeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + paymentTypeS + "=" + "'" + paymentTypeTxt.getText() + "')";
                else
                    queryS += "(" + paymentTypeS + "=" + "'" + paymentTypeTxt.getText() + "')";
            }
            queryS += ";";
            SqlObject query = new SqlObject(frame, main, queryS, table, column);
            query.query();

        }
    }

}
