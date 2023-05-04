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
    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "";
    JLabel num = new JLabel();
    JTextField numTxt = new JTextField();
    String numS = "";
    JLabel com = new JLabel();
    JTextField comTxt = new JTextField();
    String comS = "";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String insert = "";

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
        panel.add(num);
        panel.add(numTxt);
        panel.add(com);
        panel.add(comTxt);
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
            System.out.println(ssnTxt.getText() + numTxt.getText()
                    + comTxt.getText());
            frame.setMain();
        }
    }

}
