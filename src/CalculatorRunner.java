import javax.swing.JFrame;

/**
 * Created by Brandon on 2016-11-16.
 */
public class CalculatorRunner {

    public static void main(String[] args) {
        SerialCommunicator.setUp();
        JFrame calculatorWindow = new JFrame();
        calculatorWindow.setSize(400,400);
        calculatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalculatorPanel topPanel = new CalculatorPanel();
        calculatorWindow.add(topPanel);
        calculatorWindow.setVisible(true);


    }
}
