package helloworld;

import org.paninij.lang.Signature;
import org.paninij.lang.String;

@Signature
public interface Stream {
    void write(String s);
}
