#ex3
#verificar se binário é múltiplo de 5
fita 1011111
init q0
accept q6

q0,0,q5,0,>
q0,1,q1,1,>
q1,0,q2,0,>
q1,1,q3,1,>
q2,0,q4,0,>
q2,1,q5,1,>
q3,0,q1,0,>
q3,1,q2,1,>
q4,0,q3,0,>
q4,1,q4,1,>
q5,0,q5,0,>
q5,1,q1,1,>
q5,_,q6,_,>