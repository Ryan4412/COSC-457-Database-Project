import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmployeePanel implements ActionListener {

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
    JLabel jobType = new JLabel();
    JTextField jobTypeTxt = new JTextField();
    String jobTypeS = "";
    JLabel salary = new JLabel();
    JTextField salaryTxt = new JTextField();
    String salaryS = "";
    JLabel department = new JLabel();
    JTextField departmentTxt = new JTextField();
    String departmentS = "";
    JLabel address = new JLabel();
    JTextField addressTxt = new JTextField();
    String addressS = "";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String insert = "";

    public EmployeePanel() {
        // ssn elements
        ssn.setText("Employee ssn:");
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
        // last elements
        last.setText("Last name:");
        last.setBounds(10, 100, 300, 25);
        lastTxt.setBounds(230, 100, 150, 25);
        // jobType elements
        jobType.setText("Job type:");
        jobType.setBounds(10, 130, 300, 25);
        jobTypeTxt.setBounds(230, 130, 150, 25);
        // salary elements
        salary.setText("Salary:");
        salary.setBounds(10, 160, 300, 25);
        salaryTxt.setBounds(230, 160, 150, 25);
        // department elements
        department.setText("Department:");
        department.setBounds(10, 190, 300, 25);
        departmentTxt.setBounds(230, 190, 150, 25);
        // address elements
        address.setText("Address:");
        address.setBounds(10, 220, 300, 25);
        addressTxt.setBounds(230, 220, 150, 25);
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
        panel.add(jobType);
        panel.add(jobTypeTxt);
        panel.add(salary);
        panel.add(salaryTxt);
        panel.add(department);
        panel.add(departmentTxt);
        panel.add(address);
        panel.add(addressTxt);
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
                            + minitTxt.getText() + lastTxt.getText()
                            + jobTypeTxt.getText() + salaryTxt.getText()
                            + departmentTxt.getText() + addressTxt.getText());
            frame.setMain();
        }
    }

}
