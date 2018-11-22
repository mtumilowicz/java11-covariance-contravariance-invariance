# java11-covariance-contravariance-invariance
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

**Convariance could be dangerous**:
```
Dog[] dogs = new Dog[5];
Animal[] animals = dogs;

animals[0] = new Cat(); // ArrayStoreException
```

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
* we have hierarchical structure:
    * `interface Animal extends Comparable<Animal>`
    * `class Cat implements Animal`
    * `class Dog implements Animal`
    * `class BigDog extends Dog`
    
* what we can't do?
    ```
    List<Dog> dogs = new LinkedList<>();
    List<Animal> animals = dogs; // compile time error
    ```
    
* what we can do?
    * using vavr:
        ```
        HashSet<Dog> dogs = HashSet.of(new Dog(), new Dog());
        HashSet<Animal> animals = HashSet.ofAll(dogs);
        HashSet<Animal> animals2 = HashSet.narrow(dogs);
        
        HashSet<Animal> animals3 = HashSet.of(new Dog(), new Dog());
        ```
        * `HashSet<T> ofAll(java.lang.Iterable<? extends T> elements)`
        * `HashSet<T> narrow(io.vavr.collection.HashSet<? extends T> hashSet)`
    * using guava
        ```
        ImmutableSet<Dog> dogs = ImmutableSet.of(new Dog(), new Dog());
        ImmutableSet<Animal> animals = ImmutableSet.of(new Dog(), new Dog());
        ImmutableSet<Animal> animals2 = ImmutableSet.copyOf(Collections.<Dog>emptySet());
        ```
        * `ImmutableSet<E> copyOf(Collection<? extends E> elements)`
    * pure java
        * factory methods
            ```
            List<Dog> dogs = List.of(new Dog(), new Dog());
            List<Animal> animals = List.of(new Dog(), new Dog());
            List<Animal> animals2 = List.copyOf(dogs);
            ```
        * `Collections.unmodifiableXXX`
            ```
            List<Dog> dogs = new LinkedList<>();
            dogs.add(new Dog());
            
            List<Animal> dogsAsAnimals = Collections.unmodifiableList(dogs);
            ```
    * note that you could also use wildcards:
        * covariance, read-only
            ```
            Dog dog = new Dog();
            
            List<Dog> dogs = new LinkedList<>();
            dogs.add(dog);
            
            List<? extends Animal> dogsAsAnimal = dogs;
            //        dogsAsAnimal.add(new Dog()); compile time error
            //        Dog getDog = dogsAsAnimal.get(0);
            
            Animal getDog = dogsAsAnimal.get(0);
    
            assertThat(getDog, is(dog));
            ```
        * contravariance, write-only
            ```
            List<Dog> dogs = new LinkedList<>();
    
            List<? super Dog> onlyDogSpecies = dogs;
            onlyDogSpecies.add(new Dog());
            onlyDogSpecies.add(new BigDog());
    
            //        Animal getDog = dogsAsAnimal.get(0); compile time error
    
            assertThat(onlyDogSpecies.size(), is(2));
            ```