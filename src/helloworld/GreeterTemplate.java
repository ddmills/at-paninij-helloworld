package helloworld;

import helloworld.Stream;

import org.paninij.lang.Capsule;
import org.paninij.lang.String;
import org.paninij.lang.Wired;

@Capsule
public class GreeterTemplate {
    String message;
    @Wired Stream s;

    void init() {
        message = new String("Hello World!");
    }

    void design(Greeter self) { ; }

    public void greet() {
        s.write(new String("Panini: " + message));
        long time = System.currentTimeMillis();
        s.write(new String("Time is now: " + time));
    }
}
