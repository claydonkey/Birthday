#The Birthday problem
##Expressed through SCALA
```
((i: Int) => 1 - Math.pow(364.0/365, (0 until i).fold(0)(_ + _)))(POP)

```
where POP is an integer of the number people present.

# https://en.wikipedia.org/wiki/Birthday_problem

