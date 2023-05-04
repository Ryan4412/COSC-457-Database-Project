import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CarPanel implements ActionListener {

    JPanel main;
    GUI frame;
    JPanel panel = new JPanel();
    JLabel vin = new JLabel();
    JTextField vinTxt = new JTextField();
    String vinS = "";
    JLabel numDoors = new JLabel();
    JTextField numDoorsTxt = new JTextField();
    String numDoorsS = "";
    JLabel color = new JLabel();
    JTextField colorTxt = new JTextField();
    String colorS = "";
    JLabel numSeats = new JLabel();
    JTextField numSeatsTxt = new JTextField();
    String numSeatsS = "";
    JLabel engineType = new JLabel();
    JTextField engineTypeTxt = new JTextField();
    String engineTypeS = "";
    JLabel numMiles = new JLabel();
    JTextField numMilesTxt = new JTextField();
    String numMilesS = "";
    JLabel mpg = new JLabel();
    JTextField mpgTxt = new JTextField();
    String mpgS = "";
    JLabel tireType = new JLabel();
    JTextField tireTypeTxt = new JTextField();
    String tireTypeS = "";
    JLabel msrp = new JLabel();
    JTextField msrpTxt = new JTextField();
    String msrpS = "";
    JLabel year = new JLabel();
    JTextField yearTxt = new JTextField();
    String yearS = "";
    JLabel make = new JLabel();
    JTextField makeTxt = new JTextField();
    String makeeS = "";
    JLabel model = new JLabel();
    JTextField modelTxt = new JTextField();
    String modelS = "";
    JLabel status = new JLabel();
    JTextField statusTxt = new JTextField();
    String statusS = "";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String insert = "";

    public CarPanel() {
        // vin elements
        vin.setText("Vin number:");
        vin.setBounds(10, 10, 300, 25);
        vinTxt.setBounds(230, 10, 150, 25);
        // numDoors elements
        numDoors.setText("Number of doors:");
        numDoors.setBounds(10, 40, 300, 25); // add 30 to the JLabel y-value
        numDoorsTxt.setBounds(230, 40, 150, 25); // add 30 to the JTextField y-value
        // color elements
        color.setText("color:");
        color.setBounds(10, 70, 300, 25);
        colorTxt.setBounds(230, 70, 150, 25);
        // numSeats elements
        numSeats.setText("Number of seats:");
        numSeats.setBounds(10, 100, 300, 25);
        numSeatsTxt.setBounds(230, 100, 150, 25);
        // engineType_numDoors
        engineType.setText("Engine type:");
        engineType.setBounds(10, 130, 300, 25);
        engineTypeTxt.setBounds(230, 130, 150, 25);
        // numMiles elements
        numMiles.setText("Number of miles:");
        numMiles.setBounds(10, 160, 300, 25);
        numMilesTxt.setBounds(230, 160, 150, 25);
        // mpg elements
        mpg.setText("MPG:");
        mpg.setBounds(10, 190, 300, 25);
        mpgTxt.setBounds(230, 190, 150, 25);
        // tireType elements
        tireType.setText("Tire type:");
        tireType.setBounds(10, 220, 300, 25);
        tireTypeTxt.setBounds(230, 220, 150, 25);
        // msrp elements
        msrp.setText("MSRP:");
        msrp.setBounds(10, 250, 300, 25);
        msrpTxt.setBounds(230, 250, 150, 25);
        // year elements
        year.setText("Year:");
        year.setBounds(10, 280, 300, 25);
        yearTxt.setBounds(230, 280, 150, 25);
        // make elements
        make.setText("Make:");
        make.setBounds(10, 310, 300, 25);
        makeTxt.setBounds(230, 310, 150, 25);
        // model elements
        model.setText("Model:");
        model.setBounds(10, 340, 300, 25);
        modelTxt.setBounds(230, 340, 150, 25);
        // status elements
        status.setText("Status:");
        status.setBounds(10, 370, 300, 25);
        statusTxt.setBounds(230, 370, 150, 25);
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
        panel.add(numDoors);
        panel.add(numDoorsTxt);
        panel.add(color);
        panel.add(colorTxt);
        panel.add(numSeats);
        panel.add(numSeatsTxt);
        panel.add(engineType);
        panel.add(engineTypeTxt);
        panel.add(numMiles);
        panel.add(numMilesTxt);
        panel.add(mpg);
        panel.add(mpgTxt);
        panel.add(tireType);
        panel.add(tireTypeTxt);
        panel.add(msrp);
        panel.add(msrpTxt);
        panel.add(year);
        panel.add(yearTxt);
        panel.add(make);
        panel.add(makeTxt);
        panel.add(model);
        panel.add(modelTxt);
        panel.add(status);
        panel.add(statusTxt);
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
                    vinTxt.getText() + numDoorsTxt.getText()
                            + colorTxt.getText() + numSeatsTxt.getText()
                            + engineTypeTxt.getText() + numMilesTxt.getText()
                            + mpgTxt.getText() + tireTypeTxt.getText()
                            + msrpTxt.getText() + yearTxt.getText()
                            + makeTxt.getText() + modelTxt.getText()
                            + statusTxt.getText());
            frame.setMain();
        }
    }

}
