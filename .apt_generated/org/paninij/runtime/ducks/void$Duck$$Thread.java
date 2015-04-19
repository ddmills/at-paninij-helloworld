package org.paninij.runtime.ducks;

import org.paninij.runtime.Panini$Message;

public class void$Duck$$Thread implements Panini$Message {
    public final int panini$procID;


    public void$Duck$$Thread(int procID) {
        panini$procID = procID;
    }

    @Override
    public int panini$msgID() {
        return panini$procID;
    }
}
