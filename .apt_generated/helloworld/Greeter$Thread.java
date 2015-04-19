package helloworld;

import helloworld.Stream;
import org.paninij.runtime.Panini$Future;
import org.paninij.runtime.Panini$Message;
import org.paninij.lang.String;
import java.lang.Object;
import helloworld.Greeter;
import org.paninij.runtime.Capsule$Thread;
import org.paninij.runtime.ducks.*;


/**
 * This capsule was auto-generated from `helloworld.GreeterTemplate`
 */
public class Greeter$Thread extends Capsule$Thread implements Greeter 
{
    /* Capsule fields: */
    private GreeterTemplate panini$encapsulated = new GreeterTemplate();


    public static final int panini$proc$greet = 0;



    /* Capsule procedures: */

    public void greet()
    {
        void$Duck$$Thread panini$duck = null;
        panini$duck = new void$Duck$$Thread(panini$proc$greet);
        panini$push(panini$duck);
        

    }


    /* Capsule-specific Panini methods: */
    @Override
    public void panini$checkRequired()
    {
        assert(panini$encapsulated.s != null);
    }

    @Override
    public void wire(Stream s)
    {
        panini$encapsulated.s = s;
    }

    protected void panini$initChildren()
    {

        panini$encapsulated.design(this);

    }

    @Override
    protected void panini$initState() {
        panini$encapsulated.init();
    }

    public void run()
    {
        try
        {
            panini$checkRequired();
            panini$initChildren();
            panini$initState();
    
            boolean terminate = false;
            while (!terminate)
            {
                Panini$Message msg = panini$nextMessage();
                switch(msg.panini$msgID()) {
            
                case panini$proc$greet:
                    panini$encapsulated.greet();
                    break;

            
                case PANINI$SHUTDOWN:
                    if (panini$isEmpty() == false) {
                        panini$push(msg);
                    } else {
                        terminate = true;
                    }
                    break;
                
                case PANINI$EXIT:
                    terminate = true;
                    break;

                }
            }
        }
        catch (Exception ex) { /* do nothing for now */ }
    }



}
