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
    String vinS = "USED_CH_VIN";
    JLabel numA = new JLabel();
    JTextField numATxt = new JTextField();
    String numAS = "NUM_ACIDENTS";
    JLabel numR = new JLabel();
    JTextField numRTxt = new JTextField();
    String numRS = "NUM_REPAIRS";
    JLabel large = new JLabel();
    JTextField largeTxt = new JTextField();
    String largeS = "LARGEST_PART_REPAIRED";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String table = "DBP_USED_CAR_HISTORY";
    String[] column = { "USED_CH_VIN", "NUM_ACIDENTS", "NUM_REPAIRS", "LARGEST_PART_REPAIR" };
    String insert = "INSERT INTO rkraft3db.DBP_USED_CAR_HISTORY(USED_CH_VIN, NUM_ACIDENTS, NUM_REPAIRS, LARGEST_PART_REPAIRED)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_USED_CAR_HISTORY WHERE ";
    String queryS = "SELECT * FROM rkraft3db.DBP_USED_CAR_HISTORY WHERE ";
    int sqlType;
    int deleteCount = 0;

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
        cancle.setText("Cancel");
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

    public void sendMain(JPanel main, GUI frame, int sqlType) {
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
        if (e.getSource() == submit && sqlType == 1) {
            insert += "'" + vinTxt.getText() + "', '" + numATxt.getText() + "', '"
                    + numRTxt.getText() + "', '" + largeTxt.getText() + "');";
            SqlObject query = new SqlObject(frame, main, insert, table, column);
            query.updateQuery();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == 2) {
            if (vinTxt.getText().length() > 0) {
                deleteCount += 1;
                delete += "(" + vinS + "=" + "'" + vinTxt.getText() + "')";
            }

            if (numATxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + numAS + "=" + "'" + numATxt.getText() + "')";
                else
                    delete += "(" + numAS + "=" + "'" + numATxt.getText() + "')";
            }

            if (numRTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + numRS + "=" + "'" + numRTxt.getText() + "')";
                else
                    delete += "(" + numRS + "=" + "'" + numRTxt.getText() + "')";

            }

            if (largeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + largeS + "=" + "'" + largeTxt.getText() + "')";
                else
                    delete += "(" + largeS + "=" + "'" + largeTxt.getText() + "')";
            }
            SqlObject query = new SqlObject(frame, main, delete, table, column);
            query.updateQuery();

        }
        if (e.getSource() == submit && sqlType == 3) {
            if (vinTxt.getText().length() > 0) {
                deleteCount += 1;
                queryS += "(" + vinS + "=" + "'" + vinTxt.getText() + "')";
            }

            if (numATxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + numAS + "=" + "'" + numATxt.getText() + "')";
                else
                    queryS += "(" + numAS + "=" + "'" + numATxt.getText() + "')";
            }

            if (numRTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + numRS + "=" + "'" + numRTxt.getText() + "')";
                else
                    queryS += "(" + numRS + "=" + "'" + numRTxt.getText() + "')";

            }

            if (largeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + largeS + "=" + "'" + largeTxt.getText() + "')";
                else
                    queryS += "(" + largeS + "=" + "'" + largeTxt.getText() + "')";
            }

            if (deleteCount == 0) {
                queryS = queryS.replace(" WHERE ", "");
            }

            SqlObject query = new SqlObject(frame, main, queryS, table, column);
            query.query();

        }

    }

}
