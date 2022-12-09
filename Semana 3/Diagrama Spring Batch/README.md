# Spring Batch

_The basic structure of Spring Batch is explained._

_Spring Batch defines the structure of the batch process. It is recommended to develop after understanding the structure._

## Main Components 📋

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%203/Diagrama%20Spring%20Batch/spring-batch-reference-model.png)

### JobRepository
_An important aspect of Spring Batch is that there should be no outside interference. So we need to save the job state and future runs need to take this into account. State management is an important aspect when processing large volumes of data. This is achieved using Spring Batch JobRepository._

### Job Launcher
_An interface to run a job._

_Spring Batch JobLauncher has only one method: run(job job, job parameters job parameters) . Takes two parameters_

- Work to execute.
- JobParameters to be passed to the job.

### Job
_A single unit of execution that summarizes a series of processes for the batch application in Spring Batch._

_This job may involve a simple or complex task:_

- For simple tasks, the Spring Batch Tasklet is generally used.
- For a task like deleting a file, running a database query, a Spring Batch Tasklet will be implemented to run the job

### Step
_Step is a domain object that encapsulates an independent, sequential phase of a batch job and contains all the information necessary to define and control the actual batch processing._

![Image text](https://github.com/MaFernandaLopeZ/academiaXideralNov2022/blob/main/Semana%203/step.png)

_The batch application consists of the processing of these 3 patterns and in Spring Batch, the implementation of these interfaces is mainly used in the fragment model.
The user describes the business logic by dividing it according to the respective roles._

_Since the ItemReader and ItemWriter responsible for data input and output are often the processes that perform the conversion from databases and files to Java objects and vice versa, Spring Batch provides a standard implementation. In general batch applications that perform data input and output from a file and a database, the conditions can be satisfied simply by using the standard Spring Batch implementation as-is. ItemProcessor, which is responsible for data processing, implements input verification and business logic._

_In the Tasket model, ItemReader/ItemProcessor/ItemWriter replaces a single Tasklet interface implementation. Input-output, input verification, and business logic must be implemented in Tasklet._


### References
_For more information consult the following sites:_

- https://www.javainuse.com/spring/batch/2
- https://docs.spring.io/spring-batch/docs/current/reference/html/step.html
- https://docs.spring.io/spring-batch/docs/current/reference/html/job.html