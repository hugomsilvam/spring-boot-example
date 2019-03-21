# spring-boot-example
Create a spring-boot example REST API with Entity, Controller, Service, Repository and Exceptions architecture.

Entities are the **models** of the DB, the REST API can have multiple models, DB models or Service models, in this simple example we have just 1 DB Model.

Controllers are the REST API endpoints of your **Service**. The Client uses the controller and the controller just calls the Service.
The Controller is dummy, it should just makes some input validations made from the client and calls to the service.

Services are the business logic of the application. It's where you should make calls to the DB, do more core validations, data sanitization, etc.
The Service should implement a list of methods called by the **Repository** interface.
In case of a method failure, the Service should return some errors or **Exceptions** to the Controller.

Repository is an interface, Spring framework has `CrudRepository` interface and you should implement it on your repositories if your services have CRUD operations.

Exceptions are exceptions - accept it and throw them away :trollface:
