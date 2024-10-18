package Lesson6;

public class CalculatorMain {
    public static void main(String[] args) {

        //Main class starts everything
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame.createFrame();
            }
        });

    }
}
