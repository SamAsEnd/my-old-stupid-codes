#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main(){
   //generates a new random set each time:
   srand(time(0));

   int arr[20] = {0};

   for(int i = 0; i < 20; i++){
      //random numbers from 1 to 10:
      arr[i] = rand() % 10 + 1;
   }

   for(i = 0; i < 20; i++){
      cout << arr[i] << " ";
   }

   return 0;
}