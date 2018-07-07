#include <iostream>
using namespace std;

int minArray(int arr[], int cap) {
   int m = arr[0];
   for (int c = 1; c < cap; c++)
      if (arr[c] < m) m = arr[c];
   return m;
}

int main() {
   int x[5] = {7,4,6,2,3};
   cout << minArray(x, 5) << endl;
   return 0;
}