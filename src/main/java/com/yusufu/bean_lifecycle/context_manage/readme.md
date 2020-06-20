Different Config classes means different contexts which manage it's beans.
Even we create context from same Config class they are different contexts 
So those different context will create different singleton beans.
If we use prototype bean from same context different beans will be create as expected