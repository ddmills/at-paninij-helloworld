package helloworld;

import org.paninij.lang.Capsule;
import org.paninij.lang.Wired;

@Capsule class GreeterTemplate {

    String message;
    @Wired Stream s;

    void init() {
        message = "Hello World!";
    }

    public void greet() {
        s.write("Panini: " + message);
        long time = System.currentTimeMillis();
        s.write("Time is now: " + time);
    }
}
