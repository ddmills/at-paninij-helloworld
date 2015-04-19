package helloworld;

import org.paninij.lang.Capsule;
import org.paninij.lang.String;

@Capsule
public class ConsoleTemplate implements Stream {
    void design(Console self) { ; }

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
