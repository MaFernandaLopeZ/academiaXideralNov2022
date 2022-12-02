# Synchronous and asynchronous processes


_This folder contains a project with synchronous and asynchronous exercises._

_The main difference is that synchronous processes code execution waits for the event before continuing, while asynchronous processes do not block program code execution._


## Synchronous processes 🚀

_Code execution waits for an event before continuing. The program will not run until an event returns a response_

_This performs all tasks before returning to the call instruction._

_One disadvantage is that it can cause delays._

### Example in code

_We have an interface called Listener where we have an abstract method called execute_

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Sincronos%20y%20Asincronos/img/sincrono1.png)

_The Synchronous class implements Listener, in which an override is made for the definition of the listener method._

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Sincronos%20y%20Asincronos/img/sincrono2.png)

_In the Main class, it is declared for a reference variable of type Listener that would be the listener or listener._

_It has a method called addListener, which will set the value returned to the listener._

_The execute method is the one that will contain the synchronous tasks, where the if condition checks if the listener is registered, if the condition is true, the callback method of the Sync class is invoked through the listener._

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Sincronos%20y%20Asincronos/img/sincrono3.png)

_Inside the main method, there is an object of type Main and a listener of type Listener, so the listener is passed to addListener using the object to call the execute method of the class._


## Asynchronous processes 🚀

_An asynchronous process, does not block the execution of the program._

_When the call returns from the event, the call returns to the callback function. So, you create a thread and invoke the method inside the thread,_

_We have an interface called Listener where we have an abstract method called execute_

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Sincronos%20y%20Asincronos/img/asincrono1.png)

_The Asynchronous class implements Listener, in which an override is made for the definition of the listener method._

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Sincronos%20y%20Asincronos/img/asincrono2.png)

_In the Main class, it is declared for a reference variable of type Listener that would be the listener or listener._

_It has a method called addListener, which will set the value returned to the listener._

_The execute method contains asynchronous tasks, where a thread is created within it. Therefore, asynchronous threads always run inside the new thread. The stable condition if the listener is registered, if true calls the callback method of the Asynchronous class via the listener._

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Sincronos%20y%20Asincronos/img/asincrono3.png)

_Inside the main method, there is an object of type Main and a listener of type Listener, so the listener is passed to addListener using the object to call the execute method of the class._

## Links to projects🚀

_Asynchronous_

[Go to project](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/tree/main/Semana%202/Sincronos%20y%20Asincronos/src/com/asincrono)

_Synchronous_

[Go to project](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/tree/main/Semana%202/Sincronos%20y%20Asincronos/src/com/sincrono)

## Video 📄

_If you want more hearing support, you can see the following_

[Go to video](https://youtu.be/CnRMZxwvtVc)