## Steps to Run the App

1. Open the folder of the project.
2. Open a terminal and run the following command to start kafka container :

docker-compose up -d

3. Use the `pwd` command in the terminal to get the current directory path and paste it into the `file.path` property in the `application.properties` file.

4. Open the `OfferServiceImpl` class and locate the `@Qualifier` annotation. 
- If you set the value to `"impl1"`, the app will use H2 database to persist data.
- If you set the value to `"impl2"`, the app will throw an event to Kafka when an offer is created.

