//  for loops for square
#include <iostream.h>

int main(){

   const int SIZE = 5;

   for (int r = 1; r <= SIZE; r++) {
     for (int c = 1; c <= SIZE; c++) {
        cout << "*";
     }
     cout << endl;
   }

   return 0;
}