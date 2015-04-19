package helloworld;

import helloworld.Stream;
import org.paninij.runtime.Panini$Future;
import org.paninij.runtime.Panini$Message;
import helloworld.Console;
import org.paninij.lang.String;
import java.lang.Object;
import org.paninij.runtime.Capsule$Thread;
import org.paninij.runtime.ducks.*;


/**
 * This capsule was auto-generated from `helloworld.ConsoleTemplate`
 */
public class Console$Thread extends Capsule$Thread implements Console 
{
    /* Capsule fields: */
    private ConsoleTemplate panini$encapsulated = new ConsoleTemplate();


    public static final int panini$proc$write$org_paninij_lang_String = 0;



    /* Capsule procedures: */

    public void write(String s)
    {
        void$Duck$Object$Thread panini$duck = null;
        panini$duck = new void$Duck$Object$Thread(panini$proc$write$org_paninij_lang_String, s);
        panini$push(panini$duck);
        

    }


    /* Capsule-specific Panini methods: */


    protected void panini$initChildren()
    {

        panini$encapsulated.design(this);

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
            
                case panini$proc$write$org_paninij_lang_String:
                    panini$encapsulated.write((org.paninij.lang.String) ((void$Duck$Object$Thread) msg).panini$arg0 );
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
