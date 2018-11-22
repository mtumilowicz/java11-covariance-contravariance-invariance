# java11-covariant-collections
Covariance, invariance, contravariance overview of collections in Java 11, vavr, guava.

_Reference_: https://dzone.com/articles/covariance-and-contravariance  
_Reference_: https://stackoverflow.com/questions/676615/why-is-scalas-immutable-set-not-covariant-in-its-type  
_Reference_: https://dzone.com/articles/covariance-and-contravariance  
_Reference_: https://github.com/google/guava/issues/2448  
_Reference_: https://docs.microsoft.com/en-us/dotnet/standard/generics/covariance-and-contravariance  
+ _Reference_: https://medium.freecodecamp.org/understanding-java-generic-types-covariance-and-contravariance-88f4c19763d2

# preface
## formal
* Covariance - enables you to use a more derived type than 
originally specified.
    > If A is a subtype of B then X[A] should be a subtype 
    of X[B].
* Contravariance - enables you to use a more generic 
(less derived) type than originally specified.
    > If A is a supertype of B then X[A] should be a 
    supertype of X[B].
* Invariance - means that you can use only the type 
originally specified; so an invariant generic type 
parameter is neither covariant nor contravariant.

## java
Variance refers to how subtyping between more complex 
types relates to subtyping between their components.

**Generics in Java are invariant.** (Java has no way 
of knowing at runtime the type information of the 
type parameters, due to type erasure)

* Covariance: accept subtypes
    > Arrays in java are covariant.
* Contravariance: accept supertypes
    > No easy examples in java (unless wildcards).
* Invariance: neither covariant nor contravariant
    > Generics are invarant

With wildcards, it’s possible for generics to support 
covariance and contravariance.

* Covariance: `? extends Integer`
    ```
    List<Integer> ints = new LinkedList<>();
    List<? extends Number> nums = ints;
    ```
* Contravariance: `? super Integer`
    ```
    List<Integer> ints = new LinkedList<>();
    List<? super Integer> nums = ints;
    ```
* Remark:
    * covariance is read-only
    * contravariance is write-only
    * otherwise compile-time error

## use case
Please refer my other github project for PECS principle:
https://github.com/mtumilowicz/java11-pecs-principle

1. suppose we have method that we cannot modify
    ```
    static void process(List<Animal> animals) {
        ...
    }
    ```
1. then we cannot invoke (because of compile time error)
    ```
    process(new LinkedList<Dog>()) // compile time error
    ```
1. but we could try to bypass it with a trick
    ```
    process(Collections.unmodifiableList(new LinkedList<Dog>()))
    ```

# project description

List<Animal> animals = new LinkedList<Dog>(); // compile time error

use case - xxx(List<Animal> list) {

}

go through Collections.unmodifiableList(xxx)