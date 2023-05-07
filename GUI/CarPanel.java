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
    String vinS = "VIN";
    JLabel numDoors = new JLabel();
    JTextField numDoorsTxt = new JTextField();
    String numDoorsS = "NUM_DOORS";
    JLabel color = new JLabel();
    JTextField colorTxt = new JTextField();
    String colorS = "COLOR";
    JLabel numSeats = new JLabel();
    JTextField numSeatsTxt = new JTextField();
    String numSeatsS = "NUM_SEATS";
    JLabel engineType = new JLabel();
    JTextField engineTypeTxt = new JTextField();
    String engineTypeS = "ENGINE_TYPE";
    JLabel numMiles = new JLabel();
    JTextField numMilesTxt = new JTextField();
    String numMilesS = "NUM_MILES";
    JLabel mpg = new JLabel();
    JTextField mpgTxt = new JTextField();
    String mpgS = "MPG";
    JLabel tireType = new JLabel();
    JTextField tireTypeTxt = new JTextField();
    String tireTypeS = "TIRE_TYPE";
    JLabel msrp = new JLabel();
    JTextField msrpTxt = new JTextField();
    String msrpS = "MSRP";
    JLabel year = new JLabel();
    JTextField yearTxt = new JTextField();
    String yearS = "YEAR";
    JLabel make = new JLabel();
    JTextField makeTxt = new JTextField();
    String makeS = "MAKE";
    JLabel model = new JLabel();
    JTextField modelTxt = new JTextField();
    String modelS = "MODEL";
    JLabel status = new JLabel();
    JTextField statusTxt = new JTextField();
    String statusS = "STATUS";
    JButton submit = new JButton();
    JButton cancle = new JButton();
    String table = "DBP_CAR";
    String[] column = { "VIN", "NUM_DOORS", "COLOR", "NUM_SEATS", "ENGINE_TYPE", "NUM_MILES", "MPG", "TIRE_TYPE",
            "MSRP", "YEAR", "MAKE", "MODEL", "STATUS" };
    String insert = "INSERT INTO rkraft3db.DBP_CAR(VIN, NUM_DOORS, COLOR, NUM_SEATS, ENGINE_TYPE, NUM_MILES, MPG, TIRE_TYPE, MSRP, YEAR, MAKE, MODEL, STATUS)VALUES(";
    String delete = "DELETE FROM rkraft3db.DBP_CAR WHERE ";
    String queryS = "SELECT * FROM rkraft3db.DBP_CAR WHERE ";
    boolean sqlType;
    boolean sqlQuery;
    int deleteCount = 0;

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

    public void sendMain(JPanel main, GUI frame, boolean sqlType, boolean sqlQuery) {
        this.main = main;
        this.frame = frame;
        this.sqlType = sqlType;
        this.sqlQuery = sqlQuery;
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
            insert += "'" + vinTxt.getText() + "', '" + numDoorsTxt.getText() + "', '" + colorTxt.getText() + "', '"
                    + numSeatsTxt.getText() + "', '" + engineTypeTxt.getText() + "', '" + numMilesTxt.getText() + "', '"
                    + mpgTxt.getText() + "', '" + tireTypeTxt.getText() + "', '" + msrpTxt.getText() + "', '"
                    + yearTxt.getText() + "', '" + makeTxt.getText() + "', '" + modelTxt.getText()
                    + "', '" + statusTxt.getText() + "');";
            SqlObject query = new SqlObject(frame, main, insert, table, column);
            query.updateQuery();
        }
        // delete submit
        if (e.getSource() == submit && sqlType == false && sqlQuery == false) {
            if (vinTxt.getText().length() > 0) {
                deleteCount += 1;
                delete += "(" + vinS + "=" + "'" + vinTxt.getText() + "')";
            }

            if (numDoorsTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + numDoorsS + "=" + "'" + numDoorsTxt.getText() + "')";
                else
                    delete += "(" + numDoorsS + "=" + "'" + numDoorsTxt.getText() + "')";

            }

            if (colorTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + colorS + "=" + "'" + colorTxt.getText() + "')";
                else
                    delete += "(" + colorS + "=" + "'" + colorTxt.getText() + "')";
            }

            if (numSeatsTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + numSeatsS + "=" + "'" + numSeatsTxt.getText() + "')";
                else
                    delete += "(" + numSeatsS + "=" + "'" + numSeatsTxt.getText() + "')";
            }

            if (engineTypeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + engineTypeS + "=" + "'" + engineTypeTxt.getText() + "')";
                else
                    delete += "(" + engineTypeS + "=" + "'" + engineTypeTxt.getText() + "')";
            }
            if (numMilesTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + numMilesS + "=" + "'" + numMilesTxt.getText() + "')";
                else
                    delete += "(" + numMilesS + "=" + "'" + numMilesTxt.getText() + "')";
            }

            if (mpgTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + mpgS + "=" + "'" + mpgTxt.getText() + "')";
                else
                    delete += "(" + mpgS + "=" + "'" + mpgTxt.getText() + "')";

            }

            if (tireTypeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + tireTypeS + "=" + "'" + tireTypeTxt.getText() + "')";
                else
                    delete += "(" + tireTypeS + "=" + "'" + tireTypeTxt.getText() + "')";
            }

            if (msrpTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + msrpS + "=" + "'" + msrpTxt.getText() + "')";
                else
                    delete += "(" + msrpS + "=" + "'" + msrpTxt.getText() + "')";
            }

            if (yearTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + yearS + "=" + "'" + yearTxt.getText() + "')";
                else
                    delete += "(" + yearS + "=" + "'" + yearTxt.getText() + "')";
            }
            if (makeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + makeS + "=" + "'" + makeTxt.getText() + "')";
                else
                    delete += "(" + makeS + "=" + "'" + makeTxt.getText() + "')";
            }

            if (modelTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + modelS + "=" + "'" + modelTxt.getText() + "')";
                else
                    delete += "(" + modelS + "=" + "'" + modelTxt.getText() + "')";
            }

            if (statusTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    delete += "and(" + statusS + "=" + "'" + statusTxt.getText() + "')";
                else
                    delete += "(" + statusS + "=" + "'" + statusTxt.getText() + "')";
            }
            delete += ";";
            SqlObject query = new SqlObject(frame, main, delete, table, column);
            query.updateQuery();

        }
        if (e.getSource() == submit && sqlType == false && sqlQuery == true) {
            if (vinTxt.getText().length() > 0) {
                deleteCount += 1;
                queryS += "(" + vinS + "=" + "'" + vinTxt.getText() + "')";
            }

            if (numDoorsTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + numDoorsS + "=" + "'" + numDoorsTxt.getText() + "')";
                else
                    queryS += "(" + numDoorsS + "=" + "'" + numDoorsTxt.getText() + "')";

            }

            if (colorTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + colorS + "=" + "'" + colorTxt.getText() + "')";
                else
                    queryS += "(" + colorS + "=" + "'" + colorTxt.getText() + "')";
            }

            if (numSeatsTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + numSeatsS + "=" + "'" + numSeatsTxt.getText() + "')";
                else
                    queryS += "(" + numSeatsS + "=" + "'" + numSeatsTxt.getText() + "')";
            }

            if (engineTypeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + engineTypeS + "=" + "'" + engineTypeTxt.getText() + "')";
                else
                    queryS += "(" + engineTypeS + "=" + "'" + engineTypeTxt.getText() + "')";
            }
            if (numMilesTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + numMilesS + "=" + "'" + numMilesTxt.getText() + "')";
                else
                    queryS += "(" + numMilesS + "=" + "'" + numMilesTxt.getText() + "')";
            }

            if (mpgTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + mpgS + "=" + "'" + mpgTxt.getText() + "')";
                else
                    queryS += "(" + mpgS + "=" + "'" + mpgTxt.getText() + "')";

            }

            if (tireTypeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + tireTypeS + "=" + "'" + tireTypeTxt.getText() + "')";
                else
                    queryS += "(" + tireTypeS + "=" + "'" + tireTypeTxt.getText() + "')";
            }

            if (msrpTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + msrpS + "=" + "'" + msrpTxt.getText() + "')";
                else
                    queryS += "(" + msrpS + "=" + "'" + msrpTxt.getText() + "')";
            }

            if (yearTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + yearS + "=" + "'" + yearTxt.getText() + "')";
                else
                    queryS += "(" + yearS + "=" + "'" + yearTxt.getText() + "')";
            }
            if (makeTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + makeS + "=" + "'" + makeTxt.getText() + "')";
                else
                    queryS += "(" + makeS + "=" + "'" + makeTxt.getText() + "')";
            }

            if (modelTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + modelS + "=" + "'" + modelTxt.getText() + "')";
                else
                    queryS += "(" + modelS + "=" + "'" + modelTxt.getText() + "')";
            }

            if (statusTxt.getText().length() > 0) {
                deleteCount += 1;
                if (deleteCount > 1)
                    queryS += "and(" + statusS + "=" + "'" + statusTxt.getText() + "')";
                else
                    queryS += "(" + statusS + "=" + "'" + statusTxt.getText() + "')";
            }
            queryS += ";";
            SqlObject query = new SqlObject(frame, main, queryS, table, column);
            query.query();

        }
    }

}
