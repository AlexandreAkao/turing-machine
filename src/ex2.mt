@ex2
#w é um binário e a MT faz um incremento dele. Exemplo 5+1=6, tal que em binário fica 101+1=110
fita 101
init q0
accept q3

q0,0,q0,0,>
q0,1,q0,1,>
q0,_,q1,_,<
q1,0,q3,1,<
q1,1,q2,0,<
q2,0,q3,1,<
q2,1,q2,0,<
q2,_,q3,1,>
