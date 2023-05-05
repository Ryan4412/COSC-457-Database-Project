import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UsedcarPanel implements ActionListener {

    JPanel main;
    GUI frame;
    JPanel panel = new JPanel();
    JLabel vin = new JLabel();
    JTextField vinTxt = new JTextField();
    String vinS = "USED_VIN";
    JLabel recal = new JLabel();
    JTextField recalTxt = new JTextField();
    String recalS = "RECALL_STATMENT";
    JLabel reg = new JLabel();
    JTextField regTxt = new JTextField();
    String regS = "REGISTRATION_NUM";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String insert = "INSERT INTO rkraft3db.DBP_USED_CAR(USED_VIN, RECALL_STATMENT, REGISTRATION_NUM)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_USED_CAR WHERE ";
    boolean sqlType;
    int deleteCount = 0;

    public UsedcarPanel() {
        // vin elements
        vin.setText("Vin number:");
        vin.setBounds(10, 10, 300, 25);
        vinTxt.setBounds(230, 10, 150, 25);
        // recal elements
        recal.setText("Recal statment:");
        recal.setBounds(10, 50, 300, 25);
        recalTxt.setBounds(230, 50, 150, 25);
        // coreg elements
        reg.setText("Registration:");
        reg.setBounds(10, 90, 300, 25);
        regTxt.setBounds(230, 90, 150, 25);
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
        panel.add(vin);
        panel.add(vinTxt);
        panel.add(recal);
        panel.add(recalTxt);
        panel.add(reg);
        panel.add(regTxt);
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
            insert += "'" + vinTxt.getText() + "', '" + recalTxt.getText() + "', '" + regTxt.getText() + "');";
            System.out.println(insert);
            frame.setMain();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == false) {
            if (vinTxt.getText().length() > 0) {
                deleteCount += 1;
                delete += "(" + vinS + "=" + "'" + vinTxt.getText() + "')";
            }
            if (recalTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + recalS + "=" + "'" + recalTxt.getText() + "')";
                else
                    delete += "(" + recalS + "=" + "'" + recalTxt.getText() + "')";

            }

            if (regTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + regS + "=" + "'" + regTxt.getText() + "')";
                else
                    delete += "(" + regS + "=" + "'" + regTxt.getText() + "')";
            }
            delete += ";";
            System.out.println(delete);
            frame.setMain();
        }
    }

}
