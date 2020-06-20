We have called creation mechanism 2 times for singleton and prototype beans
And so obtained 2 same hashcodes for singleton and 2 different hash codes prototype beans
What about prototype bean in singleton ?
We got same hashcodes for inner prototype because of creation mechanism didn't work for singleton 
so the singleton will not to try prototype again. 

It is a wrong design if you want to different prototype beans in singleton