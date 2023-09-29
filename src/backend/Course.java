package backend;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Course {

    private JLabel code;
    private JLabel name;
    private JLabel costLabel;
    private short cost;
    private JCheckBox checkBox;
    public static short attendanceCost = 0;


    public Course(String code, String name, short cost, JPanel panel) {
        this.checkBox = new JCheckBox();
        this.checkBox.setFocusable(false);
        this.checkBox.setOpaque(false);
        this.checkBox.addActionListener(new EnrollScreenHandler(panel, this));

        this.code = new JLabel(code);
        this.code.setFont(new Font("arial", Font.ITALIC, 20));;
        this.code.setBackground(Color.lightGray);
        this.code.setOpaque(true);

        this.name = new JLabel(name);
        this.name.setFont(new Font("arial", Font.PLAIN, 20));;
        this.name.setBackground(Color.lightGray);
        this.name.setOpaque(true);

        this.cost = cost;
        this.costLabel = new JLabel("$" + String.valueOf(cost));
        this.costLabel.setFont(new Font("arial", Font.PLAIN, 20));;
        this.costLabel.setBackground(Color.lightGray);
        this.costLabel.setOpaque(true);
    }

    public JCheckBox GetCheckBox() { return checkBox; }
    public JLabel GetCode() { return code; }
    public JLabel GetName() { return name; }
    public JLabel GetCostLabel() { return costLabel; }
    public short GetCost() { return cost; }

}
