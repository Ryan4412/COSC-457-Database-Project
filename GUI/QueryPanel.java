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
    String[] selectableQueries = { "Highest", "Average", "Who purchased what", "Who sold who"};

    public QueryPanel() {
        select = new JComboBox<>(selectable);
        select.addActionListener(this);
        prompt.setText("Please select which data you would like to query using the drop down menu");
        selectQuery = new JComboBox<>(selectableQueries);
        queryPrompt.setText("Other queries");
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
                appointment.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Car")) {
                CarPanel car = new CarPanel();
                car.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Cosigner")) {
                CosignerPanel cosigner = new CosignerPanel();
                cosigner.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Customer")) {
                CustomerPanel customer = new CustomerPanel();
                customer.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Employee")) {
                EmployeePanel employee = new EmployeePanel();
                employee.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Finance Manager")) {
                FinancemanagerPanel financemanager = new FinancemanagerPanel();
                financemanager.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Janator")) {
                JanatorPanel janator = new JanatorPanel();
                janator.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("New Car")) {
                NewcarPanel newcar = new NewcarPanel();
                newcar.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Receptionist")) {
                ReceptionistPanel receptionist = new ReceptionistPanel();
                receptionist.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Report")) {
                ReportPanel report = new ReportPanel();
                report.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Sale")) {
                SalePanel sale = new SalePanel();
                sale.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Sales Manager")) {
                SalesmanagerPanel salesmanager = new SalesmanagerPanel();
                salesmanager.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Sales Rep")) {
                SalesrepresentativePanel salesrepresentative = new SalesrepresentativePanel();
                salesrepresentative.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Used Car")) {
                UsedcarPanel usedcar = new UsedcarPanel();
                usedcar.sendMain(main, frame, false, true);
            }
            if (select.getSelectedItem().equals("Used Car History")) {
                UsedcarhistoryPanel usedcarhistory = new UsedcarhistoryPanel();
                usedcarhistory.sendMain(main, frame, false, true);
            }
        }
        // if (e.getSource() == selectQuery) {
        //     if (selectQuery.getSelectedItem().equals("Highest")) {
                
        //     }
        //     if (selectQuery.getSelectedItem().equals("Average")) {
                
        //     }
        //     if (selectQuery.getSelectedItem().equals("Who purchased what")) {

        //     }
        //     if (selectQuery.getSelectedItem().equals("Who sold who")) {

        //     }
        // }
    }

}
