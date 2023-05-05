import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReportPanel implements ActionListener {
    GUI frame;
    JPanel main;
    JPanel panel = new JPanel();
    JLabel num = new JLabel();
    JTextField numTxt = new JTextField();
    String numS = "REPORT_NUM";
    JLabel type = new JLabel();
    JTextField typeTxt = new JTextField();
    String typeS = "TYPE";
    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "FMAN_SSN";
    JLabel saleNum = new JLabel();
    JTextField saleNumTxt = new JTextField();
    String saleNumS = "REPORT_SALE_NUM";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String insert = "INSERT INTO rkraft3db.DBP_REPORT(REPORT_NUM, TYPE, FMAN_SSN, REPORT_SALE_NUM)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_REPORT WHERE ";
    boolean sqlType;
    int deleteCount = 0;

    public ReportPanel() {
        // num elements
        num.setText("Report Number:");
        num.setBounds(10, 10, 300, 25);
        numTxt.setBounds(230, 10, 150, 25);
        // Customer_type elements
        type.setText("Repot type:");
        type.setBounds(10, 50, 300, 25); // add 40 to the JLabel y-value
        typeTxt.setBounds(230, 50, 150, 25); // add 40 to the JTextField y-value
        // ssnus elements
        ssn.setText("Finance Manager ssn:");
        ssn.setBounds(10, 90, 300, 25);
        ssnTxt.setBounds(230, 90, 150, 25);
        // Type elements
        saleNum.setText("Sale number:");
        saleNum.setBounds(10, 130, 300, 25);
        saleNumTxt.setBounds(230, 130, 150, 25);
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
        panel.add(num);
        panel.add(numTxt);
        panel.add(type);
        panel.add(typeTxt);
        panel.add(ssn);
        panel.add(ssnTxt);
        panel.add(saleNum);
        panel.add(saleNumTxt);
        panel.add(submit);
        panel.add(cancle);
    }

    public void sendMain(JPanel main, GUI frame, boolean sqlType) {
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
        if (e.getSource() == submit && sqlType == true) {
            insert += "'" + numTxt.getText() + "', '" + typeTxt.getText() + "', '"
                    + ssnTxt.getText() + "', '" + saleNumTxt.getText() + "');";
            System.out.println(insert);
            frame.setMain();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == false) {
            if (numTxt.getText().length() > 0) {
                deleteCount += 1;
                delete += "(" + numS + "=" + "'" + numTxt.getText() + "')";
            }

            if (typeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + typeS + "=" + "'" + typeTxt.getText() + "')";
                else
                    delete += "(" + typeS + "=" + "'" + typeTxt.getText() + "')";
            }

            if (ssnTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
                else
                    delete += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";

            }

            if (saleNumTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + saleNumS + "=" + "'" + saleNumTxt.getText() + "')";
                else
                    delete += "(" + saleNumS + "=" + "'" + saleNumTxt.getText() + "')";
            }
            delete += ";";
            System.out.println(delete);
            frame.setMain();
        }

    }

}
