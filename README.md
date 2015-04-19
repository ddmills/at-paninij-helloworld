# at-paninij-helloworld
How to use @PaniniJ version 0.0.1

## Setting up A @PaniniJ Project

These are the overall steps to setting up an @PaniniJ project in eclipse:

1. Create a project using JRE 1.8
2. Download the at-panini-j-0.0.1-SNAPSHOT.jar
3. Enable annotation processing
4. Add at-paninij annotation processor to your build
5. Add the at-paninij as a referenced library


### 1. Setup project to use JRE 1.8

When you create a new project, be sure to choose JRE 1.8, this is necessary for the annotation processing to work correctly.

![alt tag](http://dec1512.sd.ece.iastate.edu/src/img/example/fig1.png)


### 2. Download the at-panini-j-0.0.1-SNAPSHOT.jar

Download the JAR from  http://dec1512.sd.ece.iastate.edu/src/snapshot/at-paninij-0.0.1-SNAPSHOT.jar.


### 3. Enable Annotation Processing

Enable annotation processing by right clicking on your project in the project explorer and choosing "properties." Browse to `Java Compiler` > `Annotation Processing` and check the `Enable project specific settings` checkbox and `Enable annotation processing`.

![enable annotation processing](http://dec1512.sd.ece.iastate.edu/src/img/example/fig2.png)

Once you hit `Apply`, Eclipse will inform you that a rebuild on the project is required. You can rebuild the project now.

![confirm rebuild of the project](http://dec1512.sd.ece.iastate.edu/src/img/example/fig3.png)


### 4. Add at-paninij annotation processor

Navigate to the `Factory Path` section of the project properties. It is beneath the `Annotation Processing` option. Check the `Enable project specific settings` checkbox, and click the `Add External JARs...` option.

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


### The Final Output
```
Panini: Hello World!
Time is now: 1429473957091
```


## Known Issues
