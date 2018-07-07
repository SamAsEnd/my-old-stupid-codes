#include <iostream>

using namespace std;

int main()                            // Most important part of the program!
{
  int age;                            // Need a variable...

  cout<<"Please input your age: ";    // Asks for age
  cin>> age;                          // The input is put in age
  cin.ignore();                       // Throw away enter
  if ( age < 100 ) {                  // If the age is less than 100
     cout<<"You are pretty young!\n"; // Just to show you it works...
  }
  else if ( age == 100 ) {            // I use else just to show an example
     cout<<"You are old\n";           // Just to show you it works...
  }
  else {
    cout<<"You are really old\n";     // Executed if no other statement is
  }
  cin.get();
}
