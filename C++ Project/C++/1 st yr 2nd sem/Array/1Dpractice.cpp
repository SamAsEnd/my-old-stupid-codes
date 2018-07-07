#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int main(){

    //guarentees a new random each time:
	srand(time(0));

    //declare the array:
	int myarr[10];

    //loop to assign the values to the array:
	for(int i = 0; i < 10; i++)
		myarr[i] = rand()%10+1;

    //print out the values:
	for(int j = 0; j < 10; j++)
		cout << myarr[j] << " ";

return 0;
}
