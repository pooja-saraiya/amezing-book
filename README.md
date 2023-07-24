# amezing-book
After considering functional and non-functional requirements in the problem statement. We require 5 micro services as below.
1.	config-server
This service is required for the scaling of no of microservice as and when needed. All the common configurations for all services are placed in git hub so no need to change at every deployment.
2.	eurekaservice
This service is required for registering all the service running as part of solution. Users can get information on status of service, Ip address and port where service is deployed.
3.	Userservice
This service manages the user sign up for librarian who can issue and return books.
4.	Bookservice
This service is required for managing all operations related to books.
5.	Issueservice
This service is required for managing all operations related to book issue and return.

https://github.com/pooja-saraiya/configuration-server-property repository contains all common property files.

Checkout the project change the pointing to your git repository or create 1 new branch and change the database connection properties.
If you do not change anything theb by default it will point to local postgres with port no 5432.
To execute jar use java -jar <jar name> from command prompt where jar is placed.
Execute config-server first as it is require to fetch property for other microservice
Then execute eurekaservice so that all services can register to eureka.
Execute all services and test apis from swagger or postman.
