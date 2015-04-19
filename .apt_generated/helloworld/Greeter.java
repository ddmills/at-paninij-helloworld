package helloworld;

import helloworld.Stream;
import org.paninij.lang.CapsuleInterface;
import org.paninij.lang.String;
import java.lang.Object;
import helloworld.Greeter;
import org.paninij.runtime.Panini$Capsule;


/**
 * This capsule interface was auto-generated from `helloworld.GreeterTemplate`
 */
@CapsuleInterface
public interface Greeter extends Panini$Capsule 
{
    public void wire(Stream s);
    public void greet();

}
