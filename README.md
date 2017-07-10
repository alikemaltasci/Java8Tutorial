* Functional Interfaces are interfaces with a single method only
* Lambda expressions is used primarily to define inline impelementation of functional interfaces
* Method references help to point to methods by their names. 
A method reference is described using ::(double column) symbol. 
A method reference can be used to point the following types of methods:
    * static methods
    * instance methods
    * constructor using new operator(TreeSet::new)
* Functional interfaces has single functionality to exhibit. For example a Comparable interface with a single method compareTo is used for comparison purpose. Java 8 has defined a lot of functional interfaces to be used in lambda expressions in java.util.Function package.
* With Java8 default methods can be added to interfaces. If implementing classes doesn' have these methods, default methods is called.
* Streams represents a sequence of objects from a source, which supports aggregate functions. Collection interface has two methods two generate streams:
   - stream() - returns a sequential stream considering collection as its source.
   - parallelStream() - returns a parallel stream considering collection as its souce.


Sources:
* http://www.tutorialspoint.com/java8/index.htm
* http://www.baeldung.com/java-optional