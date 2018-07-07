#include <iostream>
using namespace std;

int main() {
   int scores[5];
   int total = 0;

   cout << "Enter 5 scores to compute an average."
        << "One at a time when prompted: " << endl;

   for(int i = 0; i <= 4; i++){
      cout << "Enter score[" << i << "]: ";
      cin >> scores[i];
      cout << endl;
   }

   for (i = 0; i <= 4; i++)
      total += scores[i];

   cout << "The average was: " << total / 5.0 << endl;
   return 0;
}