import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class phonegui implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();

    JLabel l1 = new JLabel("Name:");
    JLabel l2 = new JLabel("City:");
    JLabel l3 = new JLabel("Phone");
    JButton insert = new JButton("insert");
    JButton reset = new JButton("reset");

    JTable table;
    DefaultTableModel model;

    void renderform() {
        t1.setBounds(40, 10, 200, 50);
        t2.setBounds(40, 50, 200, 50);
        t3.setBounds(40, 100, 200, 50);
        l1.setBounds(2, 10, 200, 50);
        l2.setBounds(2, 50, 200, 50);
        l3.setBounds(2, 100, 200, 50);
        insert.setBounds(50, 150, 100, 30);
        reset.setBounds(150, 150, 100, 30);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        insert.setFocusable(false);
        reset.setFocusable(false);
        frame.add(insert);
        frame.add(reset);
    }

    void rendertable() {
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("Phone");

        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 250, 270, 170);
        frame.add(sp);
    }

    void render() {
        renderform();
        rendertable();
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setTitle("PhoneBook");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        insert.addActionListener(this);
        reset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insert) {
            String name = t1.getText();
            String city = t2.getText();
            String phone = t3.getText();
            if (name.trim().equals("") || city.trim().equals("") || phone.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter all fields!");
            } else {
                Object[] data = {name, city, phone};
                model.addRow(data);
                t1.setText("");
                t2.setText("");
                t3.setText("");
            }
        } else if (e.getSource() == reset) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
    }
}
