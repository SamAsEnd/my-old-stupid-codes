//  decides whether input for age is stupid
#include <iostream>
using namespace std;

int main(){
   int age;
   cout << "What is your age: ";
   cin >> age;

   if (age < 0) {
       cout << "Idiot." << endl;
       exit(1);
   }
   else cout << "You passed." << endl;
   return 0;
}

