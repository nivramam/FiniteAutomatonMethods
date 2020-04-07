Update as on 27.03.2020

RE TO DFA (DIRECT METHOD):
Completed task: 
Studied and revisited the steps in the Direct Method. 
Explored that the DFA implementation can be achieved in two ways - using Digraph and Set Collection. 
Ongoing task: 
Validation of RE and finding augmented RE from given RE
Algorithm to find the nullable, firstpos and lastpos of the nodes (which is needed to finding the followpos)
To be done:
Build the tree (for the augmented grammar) and finding followpos
Choosing one of the two implementations (Digraph or Set method)

NFA TO DFA (Subset Construction method):
Completed Task:
Created the start state of DFA by taking Epsilon Closure of Start state of NFA.
Ongoing Task:
For the new DFA State, and for each possible input symbol in the state,
Applying move to newly created state and input symbol, which returns a set of new states.
Applying Epsilon Closure to this set of states resulting in a new state.

RE TO NFA:
Completed task:
Procedure - Thompson’s Algorithm.
Implementing using stack and java collection.
Union Operator
Maintain a stack.
( symbol : push onto stack.
| symbol : push  onto stack.
) pop corresponding ( and add epsilon(e) transition for or.

Ongoing task:
 Implementing Concatenation simply involves connecting one NFA to another.

To be done:
Algorithm for Kleene Closure a*.
Reference link:
https://www.cs.princeton.edu/courses/archive/fall12/cos226/lectures/54RegularExpressions.pdf
https://youtu.be/uPnpkWwO9hE
https://algs4.cs.princeton.edu/54regexp/Digraph.java.html
