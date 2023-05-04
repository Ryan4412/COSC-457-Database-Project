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
    String numS = "";
    JLabel type = new JLabel();
    JTextField typeTxt = new JTextField();
    String typeS = "";
    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "";
    JLabel saleNum = new JLabel();
    JTextField saleNumTxt = new JTextField();
    String saleNumS = "";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String sqlssnment = "";

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
                    numTxt.getText() + typeTxt.getText()
                            + ssnTxt.getText() + saleNumTxt.getText());
            frame.setMain();
        }

    }

}
