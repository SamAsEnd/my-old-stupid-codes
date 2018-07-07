//  checks repeatadly for an even number using while
#include <iostream>
using namespace std;

int main(){
   int num;
   cout << "Give me any positive even number: ";
   cin >> num;

   while(num % 2 == 1){
      cout << "Not even, try again: ";
      cin >> num;
   }

   cout << "Right!  You entered: " << num << endl;

   return 0;
}