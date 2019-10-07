/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Abdelhalim
 */
public class DigitalClockClass implements ActionListener {

    JLabel timeLabel = new JLabel();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    Timer timer;

    public DigitalClockClass() {

        // get the current time and display it on the JLabel  
        // according to the format
        timeLabel.setText(simpleDateFormat.format(new Date(
                System.currentTimeMillis())));
        // set a nice font to display the clock with it
        timeLabel.setFont(new Font("Tomha", Font.PLAIN, 36));
        // set a nice color
        timeLabel.setForeground(Color.red);
        // Set the timer to update the clock every 500 milliseconds (0.5 seconds)
        timer = new Timer(500, this);
        timer.setRepeats(true);
        timer.start();
    }

    /**
     * method that will return the JLabel that hold the digital clock outside
     * the class
     *
     * @return
     */
    public JLabel getDigitalClock() {
        return timeLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // If the timer caused this event.
        if (e.getSource().equals(timer)) {
            // Then set a new time.
            timeLabel.setText(simpleDateFormat.format(new Date(
                    System.currentTimeMillis())));
        }
    }
}
