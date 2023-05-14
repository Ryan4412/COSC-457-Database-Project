import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QueryPanel implements ActionListener {
    JLabel prompt = new JLabel();
    JLabel queryPrompt = new JLabel();
    JPanel panel = new JPanel();
    JPanel main;
    GUI frame;
    JComboBox select;
    String[] selectable = { "Appointment", "Car", "Cosigner", "Customer",
            "Employee", "Finance Manager", "Janator", "New Car",
            "Receptionist", "Report", "Sale", "Sales Manager",
            "Sales Rep", "Used Car", "Used Car History" };
    JComboBox selectQuery;
    String[] selectableQueries = { "Average commission of sales representative",
            "Sales representative commission (highest to lowest)",
            "Sales representative car sales (highest to lowest)", "Average salary of sales manager",
            "Used Car MPG (highest to lowest)", "New Car MPG (highest to lowest)", "All Car MPG (highest to lowest)",
            "Average customer GMI",
            "Customer GMI (highest to lowest)", "Average customer credit score",
            "Customer credit score (highest to lowest)", "Average cosigner GMI",
            "Cosigner GMI (highest to lowest)", "Average cosigner credit score",
            "Cosigner credit score (highest to lowest)" };

    public QueryPanel() {
        select = new JComboBox<>(selectable);
        select.addActionListener(this);
        prompt.setText("Please select which data you would like to query using the drop down menu");
        selectQuery = new JComboBox<>(selectableQueries);
        queryPrompt.setText(
                "                                                        Other queries                                                        "); // space
                                                                                                                                                  // needed
        selectQuery.addActionListener(this);
        queryPrompt.setBounds(0, 50, 1000, 0);
        selectQuery.setBounds(0, 50, 1000, 0);
        panel.add(prompt);
        panel.add(select);
        panel.add(queryPrompt);
        panel.add(selectQuery);
        panel.setVisible(true);
        panel.setBackground(new Color(200, 200, 200));
        panel.setLayout(new FlowLayout());

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
        if (e.getSource() == select) {
            System.out.println(select.getSelectedItem());

            if (select.getSelectedItem().equals("Appointment")) {
                AppointmentPanel appointment = new AppointmentPanel();
                appointment.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Car")) {
                CarPanel car = new CarPanel();
                car.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Cosigner")) {
                CosignerPanel cosigner = new CosignerPanel();
                cosigner.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Customer")) {
                CustomerPanel customer = new CustomerPanel();
                customer.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Employee")) {
                EmployeePanel employee = new EmployeePanel();
                employee.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Finance Manager")) {
                FinancemanagerPanel financemanager = new FinancemanagerPanel();
                financemanager.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Janator")) {
                JanatorPanel janator = new JanatorPanel();
                janator.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("New Car")) {
                NewcarPanel newcar = new NewcarPanel();
                newcar.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Receptionist")) {
                ReceptionistPanel receptionist = new ReceptionistPanel();
                receptionist.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Report")) {
                ReportPanel report = new ReportPanel();
                report.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Sale")) {
                SalePanel sale = new SalePanel();
                sale.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Sales Manager")) {
                SalesmanagerPanel salesmanager = new SalesmanagerPanel();
                salesmanager.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Sales Rep")) {
                SalesrepresentativePanel salesrepresentative = new SalesrepresentativePanel();
                salesrepresentative.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Used Car")) {
                UsedcarPanel usedcar = new UsedcarPanel();
                usedcar.sendMain(main, frame, 3);
            }
            if (select.getSelectedItem().equals("Used Car History")) {
                UsedcarhistoryPanel usedcarhistory = new UsedcarhistoryPanel();
                usedcarhistory.sendMain(main, frame, 3);
            }
        }
        if (e.getSource() == selectQuery) {
            // sales rep avr commission
            if (selectQuery.getSelectedItem().equals("Average commission of sales reps")) {
                String[] column = { "COMMISSION" };
                SqlObject query = new SqlObject(frame, main, "SELECT AVG(COMMISSION) FROM rkraft3db.DBP_SALES_REP;",
                        "DBP_SALES_REP", column);
                query.query();
            }
            // sales rep commission high-low
            if (selectQuery.getSelectedItem().equals("Sales representative commission (highest to lowest)")) {
                String[] column = { "SR_SSN", "NO_CAR_SALES", "COMMISSION" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT* FROM rkraft3db.DBP_SALES_REP ORDER BY COMMISSION DESC;",
                        "DBP_SALES_REP", column);
                query.query();
            }
            // All car MPG
            if (selectQuery.getSelectedItem().equals("All Car MPG (highest to lowest)")) {
                String[] column = { "VIN", "NUM_DOORS", "COLOR", "NUM_SEATS", "ENGINE_TYPE", "NUM_MILES", "MPG",
                        "TIRE_TYPE",
                        "MSRP", "YEAR", "MAKE", "MODEL", "STATUS" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT* FROM rkraft3db.DBP_CAR ORDER BY MPG DESC;",
                        "DBP_CAR", column);
                query.query();
            }
            // customer gmi
            if (selectQuery.getSelectedItem().equals("Average customer GMI")) {
                String[] column = { "GMI" };
                SqlObject query = new SqlObject(frame, main, "SELECT AVG(GMI) FROM rkraft3db.DBP_CUSTOMER;",
                        "DBP_CUSTOMER", column);
                query.query();
            }
            if (selectQuery.getSelectedItem().equals("Customer GMI (highest to lowest)")) {
                String[] column = { "C_SSN", "FIRST", "MINIT", "LAST", "OCCUPATION", "CREDIT_SCORE", "GMI",
                        "RECENT_EMPLOYER",
                        "LICENSE_NUM", "PAYMENT_TYPE" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT* FROM rkraft3db.DBP_CUSTOMER ORDER BY GMI DESC;",
                        "DBP_CUSTOMER", column);
                query.query();
            }
            // customer credit score
            if (selectQuery.getSelectedItem().equals("Average customer credit score")) {
                String[] column = { "CREDIT_SCORE" };
                SqlObject query = new SqlObject(frame, main, "SELECT AVG(CREDIT_SCORE) FROM rkraft3db.DBP_CUSTOMER;",
                        "DBP_CUSTOMER", column);
                query.query();
            }
            if (selectQuery.getSelectedItem().equals("Customer credit score (highest to lowest)")) {
                String[] column = { "C_SSN", "FIRST", "MINIT", "LAST", "OCCUPATION", "CREDIT_SCORE", "GMI",
                        "RECENT_EMPLOYER",
                        "LICENSE_NUM", "PAYMENT_TYPE" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT* FROM rkraft3db.DBP_CUSTOMER ORDER BY CREDIT_SCORE DESC;",
                        "DBP_CUSTOMER", column);
                query.query();
            }
            // cosigner gmi
            if (selectQuery.getSelectedItem().equals("Average cosigner GMI")) {
                String[] column = { "GMI" };
                SqlObject query = new SqlObject(frame, main, "SELECT AVG(GMI) FROM rkraft3db.DBP_COSIGNER;",
                        "DBP_COSIGNER", column);
                query.query();
            }
            if (selectQuery.getSelectedItem().equals("Cosigner GMI (highest to lowest)")) {
                String[] column = { "CO_SSN", "FIRST", "MINIT", "LAST", "OCCUPATION", "CREDIT_SCORE", "GMI",
                        "RECENT_EMPLOYER",
                        "LICENSE_NUM", "PAYMENT_TYPE", "CUSTOMER_SSN" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT* FROM rkraft3db.DBP_COSIGNER ORDER BY GMI DESC;",
                        "DBP_COSIGNER", column);
                query.query();
            }
            // Cosigner credit
            if (selectQuery.getSelectedItem().equals("Average cosigner credit score")) {
                String[] column = { "CREDIT_SCORE" };
                SqlObject query = new SqlObject(frame, main, "SELECT AVG(CREDIT_SCORE) FROM rkraft3db.DBP_COSIGNER;",
                        "DBP_COSIGNER", column);
                query.query();
            }
            if (selectQuery.getSelectedItem().equals("Cosigner credit score (highest to lowest)")) {
                String[] column = { "CO_SSN", "FIRST", "MINIT", "LAST", "OCCUPATION", "CREDIT_SCORE", "GMI",
                        "RECENT_EMPLOYER",
                        "LICENSE_NUM", "PAYMENT_TYPE", "CUSTOMER_SSN" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT* FROM rkraft3db.DBP_COSIGNER ORDER BY CREDIT_SCORE DESC;",
                        "DBP_COSIGNER", column);
                query.query();
            }
            // sales rep car sales high-low
            if (selectQuery.getSelectedItem().equals("Sales representative car sales (highest to lowest)")) {
                String[] column = { "SR_SSN", "NO_CAR_SALES", "COMMISSION" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT* FROM rkraft3db.DBP_SALES_REP ORDER BY NO_CAR_SALES DESC;",
                        "DBP_SALES_REP", column);
                query.query();
            }
            // sales man avr salary
            if (selectQuery.getSelectedItem().equals("Average salary of sales manager")) {
                String[] column = { "SALARY" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT AVG(SALARY) FROM rkraft3db.DBP_EMPLOYEE;",
                        "DBP_EMPLOYEE", column);
                query.query();
            }
            // used car mpg high-low
            if (selectQuery.getSelectedItem().equals("Used Car MPG (highest to lowest)")) {
                String[] column = { "VIN", "NUM_DOORS", "COLOR", "NUM_SEATS", "ENGINE_TYPE", "NUM_MILES", "MPG",
                        "TIRE_TYPE",
                        "MSRP", "YEAR", "MAKE", "MODEL", "STATUS" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT* FROM rkraft3db.DBP_CAR WHERE VIN IN (SELECT USED_VIN FROM rkraft3db.DBP_USED_CAR) ORDER BY MPG DESC;",
                        "DBP_CAR", column);
                query.query();
            }
            // new car mpg high-low
            if (selectQuery.getSelectedItem().equals("New Car MPG (highest to lowest)")) {
                String[] column = { "VIN", "NUM_DOORS", "COLOR", "NUM_SEATS", "ENGINE_TYPE", "NUM_MILES", "MPG",
                        "TIRE_TYPE",
                        "MSRP", "YEAR", "MAKE", "MODEL", "STATUS" };
                SqlObject query = new SqlObject(frame, main,
                        "SELECT* FROM rkraft3db.DBP_CAR WHERE VIN IN (SELECT NEW_VIN FROM rkraft3db.DBP_NEW_CAR) ORDER BY MPG DESC;",
                        "DBP_CAR", column);
                query.query();
            }

        }
    }

}
