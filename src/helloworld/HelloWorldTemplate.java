package helloworld;

import helloworld.Console;
import helloworld.Greeter;
import org.paninij.lang.Capsule;
import org.paninij.lang.Child;

@Capsule
public class HelloWorldTemplate
{
    @Child Console c;
    @Child Greeter g;

    void design(HelloWorld self) {
        g.wire(c);
    }

    void run() {
        g.greet();
    }
}
