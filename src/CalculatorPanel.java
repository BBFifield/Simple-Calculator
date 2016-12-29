import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

/**
 * Created by Brandon on 2016-11-16.
 */
public class CalculatorPanel extends JPanel {

    private JTextField numberField;
    private JButton[] buttons;

    public CalculatorPanel() {
        setPreferredSize(new Dimension(400, 400));
        setLayout(new BorderLayout());
        createTextField();
        createButtonPanel();
    }

    public void createTextField() {
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setPreferredSize(new Dimension(400, 100));

        numberField = new JTextField("0", 12);
        numberField.setFont(new Font("Serif", Font.PLAIN, 40));
        textFieldPanel.add(numberField);

        add(textFieldPanel, BorderLayout.NORTH);
    }

    public void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(400, 250));
        buttonPanel.setLayout(new GridLayout(4, 5, 10, 10));

        //Construct an array of buttons to use as the numbered buttons on a calculator. Then use a for-loop
        //to iterate over the array and initialize each button object.
        buttons = new JButton[20];

        //Construct an array of buttons and initialize them individually, and set the style of their labels.
        buttons[0] = new JButton("7");
        buttons[0].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[1] = new JButton("8");
        buttons[1].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[2] = new JButton("9");
        buttons[2].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[3] = new JButton("+-");
        buttons[3].setFont(new Font("Serif", Font.PLAIN, 17));
        buttons[4] = new JButton("AC");
        buttons[4].setFont(new Font("Serif", Font.PLAIN, 17));
        buttons[5] = new JButton("4");
        buttons[5].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[6] = new JButton("5");
        buttons[6].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[7] = new JButton("6");
        buttons[7].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[8] = new JButton("X");
        buttons[8].setFont(new Font("Serif", Font.PLAIN, 17));
        buttons[9] = new JButton("/");
        buttons[9].setFont(new Font("Serif", Font.PLAIN, 17));
        buttons[10] = new JButton("1");
        buttons[10].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[11] = new JButton("2");
        buttons[11].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[12] = new JButton("3");
        buttons[12].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[13] = new JButton("+");
        buttons[13].setFont(new Font("Serif", Font.PLAIN, 17));
        buttons[14] = new JButton("-");
        buttons[14].setFont(new Font("Serif", Font.PLAIN, 17));
        buttons[15] = new JButton("0");
        buttons[15].setFont(new Font("Serif", Font.PLAIN, 20));
        buttons[16] = new JButton(".");
        buttons[16].setFont(new Font("Serif", Font.PLAIN, 17));
        buttons[17] = new JButton("=");
        buttons[17].setFont(new Font("Serif", Font.PLAIN, 17));
        buttons[18] = new JButton("^");
        buttons[18].setFont(new Font("Serif", Font.PLAIN, 17));
        buttons[19] = new JButton("√");
        buttons[19].setFont(new Font("Serif", Font.PLAIN, 17));

        for(JButton button: buttons) {
            ButtonListener buttonListener = new ButtonListener();
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }
        //Add buttonPanel to south border of Calculator Panel according to border layout.
        add(buttonPanel, BorderLayout.SOUTH);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for(JButton button: buttons) {
                if(button == event.getSource()) {
                    String buttonText = button.getText();
                    numberField.setText(numberField.getText() + buttonText);
                    try {
                        SerialCommunicator.output.write(buttonText.getBytes());
                    }
                    catch(IOException e) { e.printStackTrace(); }
                }
            }

        }
    }

}