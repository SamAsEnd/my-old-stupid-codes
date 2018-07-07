//  for loop to print out index
#include <iostream.h>


int main(){
   int times;
   cout << "How many times? ";
   cin >> times;

   if(times < 0 || times >= 50);

   for(int i = 1; i <= times; i++){
      cout << i << endl;
   }
   return 0;
}