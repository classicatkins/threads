//tutored by Harold Atkins
//Resources: https://stackoverflow.com/questions/15314205/using-gettext-to-get-an-integer

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class GreetingThreadRunner   
{
    int repition = 0;
    int delay = 0;
    public static void main(String[] args) 
    {
        //creates label, buttons etc
        JLabel threadsLabel = new JLabel("Number of Threads ");
        JTextField threadsField = new JTextField();
        JLabel delayLabel = new JLabel("Delay");
        JTextField delayField = new JTextField();
        JLabel repitionLabel = new JLabel("Repetitions");
        JTextField repitionField = new JTextField();
        JButton startButton = new JButton("Start");
        GridLayout layout = new GridLayout(4, 2);
        JPanel panel = new JPanel(layout); 
        
        //adds everything to panel
        panel.add(threadsLabel);
        panel.add(threadsField);
        panel.add(delayLabel);
        panel.add(delayField);
        panel.add(repitionLabel);
        panel.add(repitionField);
        panel.add(startButton);

        // create action listener for start button
        class threads implements ActionListener 
        {
            public void actionPerformed(ActionEvent e) 
            {
                //gets a number from the textField
                int threadsNumber = Integer.valueOf(threadsField.getText());
                int repitionNumber = Integer.valueOf(repitionField.getText());
                int delayNumber = Integer.valueOf(delayField.getText());
                GreetingRunnable[] greetingRunnable = new GreetingRunnable[threadsNumber];
 
                for (int i = 0; i < threadsNumber; i++) 
                {
                    int value1 = i + 1;
                    String value2 = String.valueOf(value1);

                    greetingRunnable[i] = new GreetingRunnable("Hello from thread #" + value2);
                    greetingRunnable[i].repition = repitionNumber;
                    greetingRunnable[i].delay = delayNumber;
                }

                // create array of threads
                Thread[] t = new Thread[threadsNumber];
                 
                for (int i = 0; i < threadsNumber; i++) 
                {
                    t[i] = new Thread(greetingRunnable[i]);
                }

                //starts the threads
                for (int i = 0; i < threadsNumber; i++) 
                {
                    t[i].start();
                }
            }
        }
        //creates a frame, adds everything to it and makes it visible
        startButton.addActionListener(new threads());
        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.add(panel);
        frame.setVisible(true);
    }
    public GreetingThreadRunner(String aGreeting)
    {

    }
}

