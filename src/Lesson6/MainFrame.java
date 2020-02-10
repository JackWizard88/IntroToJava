package Lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static JTextField displayField;             //text Field of the calc on the panel
    private static GridBagLayout layout;                //layout
    private static GridBagConstraints constr;           //constrains
    private static Calculation calc = new Calculation();    //creating an instance of Calculation
    private static ImageIcon icon = new ImageIcon("src/Lesson6/images/calculator.png"); //Icon for Panels

    //overriding ActionListener ( 1 for all buttons )   the most complicated part which took 2 hours
    private static ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String command = button.getActionCommand();
            System.out.println(command);

            if (!(displayField.getText().contains(".") && command.equals("."))) {
                if (command.equals("C")) {
                    calc.setA("");
                    calc.setOperation("");
                    calc.setB("");
                    displayField.setText("");
                }
                else if (command.equals("=")) {
                    if(!calc.getA().equals("") && !calc.getB().equals("") && !calc.getOperation().equals("")) {
                        calc.calculate();
                        displayField.setText(calc.getResult());
                        calc.setOperation("");
                        calc.setA("");
                    }
                }
                else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/") || command.equals("^")) {
                    calc.setA(displayField.getText());
                    displayField.setText("");
                    calc.setOperation(command);
                }
                else if (calc.getA().equals("") && calc.getOperation().equals("") && !calc.getResult().equals("")) {
                    displayField.setText(command);
                }
                else if (calc.getA().equals("") && calc.getOperation().equals("") && calc.getResult().equals("")) {
                    displayField.setText(displayField.getText() + command);
                }

                else if (!(calc.getA().equals("") && calc.getOperation().equals(""))) {
                    displayField.setText(displayField.getText() + command);
                    calc.setB(displayField.getText());

                }
            }
        }
    };

    //creating the MainFrame
    public static void createFrame() {

        JFrame frame = new JFrame("Calculator");
        frame.setIconImage(icon.getImage());
        frame.setSize(300, 350);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //creating Panel
        JPanel panel1 = new JPanel();

        layout = new GridBagLayout();
        panel1.setLayout(layout);

        //creating text field
        constr = new GridBagConstraints();
        constr.gridx=0;
        constr.gridy=0;
        constr.gridheight = 1;
        constr.gridwidth = 4;
        constr.fill= GridBagConstraints.BOTH;
        constr.weightx = 1.0;
        constr.weighty = 1.0;
        constr.anchor= GridBagConstraints.CENTER;
        displayField = new JTextField();
        Font font = new Font("Arial", Font.BOLD,24);
        displayField.setFont(font);
        layout.setConstraints(displayField,constr);
        panel1.add(displayField);


        //creating buttons
        String[] buttons = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ".", "0", "^", "/", "C", "=", "", ""};
        int counter =0, width;

        for (int i=1; i < 6; i++){
            for (int j = 0; j< 4; j++) {
                JButton btn;

                if (buttons[counter].equals("C") || buttons[counter].equals("=") ) width = 2;
                else width = 1;
                if (buttons[counter].equals("")) break;

                if (buttons[counter].equals("=")) {
                    btn = createButton(buttons[counter], j+1, i, width);
                }
                else {
                    btn = createButton(buttons[counter], j, i, width);
                }

                btn.setFont(font);
                btn.setActionCommand(buttons[counter]);
                btn.addActionListener(actionListener);
                panel1.add(btn);
                counter++;
            }

        }

        //adding panel with textfield and buttons on the Main Frame
        frame.add(panel1);
        frame.setResizable(false);  //forbid resizing of the Frame
        frame.setVisible(true);     //make it all visible
    }

    //create Buttons Method
    private static JButton createButton(String text, int coordX, int coordY, int width) {
        JButton button = new JButton();
        button.setText(text);

        constr.gridx=coordX;
        constr.gridy=coordY;
        constr.gridheight = 1;
        constr.gridwidth = width;
        constr.fill = GridBagConstraints.BOTH;
        constr.weightx = 1.0;
        constr.weighty = 1.0;
        constr.anchor = GridBagConstraints.CENTER;
        layout.setConstraints(button, constr);


        return button;
    }
}
