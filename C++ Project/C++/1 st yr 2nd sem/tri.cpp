#include <iostream.h>

int main() {
   int size;
   cout << "How large a triangle do you want? ";
   cin >> size;

   for (int r = 1; r <= size; r++) {
     for (int c = 1; c <= r; c++) 
        cout << "*";
     cout << endl;
   }

   return 0;
}
