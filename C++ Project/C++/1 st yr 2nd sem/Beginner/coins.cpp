//  calculates change for a register
#include <iostream>
using namespace std;

int main(){
   int x;
   cout << "How much change is needed? ";
   cin >> x;
   
   // quarters, dimes, nickles and cents wanted:
   int q, d, n, c;

   q = x / 25;
   x = x % 25;
   d = x / 10;
   x = x % 10;
   n = x / 5;
   c = x % 5;

   cout << "Quarters: " << q << "\nDimes: " << d
        << "\nNickels: " << n << "\nCents: " << c
        << endl;
   return 0;

}
