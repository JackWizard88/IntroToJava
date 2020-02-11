package Lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static JTextField displayField;             //text Field of the calc on the panel
    private static JTextField bufferField;              //text buffer
    private static GridBagLayout layout;                //layout
    private static GridBagConstraints constr;           //constrains
    private static Calculation calc = new Calculation();    //creating an instance of Calculation


    private static ImageIcon icon = new ImageIcon(MainFrame.class.getResource("calculator.png")); //Icon for Panels
    private static Font font1 = new Font("Courier new", Font.ITALIC,40);
    private static Color fontColor = new Color(255, 150, 16);
    private static Color BackgroundColor = new Color(50, 50, 50);

    //overriding ActionListener ( 1 for all buttons )   the most complicated part which took 2 hours
    private static ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String command = button.getActionCommand();
            System.out.println(command);

            if (!(displayField.getText().contains(".") && command.equals("."))) {

                if (!displayField.getText().equals("") && command.equals("+/-")) {
                    double temp = -1*Double.parseDouble(displayField.getText());
                    if (temp % 1 == 0) displayField.setText("" + (int) temp);
                    else displayField.setText("" + temp);
                } else {
                    if (command.equals("C")) {
                        calc.setA("");
                        calc.setOperation("");
                        calc.setB("");
                        displayField.setText("");
                        bufferField.setText("");
                    }
                    else if (command.equals("=")) {
                        if(!calc.getA().equals("") && !calc.getB().equals("") && !calc.getOperation().equals("")) {
                            calc.calculate();
                            displayField.setText(calc.getResult());
                            calc.setOperation("");
                            calc.setA("");
                            bufferField.setText(bufferField.getText() + " " + calc.getB() + " =");
                        }
                    }
                    else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/") || command.equals("x^y")) {
                        calc.setA(displayField.getText());
                        displayField.setText("");
                        calc.setOperation(command);
                        bufferField.setText(calc.getA()+ " " + calc.getOperation());
                    }
                    else if (calc.getA().equals("") && calc.getOperation().equals("") && calc.getResult().equals(displayField.getText())) {
                        displayField.setText(command);
                    }
                    else if (calc.getA().equals("") && calc.getOperation().equals("")) {
                        displayField.setText(displayField.getText() + command);
                    }

                    else if (!(calc.getA().equals("") && !calc.getOperation().equals(""))) {
                        displayField.setText(displayField.getText() + command);
                        calc.setB(displayField.getText());

                    }
                }
            }
        }
    };

    //creating the MainFrame
    public static void createFrame() {

        JFrame frame = new JFrame("Calculator");
        frame.setIconImage(icon.getImage());
        frame.setSize(350, 400);
        //frame.setMaximumSize(new Dimension(400, 550));
        //frame.setMinimumSize(new Dimension(200, 300));
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //creating Panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(BackgroundColor);
        panel1.setForeground(fontColor);

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
        bufferField.setBackground(BackgroundColor);
        bufferField.setForeground(new Color(150, 100, 20));
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
        displayField.setBackground(BackgroundColor);
        displayField.setForeground(fontColor);
        layout.setConstraints(displayField,constr);
        panel1.add(displayField);


        //creating buttons
        String[] buttons = {"7", "8", "9", "*", "4", "5", "6", "/", "1", "2", "3", "-", ".", "0", "x^y", "+", "C", "+/-", "=", ""};
        int counter =0, width;

        for (int i=2; i < 7; i++){
            for (int j = 0; j< 4; j++) {
                JButton btn;

                if (buttons[counter].equals("")) break;

                if (buttons[counter].equals("=") ) width = 2;
                else width = 1;


                if (buttons[counter].equals("=")) {
                    btn = createButton(buttons[counter], j, i, width);
                }
                else {
                    btn = createButton(buttons[counter], j, i, width);
                }


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
    private static JButton createButton(String text, int coordX, int coordY, int width) {
        JButton button = new JButton();
        button.setText(text);
        button.setBackground(BackgroundColor);
        button.setForeground(fontColor);
        button.setFont(new Font("Courier new", Font.BOLD, 20));
        button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, fontColor));
        if (text.equals("C")) {
            button.setBackground(new Color(150,50,50));
            //button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            button.setForeground(Color.WHITE);
        }

        constr.gridx=coordX;
        constr.gridy=coordY;
        constr.insets= new Insets(1, 1, 1, 1);
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
