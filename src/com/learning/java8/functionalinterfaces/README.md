### Java 8
- Lambda
- Streams
- Optionals
- New Date/Time APIs

>Java 8 features simplify concurrency operations. **Functional programming** uses the concept of **declarative programming** (focus on what needs to be computed rather than how it should be computed).

### Lambdas
- Lambdas are also known as **Anonymous Functions**.
- Lambdas are not tied to any class like regular methods.
- Lambdas are used to implement **Functional Interfaces (SAM - Single Abstract Method Interfaces)**. SAM are annotated with **@FunctionalInterface**

### Functional Interfaces
Four primary functional interfaces:
- Consumer - (Bi-consumer)
- Predicate - (Bi-predicate)
- Function - (Bi-function, UnaryOperator, BinaryOperator)
- Supplier

### Method References
Syntaxes
- ClassName::instance-method-name
- ClassName::static-method-name
- Instance::method-name
