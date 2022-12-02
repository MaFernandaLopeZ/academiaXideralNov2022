# Dpendency Ijection

## Diagrams 📋

### High Coupling
_An employee is created where it will be assigned the type of employee that will be added in this case Doctor._
![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Inyeccion%20de%20dependencias/img/1.png)

### Injection by variables
_It is changed so that it is no longer the employee who is assigned to the employee, if not, his manager, in this case his injector._

_Injector will be the only one that will know that the type employee will be injected to employee._

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Inyeccion%20de%20dependencias/img/2.png)

## Injection Implementation
_**Employees Interface** Its objective is to be the injector, since it will assign the type of employee that arrives to employee._

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Inyeccion%20de%20dependencias/img/5.png)

_**Doctor and Nurse classes** that implement the Employees interface that would be our injector._


![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Inyeccion%20de%20dependencias/img/3.png)


_**Main class** assigns the injector an employee type of Employee_

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%202/Inyeccion%20de%20dependencias/img/6.png)


## Author ✒️
⌨️ by [Fernanda López](https://www.linkedin.com/in/mafernandalopezzarate/) 😊