#ex3
#verificar se binário é múltiplo de 5
fita 110111
init q0
accept q5

q0,0,q0,0,>
q0,_,q5,_,<
q0,1,q1,1,>
q1,0,q2,0,>
q1,1,q3,1,>
q1,_,q0,_,<
q2,0,q4,0,>
q2,1,q0,1,>
q2,_,q0,_,<
q3,0,q1,0,>
q3,1,q2,1,>
q3,_,q0,_,<
q4,0,q3,0,>
q4,1,q4,1,>
q4,_,q0,_,<