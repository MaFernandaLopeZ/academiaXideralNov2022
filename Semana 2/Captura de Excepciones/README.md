# Catch exceptions

### Pre-requisitos 📋
_Before Java 7, you had to catch exceptions in each catch block. So whenever we needed to handle more than one specific exception but take some action for all exceptions, we had to have more than one catch block containing the same code._

## Multiple Catch Bock 📌

_As of this version, it is included to be able to catch several exceptions separated by a | in a catch block._

_Catching multiple exceptions in a single catch block reduces code duplication and increases efficiency._

```
try {
    // codes
}
catch (ExceptionType1 | Exceptiontype2 ex){
    // catch block
}
```
### Example ⌨️
_In this example we use a String List for subject grades, where we will obtain the sum of it and its average according to the subjects received._

_This is where we occupy the **Multiple Catch** since if it does not receive anything in units, it would keep it at 0, and this is where the exception would be generated at runtime, which is when it would tell us if there was an error or not._

_This type of capture helps us to manipulate the different exceptions that we can find, and do it in the same block. It works in the following way:._

_It will send the exception as long as there is one, and it will have to see what type of exception it is according to the exceptions put in the catch block. This makes error handling easier for your optimal process._

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Captura%20de%20Excepciones/img/multiple%20cath.png)

## Try with resources 📌

_Support for try-with-resources , introduced in Java 7, allows us to declare the resources to be used in a try block with the assurance that the resources will be closed after the execution of that block._

```
try (resource declaration) {
  // use of the resource
} catch (ExceptionType e1) {
  // catch block
}
```
_As seen in the above syntax, we declare the try-with-resources statement by:_
- declaring and instantiating the resource inside the try clause.
- specifying and handling all exceptions that can be thrown when closing the resource.

### Example⌨️
_We have in the following example, an exception that reads a text file, and if it doesn't find it, it prints the exception FileNotFoundException. Immediately close the resource.

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Captura%20de%20Excepciones/img/resoulces2.png)

## Author ✒️
⌨️ by [Fernanda López](https://www.linkedin.com/in/mafernandalopezzarate/) 😊