package helloworld;

import org.paninij.lang.Capsule;

@Capsule class ConsoleTemplate implements Stream {

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
