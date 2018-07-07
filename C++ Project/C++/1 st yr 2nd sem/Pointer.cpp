#include <iostream>

using namespace std;

int main()
{
  int x;            // A normal integer
  int *p;           // A pointer to an integer

  p = &x;           // Read it, "assign the address of x to p"
  cin>> x;          // Put a value in x, we could also use *p here
  cin.ignore();
  cout<< *p <<"\n"; // Note the use of the * to get the value
  cout<< p <<"\n"; //                        to get the address
  cin.get();
}
