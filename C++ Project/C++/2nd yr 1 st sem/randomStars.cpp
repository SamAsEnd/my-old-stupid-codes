#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main(){
   //generates a new random set each time:
   srand(time(0));
   
   int num = 0;

   for(int i = 0; i < 25; i++){
      //random numbers from 0 to 15:
      num = rand() % 15;
      for(int j = 0; j < num; j++) cout << "*";
      cout << endl;
   }

   return 0;
}