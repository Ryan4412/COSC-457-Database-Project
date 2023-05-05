import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CosignerPanel implements ActionListener {

    JPanel main;
    GUI frame;
    JPanel panel = new JPanel();
    JLabel ssn = new JLabel();
    JTextField ssnTxt = new JTextField();
    String ssnS = "";
    JLabel first = new JLabel();
    JTextField firstTxt = new JTextField();
    String firstS = "";
    JLabel minit = new JLabel();
    JTextField minitTxt = new JTextField();
    String minitS = "";
    JLabel last = new JLabel();
    JTextField lastTxt = new JTextField();
    String lastS = "";
    JLabel occupation = new JLabel();
    JTextField occupationTxt = new JTextField();
    String occupationS = "";
    JLabel creditScore = new JLabel();
    JTextField creditScoreTxt = new JTextField();
    String creditScoreS = "";
    JLabel gmi = new JLabel();
    JTextField gmiTxt = new JTextField();
    String gmiS = "";
    JLabel recentEmployer = new JLabel();
    JTextField recentEmployerTxt = new JTextField();
    String recentEmployerS = "";
    JLabel licenseNum = new JLabel();
    JTextField licenseNumTxt = new JTextField();
    String licenseNumS = "";
    JLabel paymentType = new JLabel();
    JTextField paymentTypeTxt = new JTextField();
    String paymentTypeS = "";
    JLabel customerSSN = new JLabel();
    JTextField customerSSNTxt = new JTextField();
    String customerSSNS = "";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String insert = "";

    public CosignerPanel() {
        // ssn elements
        ssn.setText("Cosigner ssn:");
        ssn.setBounds(10, 10, 300, 25);
        ssnTxt.setBounds(230, 10, 150, 25);
        // first elements
        first.setText("Firest name:");
        first.setBounds(10, 40, 300, 25); // add 30 to the JLabel y-value
        firstTxt.setBounds(230, 40, 150, 25); // add 30 to the JTextField y-value
        // minit elements
        minit.setText("Middle initial:");
        minit.setBounds(10, 70, 300, 25);
        minitTxt.setBounds(230, 70, 150, 25);
        // occupation elements
        last.setText("Last name:");
        last.setBounds(10, 100, 300, 25);
        lastTxt.setBounds(230, 100, 150, 25);
        // occupation elements
        occupation.setText("Occupation:");
        occupation.setBounds(10, 130, 300, 25);
        occupationTxt.setBounds(230, 130, 150, 25);
        // creditScore_first
        creditScore.setText("Credit score:");
        creditScore.setBounds(10, 160, 300, 25);
        creditScoreTxt.setBounds(230, 160, 150, 25);
        // gmi elements
        gmi.setText("Gross monthly income:");
        gmi.setBounds(10, 190, 300, 25);
        gmiTxt.setBounds(230, 190, 150, 25);
        // recentEmployer elements
        recentEmployer.setText("Most recent employer:");
        recentEmployer.setBounds(10, 220, 300, 25);
        recentEmployerTxt.setBounds(230, 220, 150, 25);
        // licenseNum elements
        licenseNum.setText("License number:");
        licenseNum.setBounds(10, 250, 300, 25);
        licenseNumTxt.setBounds(230, 250, 150, 25);
        // paymentType elements
        paymentType.setText("payment type:");
        paymentType.setBounds(10, 280, 300, 25);
        paymentTypeTxt.setBounds(230, 280, 150, 25);
        // customerSSN elements
        customerSSN.setText("Customer ssn:");
        customerSSN.setBounds(10, 310, 300, 25);
        customerSSNTxt.setBounds(230, 310, 150, 25);
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
        panel.add(last);
        panel.add(lastTxt);
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
        panel.add(customerSSN);
        panel.add(customerSSNTxt);
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
                    ssnTxt.getText() + firstTxt.getText()
                            + minitTxt.getText() + occupationTxt.getText()
                            + creditScoreTxt.getText() + gmiTxt.getText()
                            + recentEmployerTxt.getText() + licenseNumTxt.getText()
                            + paymentTypeTxt.getText() + customerSSNTxt.getText());
            frame.setMain();
        }
    }

}
