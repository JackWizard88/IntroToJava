package Lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainFrame extends JFrame {
    private static JTextField displayField;             //text Field of the calc on the panel
    private static JTextField bufferField;              //text buffer
    private static GridBagLayout layout;                //layout
    private static GridBagConstraints constr;           //constrains
    private static final Calculation calc = new Calculation();    //creating an instance of Calculation
    private static final ImageIcon icon = new ImageIcon(Objects.requireNonNull(MainFrame.class.getResource("calculator.png"))); //Icon for Panels
    private static final Font font1 = new Font("Courier new", Font.ITALIC,40);  //text font
    private static final Color FONT_COLOR = new Color(60, 255, 16);               //font color
    private static final Color RED_BUTTON = new Color(150, 50, 50);                // "C" button color
    private static final Color BACKGROUND_COLOR = new Color(50, 50, 50);           //background color
    private static final Color BACKGROUND_PANEL_COLOR = new Color(30, 30, 30);           //background color for displays
    private static final Color BUFFER_STRING_COLOR = new Color(33, 150, 20);      // Buffer string font color
    private static final Color EQUAL_BUTTON = new Color(16, 120, 218, 255);

    //overriding ActionListener ( 1 for all buttons )
    private static final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String command = button.getActionCommand();
            System.out.println(command);  //console information


            if (command.equals("C")) {  //clear all fields and parameters
                calc.setA("");
                calc.setOperation("");
                calc.setB("");
                displayField.setText("");
                bufferField.setText("");
            } else if (command.equals("CE")) {
                displayField.setText("");
            } else if (command.equals("+/-") && !displayField.getText().isEmpty()) {
                if (!displayField.getText().isEmpty()) {
                    double temp = -1 * Double.parseDouble(displayField.getText());
                    if (temp % 1 == 0) displayField.setText("" + (int) temp);
                    else displayField.setText("" + temp);
                }
            } else if (command.equals("=") && !displayField.getText().isEmpty()) {
                if(!calc.getA().isEmpty() && !calc.getB().isEmpty() && !calc.getOperation().isEmpty()) {
                    calc.calculate();
                    displayField.setText(calc.getResult());
                    calc.setOperation("");
                    calc.setA("");
                    bufferField.setText(bufferField.getText() + " " + calc.getB() + " =");
                }
            } else if ((command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/") || command.equals("x^y")) && !displayField.getText().isEmpty()) {
                calc.setA(displayField.getText());
                displayField.setText("");
                calc.setOperation(command);
                bufferField.setText(calc.getA()+ " " + calc.getOperation());
            } else if (calc.getA().isEmpty() && calc.getOperation().isEmpty() && calc.getResult().equals(displayField.getText())) {
                bufferField.setText("");
                displayField.setText(command);
            } else if (calc.getA().isEmpty() && calc.getOperation().isEmpty() && displayField.getText().matches("[0-9]")) {
                displayField.setText(displayField.getText() + command);
            } else if (!(calc.getA().isEmpty() && !calc.getOperation().isEmpty())) {
                displayField.setText(displayField.getText() + command);
                calc.setB(displayField.getText());
            }
        }

    };

    //creating the MainFrame
    public static void createFrame() {

        JFrame frame = new JFrame("Calculator");
        frame.setIconImage(icon.getImage());
        frame.setSize(400, 500);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //creating Panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(BACKGROUND_COLOR);
        panel1.setForeground(FONT_COLOR);

        layout = new GridBagLayout();
        panel1.setLayout(layout);

        //creating buffer field
        constr = new GridBagConstraints();
        constr.gridx=2;
        constr.gridy=0;
        constr.gridheight = 1;
        constr.gridwidth = 2;
        constr.ipady = 10;
        constr.ipadx = 330;
        constr.weightx = 1.0;
        constr.weighty = 1.0;
        constr.anchor= GridBagConstraints.EAST;
        bufferField = new JTextField();
        Insets insets = bufferField.getInsets();
        bufferField.setBorder(BorderFactory.createEmptyBorder(insets.top, insets.left, insets.bottom, 20));
        bufferField.setFont(new Font("Courier new", Font.BOLD, 16));
        bufferField.setHorizontalAlignment(JTextField.RIGHT);
        bufferField.setBackground(BACKGROUND_PANEL_COLOR);
        bufferField.setForeground(BUFFER_STRING_COLOR);
        bufferField.setFocusable(false);
        layout.setConstraints(bufferField,constr);
        panel1.add(bufferField);

        //creating text field
        constr = new GridBagConstraints();
        constr.gridx=0;
        constr.gridy=1;
        constr.gridheight = 1;
        constr.gridwidth = 4;
        constr.ipady = 10;
        constr.ipadx = 330;
        constr.weightx = 1.0;
        constr.weighty = 1.0;
        constr.anchor= GridBagConstraints.EAST;
        displayField = new JTextField();
        displayField.setBorder(BorderFactory.createEmptyBorder(insets.top, insets.left, insets.bottom, 20));
        displayField.setFont(font1);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFocusable(false);
        displayField.setBackground(BACKGROUND_PANEL_COLOR);
        displayField.setForeground(FONT_COLOR);
        layout.setConstraints(displayField,constr);
        panel1.add(displayField);

        //creating buttons
        String[] buttons = {"7", "8", "9", "*", "4", "5", "6", "/", "1", "2", "3", "-", ".", "0", "x^y", "+", "C", "CE", "+/-", "="};
        int counter =0;

        for (int i=2; i < 7; i++){
            for (int j = 0; j< 4; j++) {

                JButton btn = createButton(buttons[counter], j, i);

                btn.setActionCommand(buttons[counter]);
                btn.addActionListener(actionListener);
                panel1.add(btn);
                counter++;
            }
        }

        //adding panel with textField and buttons on the Main Frame
        frame.add(panel1);
        frame.setResizable(false);  //forbid resizing the Frame
        frame.setVisible(true);     //make it all visible
    }

    //create Buttons Method
    private static JButton createButton(String text, int coordX, int coordY) {
        JButton button = new JButton();
        button.setText(text);
        button.setBackground(BACKGROUND_COLOR);
        button.setForeground(BUFFER_STRING_COLOR);
        button.setFont(new Font("Courier new", Font.BOLD, 20));
        button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, BUFFER_STRING_COLOR));

        //if "C" -  make RED button with WHITE borders
        if (text.equals("C")) {
            button.setBackground(RED_BUTTON);
            button.setForeground(Color.WHITE);
        } else if (text.equals("CE")) {
            button.setForeground(Color.WHITE);
        } else if (text.equals("=")) {
            button.setBackground(EQUAL_BUTTON);
            button.setForeground(Color.WHITE);
        }

        constr.gridx=coordX;
        constr.gridy=coordY;
        constr.insets= new Insets(1, 1, 1, 1);
        constr.gridheight = 1;
        constr.gridwidth = 1;
        constr.fill = GridBagConstraints.BOTH;
        constr.weightx = 1.0;
        constr.weighty = 1.0;
        constr.anchor = GridBagConstraints.CENTER;
        layout.setConstraints(button, constr);

        return button;
    }
}
