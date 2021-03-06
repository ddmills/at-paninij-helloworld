# at-paninij-helloworld
How to use @PaniniJ version 0.0.1

## Setting up A @PaniniJ Project

These are the overall steps to setting up an @PaniniJ project in eclipse:

1. Create a project using JRE 1.8
2. Download the at-paninij-0.0.1-SNAPSHOT.jar
3. Enable annotation processing
4. Add at-paninij annotation processor to your build
5. Add the at-paninij as a referenced library


### 1. Setup project to use JRE 1.8

When you create a new project, be sure to choose JRE 1.8, this is necessary for the annotation processing to work correctly.

![alt tag](http://dec1512.sd.ece.iastate.edu/src/img/example/fig1.png)


### 2. Download the at-paninij-0.0.1-SNAPSHOT.jar

Download the JAR from  http://dec1512.sd.ece.iastate.edu/src/snapshot/at-paninij-0.0.1-SNAPSHOT.jar.


### 3. Enable Annotation Processing

Enable annotation processing by right clicking on your project in the project explorer and choosing "properties." Browse to `Java Compiler` > `Annotation Processing` and check the `Enable project specific settings` checkbox and `Enable annotation processing`.

![enable annotation processing](http://dec1512.sd.ece.iastate.edu/src/img/example/fig2.png)

Once you hit `Apply`, Eclipse will inform you that a rebuild on the project is required. You can rebuild the project now.

![confirm rebuild of the project](http://dec1512.sd.ece.iastate.edu/src/img/example/fig3.png)


### 4. Add at-paninij annotation processor

Navigate to the `Factory Path` section of the project properties. It is beneath the `Annotation Processing` option. Check the `Enable project specific settings` checkbox, and click the `Add External JARs...` button.

![enable project specific settings](http://dec1512.sd.ece.iastate.edu/src/img/example/fig4.png)

Browse to where you have downloaded the JAR file from step 2. Hit `Apply` and confirm the projct rebuild.

![include JAR and confirm rebuild](http://dec1512.sd.ece.iastate.edu/src/img/example/fig5.png)


### 5. Add the at-paninij as a referenced library

The @PaniniJ JAR file includes code necessary for the annotation processing and runtime. To include the JAR file as a referenced libaray, right click the project in the project explorer, and choose `Add External Archives...`:

![Add External Archives](http://dec1512.sd.ece.iastate.edu/src/img/example/fig6.png)

Browse to where you downloaded the JAR file from step 2, and include it in your project. Once it is included, the project should appear like this in the Eclipse project explorer:

![Project explorer view](http://dec1512.sd.ece.iastate.edu/src/img/example/fig7.png)


### Finised project setup!

Now you're ready to start programming in @PaniniJ.

## Hello World Example
This example is a side-by-side comparison between the @PaniniJ code and regular PaniniJ code. It uses the Helloworld example from [PaniniJ](http://paninij.org/).

The hello world example consists of four files:

1. The Stream Signature. (`Stream.java`)
2. The Console Capsule Template which implements the Stream signature. (`ConsoleTemplate.java`)
3. The Greeter Capsule Template which uses a Stream (`GreeterTemplate.java`)
4. The HelloWorld Capsule Template which *wires* the Greeter Capsule to use the Console. (`HelloWorldTemplate.java`)

### Stream.java

To create a Signature, use the `@Signature` annotation included in the `org.paninij.lang` package. The Stream signature defines one method, `void write(String s);`. Notice that the `String` is from the `org.paninij.lang` package. 

**@PaniniJ is on the left, PaniniJ is on the right**
![Stream comparison](http://dec1512.sd.ece.iastate.edu/src/img/example/ex-fig-stream.png)


### ConsoleTemplate.java

To define a Capsule called `Console` we create a concrete class called `ConsoleTemplate`. The @PaniniJ annotation processor will automatically generate the `Console` class. If we did not include word `Template` in the name, the class will not compile. 

* **line 6**: The `ConsoleTemplate` is annoted with `@Capsule`. This lets the @PaniniJ know to treat this object as a Capsule definition (template).
* **line 7**: The template for the (automatically generated) `Console` capsule is called `ConsoleTemplate`. Notice that the `ConsoleTemplate` also implements the `Stream` signature.

The `void design(Console self) { ; }` method on line `8` is currently required to be included on all Capsules. The Console capsule does not make use of the design method, so it is left empty.

The capsule must override the methods provided by the `Stream` signature.

**@PaniniJ is on the left, PaniniJ is on the right**
![Console comparison](http://dec1512.sd.ece.iastate.edu/src/img/example/ex-fig-console.png)


### GreeterTemplate.java

The Greeter capsule generates a message and sends it to a `Stream` to `write()`.

* **line 9**: Include the `@Capsule` annotation
* **line 10**: To make it a valid capsule definition, the class must have `Template` at the end of the classname.
* **line 11**: We declare a state variable. Notice that it is **not** initialized. That is done on line `15` in the `init()`` method.
* **line 12**: We use the `@Wired` annotation to declare a Capsule field (which implements the `Stream` signature) that the `Greeter` Capsule will be "wired" with by it's parent Capsule (`HelloWorld`).
* **line 14-16**: The `init()` method is used to initalize any state variables that the capsule has. In this case it initializes the `message` variable. Notice that we also use `new String("Hello World!");`. This is because we're using the `org.paninij.lang.String` class imported on line `6`.
* **line 18**: The `design(Greeter self)` method is needs to be present on every capsule template.
* **line 20**: We define a capsule procedure called `greet()`.
* **line 21-23**: We `write()` to the `Stream s`. Notice again that we're using `new String(...)`. Also notice that we did not instantiate the `Stream s` object inside this capsule. The `Stream s` will be provided by it's parent. This is similar to line `10` in the PaniniJ example (on the right hand side). 

**@PaniniJ is on the left, PaniniJ is on the right**
![Greeter comparison](http://dec1512.sd.ece.iastate.edu/src/img/example/ex-fig-greeter.png)


### HelloWorldTemplate.java

* **line 11-12**: We declare two child capsules, `Console c` and `Greeter g`. These are the same as lines `19-20` in the PaniniJ code (on the right hand side).
* **line 14-16**: We don't have any state variables to initialize
* **line 18**: We decare the `design()` method. Notice that a `HelloWorld` capsule will be passed in. The `self` parameter can be passed to `child` capsules to wire. It must be used instead of `this`, because in this context, `this` refers to `HelloWorldTemplate` and not `HelloWorld`, which is an actual capsule.
* **line 21**: We call the `g.wire(c)`. This will populate the `@Wired Stream s` field on the `GreeterTemplate`.
* **line 25**: The HelloWorldTemplate just calls `greet()` on it's `@Child` capsule `g`.
* **line 29-32**:

**@PaniniJ is on the left, PaniniJ is on the right**
![HelloWorld comparison](http://dec1512.sd.ece.iastate.edu/src/img/example/ex-fig-helloworld.png)

### The Final Output
```
Panini: Hello World!
Time is now: 1429473957091
```


## Known Issues
