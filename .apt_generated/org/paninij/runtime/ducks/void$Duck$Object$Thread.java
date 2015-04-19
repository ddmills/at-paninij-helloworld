package org.paninij.runtime.ducks;

import org.paninij.runtime.Panini$Message;

public class void$Duck$Object$Thread implements Panini$Message {
    public final int panini$procID;
    public Object panini$arg0;


    public void$Duck$Object$Thread(int procID, Object arg0) {
        panini$procID = procID;
        panini$arg0 = arg0;
    }

    @Override
    public int panini$msgID() {
        return panini$procID;
    }
}
