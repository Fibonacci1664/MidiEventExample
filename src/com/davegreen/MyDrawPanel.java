package com.davegreen;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel implements ControllerEventListener
{
    boolean message = false;
    
    @Override
    protected void paintComponent(Graphics g)
    {
        //super.paintComponent(g);                                                  // If we call the super we repaint the background white canvas each time thus painting over
                                                                                    // the currently existing shape, by removing the call to super each repaint leaves the painted
        if(message)                                                                 // shape on the canvas displaying many random shapes in random locations.
        {
            int r = (int) (Math.random() * 256);                                    // Generate 3 random RGB values.
            int b = (int) (Math.random() * 256);
            int gr = (int) (Math.random() * 256);
            
            g.setColor(new Color(r, b, gr));                                        // Set the new RGB color.
            
            int height = (int) ((Math.random() * 120) + 10);                        // Generate a random height and width.
            int width = (int) ((Math.random() * 120) + 10);
            
            int x = (int) ((Math.random() * 450) + 10);                              // Generate a random x and y value to use as co-ords.
            int y = (int) ((Math.random() * 450) + 10);
            
            g.fillRect(x, y, width, height);                                        // Set the location and the size of the rect using the randomly generated values, this will
            message = false;                                                            // be new each and every time the the paintComponent method is called i.e. repaint().
        }
    }
    
    @Override
    public void controlChange(ShortMessage event)
    {
        message = true;
        repaint();
    }
}
