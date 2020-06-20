# bean_lifecycle
This project for testing how bean lifecycle works and context can effect it

There are 4 projects which has different aims to test
1. context_manage show differnt context objects which derived from same config class, will create different singleton beans!!!
Yes, because, they are different context manager of beans
2. Prototype bean in singleton ==> prototype 
3. Singleton bean in prototype ==> singleton 
  This means context is still the manager of lifecycle even parent bean is prototype it is still singleton dependancy
