# Discussion

**Document all error conditions you determined and why they are error
 conditions. Do this by including the inputs that you used to test your
  program and what error conditions they exposed:**
  
  Errors exposed(other than those given already):
  - Division by zero and modulo 0. These are errors because result is undefined.
  - When the user inputs a large integer number, it cannot be parsed as an int data type, rather it is type 'long', but since the stack accepts only integers, we cannot deal with numbers bigger than 32 bits.
  