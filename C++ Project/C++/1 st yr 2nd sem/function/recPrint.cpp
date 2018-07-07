#include <iostream>
using namespace std;

void Print(int n){

	if(n < 1) return;

	Print(n-1);

	cout << n << endl;

};

int main(){

	Print(5);
	return 0;
}