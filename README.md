# java11-covariant-collections
Covariance, invariance, contravariance overview of collections in Java 11, vavr, guava.

_Reference_: https://dzone.com/articles/covariance-and-contravariance  
_Reference_: https://stackoverflow.com/questions/676615/why-is-scalas-immutable-set-not-covariant-in-its-type  
_Reference_: https://dzone.com/articles/covariance-and-contravariance  
_Reference_: https://github.com/google/guava/issues/2448  
_Reference_: https://docs.microsoft.com/en-us/dotnet/standard/generics/covariance-and-contravariance  
_Reference_: http://blog.kamkor.me/Covariance-And-Contravariance-In-Scala/  
_Reference_: https://medium.freecodecamp.org/understanding-java-generic-types-covariance-and-contravariance-88f4c19763d2

# preface
Variance refers to how subtyping between more complex 
types relates to subtyping between their components.

* Covariance: accept subtypes
* Contravariance: accept supertypes

**Generics in Java are invariant.** (Java has no way 
of knowing at runtime the type information of the 
type parameters, due to type erasure)

# project description

use case - xxx(List<Animal> list) {

}

go through Collections.unmodifiableList(xxx)