import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.Clock;
import java.time.ZoneId;

public class GUI extends JFrame implements ActionListener {

    // GUI elements
    JButton insert = new JButton();
    JButton delete = new JButton();
    JButton query = new JButton();
    JPanel main = new JPanel();
    // Conection Object
    Connection con;

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
        // conection setup
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        final String ID = "rkraft3";
        final String PW = "COSC*54rac";
        final String SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/rkraft3db?useSSL=false";
        try {
            con = DriverManager.getConnection(SERVER, ID, PW);
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insert) {
            insert();
        }
        if (e.getSource() == delete) {
            delete();
        }
    }

    public void insert() {
        InsertPanel insertPanel = new InsertPanel();
        insertPanel.sendMain(main, this);
    }

    public void delete() {
        DeletePanel deletePanel = new DeletePanel();
        deletePanel.sendMain(main, this);
    }

    public void setMain() {
        main.removeAll();
        main.revalidate();
        main.repaint();
    }

    public Connection getCon() {
        return con;
    }

}