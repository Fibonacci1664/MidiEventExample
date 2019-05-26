package com.davegreen;

import javax.sound.midi.*;

public class MyMidiEventMethods
{
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
                                                                                    // This method takes all that is required for creating a midi event, using the parameters
        try                                                                         // that are passed when calling this method, it then returns the event back to the calling
        {                                                                           // process, which in this case and most probably in all cases will be when adding a track
            ShortMessage a = new ShortMessage();                                    // to the sequence.
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        }
        catch(Exception e)
        {
        
        }
        
        return event;
        
    }
}
