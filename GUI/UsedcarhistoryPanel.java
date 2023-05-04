import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UsedcarhistoryPanel implements ActionListener {
    GUI frame;
    JPanel main;
    JPanel panel = new JPanel();
    JLabel vin = new JLabel();
    JTextField vinTxt = new JTextField();
    String vinS = "";
    JLabel numA = new JLabel();
    JTextField numATxt = new JTextField();
    String numAS = "";
    JLabel numR = new JLabel();
    JTextField numRTxt = new JTextField();
    String numRS = "";
    JLabel large = new JLabel();
    JTextField largeTxt = new JTextField();
    String largeS = "";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String sqlssnment = "";

    public UsedcarhistoryPanel() {
        // vin elements
        vin.setText("Vin:");
        vin.setBounds(10, 10, 300, 25);
        vinTxt.setBounds(230, 10, 150, 25);
        // numA elements
        numA.setText("Number of acitdents:");
        numA.setBounds(10, 50, 300, 25); // add 40 to the JLabel y-value
        numATxt.setBounds(230, 50, 150, 25); // add 40 to the JTextField y-value
        // numR elements
        numR.setText("Number of repairs:");
        numR.setBounds(10, 90, 300, 25);
        numRTxt.setBounds(230, 90, 150, 25);
        // large elements
        large.setText("Largest part repaired:");
        large.setBounds(10, 130, 300, 25);
        largeTxt.setBounds(230, 130, 150, 25);
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
        panel.add(numA);
        panel.add(numATxt);
        panel.add(numR);
        panel.add(numRTxt);
        panel.add(large);
        panel.add(largeTxt);
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
                    vinTxt.getText() + numATxt.getText()
                            + numRTxt.getText() + largeTxt.getText());
            frame.setMain();
        }

    }

}
