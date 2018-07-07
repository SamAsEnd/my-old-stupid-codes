#include <iostream.h>

int main() {
   int size;
   cout << "How large a triangle do you want? ";
   cin >> size;

   for (int r = 0; r < size; r++) {
     for (int c = 1; c <= size; c++) {
        if (c <= r) cout << " ";
        else cout << "*";
     }
     cout << endl;
   }

   return 0;
}
