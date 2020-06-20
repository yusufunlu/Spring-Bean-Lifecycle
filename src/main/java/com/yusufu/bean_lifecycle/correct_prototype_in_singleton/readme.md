It is almost well design I will explain where the problems is

Component1 is singleton and component2 is prototype
We wanted to create 2 different component2 in component1 in runtime
We needed to create component1 first. 
Generally in a web services project a request come into controller and that controller bean is created
Then we can create 2 different beans in that controller

Here we have no controller which can be initalized by spring or servlet mechanism whenever request came in
So we have created component1 using context Application class which is wrong pattern
Then we called createNewPrototypeBean method in component1
createNewPrototypeBean has called created component2 by help of @Lookup
If you check component2 is a dependancy of component1 but it is not autowired so we can wire it by  createNewPrototypeBean again again
