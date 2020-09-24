@ex4
#dobra de entrada da fita
fita 1100
init q0
accept q5

q0,0,q0,0,>
q0,1,q0,1,>
q0,o,q0,0,>
q0,i,q0,1,>
q0,_,q1,_,<
q1,0,q2,o,>
q1,1,q3,i,>
q1,o,q1,o,<
q1,i,q1,i,<
q2,_,q1,o,<
q3,_,q1,i,<
q2,0,q2,0,>
q2,1,q2,1,>
q2,o,q2,o,>
q2,i,q2,i,>
q3,0,q3,0,>
q3,1,q3,1,>
q3,o,q3,o,>
q3,i,q3,i,>
q1,_,q4,_,>
q4,o,q4,0,>
q4,i,q4,1,>
q4,0,q4,0,<
q4,1,q4,1,<
q4,_,q5,_,>