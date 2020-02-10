package Lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static JTextField displayField;
    private static JFrame frame;
    private static JPanel panel1;
    private static GridBagLayout layout;
    private static GridBagConstraints constr;
    private static ActionListener actionListener;
    private static ImageIcon icon = new ImageIcon("src/Lesson6/images/calculator.png");

    private static JButton buttonZero;
    private static JButton buttonOne;
    private static JButton buttonTwo;
    private static JButton buttonThree;
    private static JButton buttonFour;
    private static JButton buttonFive;
    private static JButton buttonSix;
    private static JButton buttonSeven;
    private static JButton buttonEight;
    private static JButton buttonNine;
    private static JButton buttonPlus;
    private static JButton buttonMinus;
    private static JButton buttonMulti;
    private static JButton buttonDivision;
    private static JButton buttonDegree;
    private static JButton buttonEqual;
    private static JButton buttonDot;
    private static JButton buttonDel;



    public void setDisplayValue(String val) {
        displayField.setText(val);
    }

    public String getDisplayValue() {
        return displayField.getText();
    }

    public static void createFrame() {

        frame = new JFrame("Calculator");
        frame.setIconImage(icon.getImage());
        frame.setSize(300, 350);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        panel1 = new JPanel();

        layout = new GridBagLayout();
        panel1.setLayout(layout);

        constr = new GridBagConstraints();
        constr.gridx=0;
        constr.gridy=0;
        constr.gridheight = 1;
        constr.gridwidth = 4;
        constr.fill= constr.BOTH;
        constr.weightx = 1.0;
        constr.weighty = 1.0;
        constr.anchor=constr.CENTER;
        displayField = new JTextField();
        layout.setConstraints(displayField,constr);
        panel1.add(displayField);



        /*buttonSeven = createButton("7", 0, 1, 1);
        buttonEight = createButton("8", 1, 1, 1);
        buttonNine = createButton("9", 2, 1, 1);
        buttonPlus = createButton("+", 3, 1, 1);

        buttonFour = createButton("4", 0, 2, 1);
        buttonFive = createButton("5", 1, 2, 1);
        buttonSix = createButton("6", 2, 2, 1);
        buttonMinus = createButton("-", 3, 2, 1);

        buttonOne = createButton("1", 0, 3, 1);
        buttonTwo = createButton("2", 1, 3, 1);
        buttonThree = createButton("3", 2, 3, 1);
        buttonMulti = createButton("*", 3, 3, 1);

        buttonDot = createButton(".", 0, 4, 1);
        buttonZero = createButton("0", 1, 4, 1);
        buttonDegree = createButton("^", 2, 4, 1);
        buttonDivision = createButton("/", 3, 4, 1);

        buttonEqual = createButton("=", 2, 5, 2);
        buttonDel = createButton("C", 0, 5,2);

        buttonSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    displayField.setText(displayField.getText() + "7");
            }
        });

        buttonEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + "8");
            }
        });

        buttonNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + "9");
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + " + ");
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + " - ");
            }
        });

        buttonMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + " * ");
            }
        });

        buttonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + " / ");
            }
        });

        buttonDegree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + " ^ ");
            }
        });

        buttonFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + "4");
            }
        });

        buttonFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + "5");
            }
        });

        buttonSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + "6");
            }
        });

        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + "1");
            }
        });

        buttonTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + "2");
            }
        });

        buttonThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + "3");
            }
        });

        buttonZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + "0");
            }
        });

        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(displayField.getText() + ".");
            }
        });

        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText("");
            }
        });

        panel1.add(displayField);
        panel1.add(buttonPlus);
        panel1.add(buttonSeven);
        panel1.add(buttonEight);
        panel1.add(buttonNine);
        panel1.add(buttonFour);
        panel1.add(buttonFive);
        panel1.add(buttonSix);
        panel1.add(buttonMinus);
        panel1.add(buttonOne);
        panel1.add(buttonTwo);
        panel1.add(buttonThree);
        panel1.add(buttonMulti);
        panel1.add(buttonDot);
        panel1.add(buttonZero);
        panel1.add(buttonDegree);
        panel1.add(buttonDivision);
        panel1.add(buttonEqual);
        panel1.add(buttonDel);*/
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

                btn.setActionCommand("" + buttons[counter]);
                btn.addActionListener(actionListener);
                panel1.add(btn);
                counter++;
            }

        }



        frame.add(panel1);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    private static JButton createButton(String text, int coordX, int coordY, int width) {
        JButton button = new JButton();
        button.setText(text);

        constr.gridx=coordX;
        constr.gridy=coordY;
        constr.gridheight = 1;
        constr.gridwidth = width;
        constr.fill = constr.BOTH;
        constr.weightx = 1.0;
        constr.weighty = 1.0;
        constr.anchor = constr.CENTER;
        layout.setConstraints(button, constr);
        button.addActionListener(actionListener);

        return button;
    }
}
