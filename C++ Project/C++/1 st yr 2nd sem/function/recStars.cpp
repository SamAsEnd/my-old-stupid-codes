#include <iostream>
using namespace std;

void Triangle(int x) {
   if (x <= 0) return;
   Triangle(x - 1);
   
   for (int i = 1; i <= x; i++) 
        cout << "*";
   cout << endl;
}

int main() {
   Triangle(7);
   return 0;
}