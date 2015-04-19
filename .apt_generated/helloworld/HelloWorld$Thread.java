package helloworld;

import org.paninij.runtime.Panini$Future;
import helloworld.HelloWorld;
import org.paninij.runtime.Panini$Message;
import helloworld.Console;
import java.lang.Object;
import helloworld.Greeter;
import java.lang.String;
import org.paninij.runtime.Capsule$Thread;
import org.paninij.runtime.ducks.*;


/**
 * This capsule was auto-generated from `helloworld.HelloWorldTemplate`
 */
public class HelloWorld$Thread extends Capsule$Thread implements HelloWorld 
{
    /* Capsule fields: */
    private HelloWorldTemplate panini$encapsulated = new HelloWorldTemplate();





    /* Capsule procedures: */


    /* Capsule-specific Panini methods: */


    protected void panini$initChildren()
    {
        panini$encapsulated.c = new helloworld.Console$Thread();
        panini$encapsulated.g = new helloworld.Greeter$Thread();
        panini$encapsulated.design(this);
        panini$encapsulated.c.panini$start();
        panini$encapsulated.g.panini$start();
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
            panini$encapsulated.run();
        } finally {
            // TODO?
        }
    }

    public static void main(String[] args)
    {
        HelloWorld$Thread root = new HelloWorld$Thread();
        root.run();
    }


}
