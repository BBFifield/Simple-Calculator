import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;

/**
 * Created by Brandon on 2016-11-16.
 */
public class CalculatorPanel extends JPanel {

    private JTextField numberField;

    private JButton[] numberButtons;
    private JButton[] operatorButtons;


    public CalculatorPanel() {
        setPreferredSize(new Dimension(400,400));
        setLayout(new BorderLayout());

        createTextField();
        createButtonPanel();
    }

    public void createTextField() {
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setPreferredSize(new Dimension(400,100));

        numberField = new JTextField("0",12);
        numberField.setFont(new Font("Serif",Font.PLAIN,40));
        textFieldPanel.add(numberField);

        add(textFieldPanel, BorderLayout.NORTH);
    }

    public void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(400,250));
        buttonPanel.setLayout(new GridLayout(4,5,10,10));

        //Construct an array of buttons to use as the numbered buttons on a calculator. Then use a for-loop
        //to iterate over the array and initialize each button object.
        numberButtons = new JButton[10];
        for(int i = 9; i >= 0; i--) {
            numberButtons[i] = new JButton("" + i);
            numberButtons[i].setFont(new Font("Serif",Font.PLAIN,20));
        }

        //Construct an array of operator buttons and initialize them individually.
        operatorButtons = new JButton[10];
        operatorButtons[0] = new JButton(".");
        operatorButtons[1] = new JButton("=");
        operatorButtons[2] = new JButton("+-");
        operatorButtons[3] = new JButton("AC");
        operatorButtons[4] = new JButton("X");
        operatorButtons[5] = new JButton("/");
        operatorButtons[6] = new JButton("+");
        operatorButtons[7] = new JButton("-");
        operatorButtons[8] = new JButton("^");
        operatorButtons[9] = new JButton("√");

        //Set font style of button labels.
        for(JButton button: operatorButtons) button.setFont(new Font("Serif",Font.PLAIN,17));

        //Row1
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(operatorButtons[2]);
        buttonPanel.add(operatorButtons[3]);
        //Row2
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(operatorButtons[4]);
        buttonPanel.add(operatorButtons[5]);
        //Row3
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(operatorButtons[6]);
        buttonPanel.add(operatorButtons[7]);
        //Row4
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(operatorButtons[0]);
        buttonPanel.add(operatorButtons[1]);
        buttonPanel.add(operatorButtons[8]);
        buttonPanel.add(operatorButtons[9]);

        add(buttonPanel, BorderLayout.SOUTH);


    }


}
