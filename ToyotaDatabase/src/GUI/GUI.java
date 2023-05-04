import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    JButton insert = new JButton();
    JButton delete = new JButton();
    JButton query = new JButton();
    JPanel main = new JPanel();

    public GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900, 800);
        this.setTitle("Sheehy Toyota of Laurel Database");
        this.setVisible(true);
        this.setResizable(false);
        // insert button settup
        insert.addActionListener(this);
        insert.setText("Insert");
        insert.setHorizontalTextPosition(JButton.CENTER);
        insert.setBounds(200, 150, 100, 100);
        insert.setFocusable(false);
        insert.setVisible(true);
        this.add(insert);
        // delete button setup
        delete.addActionListener(this);
        delete.setText("Delete");
        delete.setHorizontalTextPosition(JButton.CENTER);
        delete.setBounds(400, 150, 100, 100);
        delete.setFocusable(false);
        delete.setVisible(true);
        this.add(delete);
        // query button setup
        query.addActionListener(this);
        query.setText("Query");
        query.setHorizontalTextPosition(JButton.CENTER);
        query.setBounds(600, 150, 100, 100);
        query.setFocusable(false);
        query.setVisible(true);
        this.add(query);
        // main JPanel to disply actions
        main.setVisible(true);
        main.setLayout(new BorderLayout());
        main.setBackground(new Color(200, 200, 200));
        main.setBounds(200, 300, 500, 400);
        this.add(main);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insert) {
            insert();
        }
    }

    public void insert() {
        InsertPanel insertPanel = new InsertPanel();
        insertPanel.sendMain(main, this);
    }

    public void setMain() {
        main.removeAll();
        main.revalidate();
        main.repaint();
    }

}