#include <iostream>
using namespace std;

int minArray(int arr[][5], int rowCap, int colCap) {
   int m = arr[0][0];
   
   for (int r = 0; r < rowCap; r++)
     for (int c = 0; c < colCap; c++)
       if (arr[r][c] < m) m = arr[r][c];

   return m;
}

int main() {
	int x[3][5] = { {13,4,35,22,3},
	                {32,3,7,3,2},
                        {3,4,4,4,2}};
   cout << minArray(x, 3, 5) << endl;
   return 0;
}