package helloworld;

import helloworld.Stream;
import org.paninij.lang.CapsuleInterface;
import helloworld.Console;
import org.paninij.lang.String;
import java.lang.Object;
import org.paninij.runtime.Panini$Capsule;


/**
 * This capsule interface was auto-generated from `helloworld.ConsoleTemplate`
 */
@CapsuleInterface
public interface Console extends Panini$Capsule, helloworld.Stream 
{
    public void write(String s);

}
