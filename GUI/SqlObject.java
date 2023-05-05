import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.Clock;
import java.time.ZoneId;
import java.util.ArrayList;

public class SqlObject {

    GUI frame;
    JPanel main;
    String sql;
    String table;
    Connection con;
    JScrollPane scroll;
    JTable jTable;
    String[] column;

    public SqlObject(GUI frame, JPanel main, String sql, String table, String[] column) {
        this.frame = frame;
        this.main = main;
        this.sql = sql;
        this.table = table;
        this.column = column;
        con = this.frame.getCon();
    }

    public void updateQuery() {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("SELECT * FROM rkraft3db." + table);
            ArrayList<ArrayList> print = new ArrayList<ArrayList>();
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<String>();
                try {
                    int columnIndex = 1;
                    while (true) {
                        row.add(rs.getString(columnIndex));
                        columnIndex++;
                    }
                } catch (SQLException e) {
                    print.add(row);
                }
            }
            displayTable(print);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void displayTable(ArrayList<ArrayList> print) {
        String[][] row = new String[print.size()][print.get(0).size()];
        for (int i = 0; i < print.size(); i++) {
            for (int j = 0; j < print.get(0).size(); j++) {
                row[i][j] = (String) print.get(i).get(j);
            }
        }
        JTable jt = new JTable(row, column);
        jt.setBounds(0, 0, 200, 1000);
        // JScrollPane sp = new JScrollPane(jt);
        // added
        JScrollPane sp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        main.removeAll();
        main.add(sp);
        main.revalidate();
        main.repaint();

    }

}
