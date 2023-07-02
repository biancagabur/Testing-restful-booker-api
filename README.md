# testing-restful-booker-api
Testing [Restful Booker API](https://restful-booker.herokuapp.com)

# Tech Stack:
- [Cucumber](https://cucumber.io/)
- [REST assured](https://rest-assured.io/)
- Java

# Getting started
The cucumber project was created using [The 10 minute tutorial](https://cucumber.io/docs/guides/10-minute-tutorial/?lang=java) from cucumber website
```bash
  mvn archetype:generate                                           
   "-DarchetypeGroupId=io.cucumber"                                
   "-DarchetypeArtifactId=cucumber-archetype"                      
   "-DarchetypeVersion=7.12.1"                                     
   "-DgroupId=testing-restful-booker-api"
   "-DartifactId=testing-restful-booker-api"                       
   "-Dpackage=testingAuth"                  
   "-Dversion=1.0.0-SNAPSHOT"                 
   "-DinteractiveMode=false"
```
To run all the tests you can use the following command in the terminal
```bash
mvn test
```

# Next steps
- [ ]  Adding specific tests
