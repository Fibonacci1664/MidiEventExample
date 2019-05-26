package com.davegreen;

import javax.sound.midi.*;
import javax.swing.*;

public class MyMusicPlayer implements ControllerEventListener
{
    static MyMidiEventMethods myMidiEventMethods = new MyMidiEventMethods();
    static JFrame frame = new JFrame("My First Music Video!");
    static MyDrawPanel myDrawPanel;
    
    public void setUpGui()
    {
        myDrawPanel = new MyDrawPanel();
        frame.setContentPane(myDrawPanel);
        frame.setBounds(30, 30, 600, 600);
        frame.setVisible(true);
    }
    
    public void musicPlayer()
    {
        setUpGui();
        
        try
        {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            
            //int[] eventsIWant = {127};
            sequencer.addControllerEventListener(myDrawPanel, new int[] {127});
            
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();
            
            int r = 0;
            for(int i = 0; i < 200; i += 4)                                      // The for loop conditions set the notes that will be played, from note 5 to note 60 inclusive.
            {
                r = (int) ((Math.random() * 50) + 1);
                track.add(myMidiEventMethods.makeEvent(144, 1, r, 100, i));             // These are the midi events (tracks) that are added to the sequence after
                                                                                                        // being created by the midi event method and returned back here.
                
                track.add(myMidiEventMethods.makeEvent(176, 1, 127, 0, i));
                
                track.add(myMidiEventMethods.makeEvent(128, 1, r, 100, i + 2));
            }
            
            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(200);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void controlChange(ShortMessage event)
    {
        System.out.println("la");
    }
}
