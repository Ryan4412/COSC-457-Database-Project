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
    String numS = "";
    JLabel cssn = new JLabel();
    JTextField cssnTxt = new JTextField();
    String cssnS = "";
    JLabel srssn = new JLabel();
    JTextField srssnTxt = new JTextField();
    String srssnS = "";
    JLabel smssn = new JLabel();
    JTextField smssnTxt = new JTextField();
    String smssnS = "";
    JLabel vinNum = new JLabel();
    JTextField vinNumTxt = new JTextField();
    String vinNumS = "";
    JLabel type = new JLabel();
    JTextField typeTxt = new JTextField();
    String typeS = "";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String sqlStatment = "";

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

    public void sendMain(JPanel main, GUI frame) {
        this.main = main;
        this.frame = frame;
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
                    numTxt.getText() + cssnTxt.getText()
                            + srssnTxt.getText() + smssnTxt.getText()
                            + vinNumTxt.getText() + typeTxt.getText());
            frame.setMain();
        }

    }

}
