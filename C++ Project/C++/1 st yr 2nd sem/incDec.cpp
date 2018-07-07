//  decides whether input for age is stupid
#include <iostream>
using namespace std;

int main(){
   int num = 0;
   
   //allows user to enter an integer
   cout << "Give me any number: ";
   cin >> num;

   //once entered, use the operators
   
   //"post" increment:
   cout << num++ << endl;

   //"pre" increment:
   cout << ++num << endl;

   //"post" decrement:
   cout << num-- << endl;

   //"pre" decrement:
   cout << --num << endl;

   return 0;
}