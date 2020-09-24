@ex1
#binario tem que terminar com 01
fita 01
init q0
accept q3

q0,0,q1,0,>
q0,1,q0,1,>
q1,0,q1,0,>
q1,1,q2,1,>
q2,0,q1,0,>
q2,1,q0,1,>
q2,_,q3,_,>