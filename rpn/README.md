  Errors exposed(other than those given already):
  - Division by zero and modulo 0. These are errors because result is undefined.
  - When the user inputs a large integer number, it cannot be parsed as an int data type, rather it is type 'long', but since the stack accepts only integers, we cannot deal with numbers bigger than 32 bits.
  
