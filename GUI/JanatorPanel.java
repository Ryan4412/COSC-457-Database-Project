import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanatorPanel implements ActionListener {

    JPanel main;
    GUI frame;
    JPanel panel = new JPanel();
    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "J_SSN";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String insert = "INSERT INTO rkraft3db.DBP_JANITOR(J_SSN)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_JANITOR WHERE ";
    boolean sqlType;

    public JanatorPanel() {
        // ssn elements
        ssn.setText("Janator ssn:");
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
            insert += "'" + ssnTxt.getText() + "');";
            System.out.println(insert);
            frame.setMain();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == false) {
            if (ssnTxt.getText().length() > 0)
                delete += "(" + ssnS + "=" + "'" + ssnTxt.getText() + "')";
            delete += ";";
            System.out.println(delete);
            frame.setMain();
        }
    }

}
