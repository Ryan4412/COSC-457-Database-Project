import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InsertPanel implements ActionListener {
    JLabel prompt = new JLabel();
    JPanel panel = new JPanel();
    JPanel main;
    GUI frame;
    JComboBox select;
    String[] selectable = { "Appointment", "Car", "Cosigner", "Customer",
            "Employee", "Finance Manager", "Janator", "New Car",
            "Receptionist", "Report", "Sale", "Sales Manager",
            "Sales Rep", "Used Car", "Used Car History" };

    public InsertPanel() {
        select = new JComboBox<>(selectable);
        select.addActionListener(this);
        prompt.setText("Please Select which data you would like to insert using the drop down menu");
        panel.add(prompt);
        panel.add(select);
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
                appointment.sendMain(main, frame);
            }
            if (select.getSelectedItem().equals("Car")) {
                CarPanel car = new CarPanel();
                car.sendMain(main, frame);
            }
            if (select.getSelectedItem().equals("Cosigner")) {
                CosignerPanel cosigner = new CosignerPanel();
                cosigner.sendMain(main, frame);
            }
            if (select.getSelectedItem().equals("Customer")) {
                CustomerPanel customer = new CustomerPanel();
                customer.sendMain(main, frame);
            }
            if (select.getSelectedItem().equals("Employee")) {
                EmployeePanel employee = new EmployeePanel();
                employee.sendMain(main, frame);
            }
            if (select.getSelectedItem().equals("Finance Manager")) {
                FinancemanagerPanel financemanager = new FinancemanagerPanel();
                financemanager.sendMain(main, frame);
            }
            if (select.getSelectedItem().equals("Janator")) {
                JanatorPanel janator = new JanatorPanel();
                janator.sendMain(main, frame);
            }
            if (select.getSelectedItem().equals("New Car")) {
                NewcarPanel newcar = new NewcarPanel();
                newcar.sendMain(main, frame);
            }
        }
    }

}
