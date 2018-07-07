#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main(){
   //generates a new random set each time:
   srand(time(0));

   int arr[25] = {0};

   for(int i = 0; i < 1000; i++){
      //random numbers from 1 to 10:
      arr[rand() % 25]++;
   }

   for(i = 0; i < 25; i++){
      cout << i << " was generated: " << arr[i] << " times.\n";
   }

   return 0;
}