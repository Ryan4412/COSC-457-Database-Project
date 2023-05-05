import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewcarPanel implements ActionListener {

    JPanel main;
    GUI frame;
    JPanel panel = new JPanel();
    JLabel vin = new JLabel();
    JTextField vinTxt = new JTextField();
    String vinS = "VIN";
    JLabel dealerCertified = new JLabel();
    JTextField dealerCertifiedTxt = new JTextField();
    String dealerCertifiedS = "DEALER_CERTIFIED";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String insert = "INSERT INTO rkraft3db.DBP_NEW_CAR(VIN, DEALER_CERTIFIED)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_NEW_CAR WHERE ";
    boolean sqlType;
    int deleteCount = 0;

    public NewcarPanel() {
        // vin elements
        vin.setText("New car vin:");
        vin.setBounds(10, 10, 300, 25);
        vinTxt.setBounds(230, 10, 150, 25);
        // dealerCertified elements
        dealerCertified.setText("Dealer certified:");
        dealerCertified.setBounds(10, 40, 300, 25);
        dealerCertifiedTxt.setBounds(230, 40, 150, 25);
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
        panel.add(dealerCertified);
        panel.add(dealerCertifiedTxt);
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
            insert += "'" + vinTxt.getText() + "', '" + dealerCertifiedTxt.getText() + "');";
            System.out.println(insert);
            frame.setMain();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == false) {
            if (vinTxt.getText().length() > 0) {
                deleteCount += 1;
                delete += "(" + vinS + "=" + "'" + vinTxt.getText() + "')";
            }

            if (dealerCertifiedTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + dealerCertifiedS + "=" + "'" + dealerCertifiedTxt.getText() + "')";
                else
                    delete += "(" + dealerCertifiedS + "=" + "'" + dealerCertifiedTxt.getText() + "')";
            }
            delete += ";";
            System.out.println(delete);
            frame.setMain();
        }
    }

}
