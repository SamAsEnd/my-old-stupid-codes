#include <iostream>
using namespace std;

int main(){

	int x = 1;

	cout << "Enter the size of the dynamic array: ";
	cin >> x;

	while(x <= 0){
		cout << "Invalid entry.  Try again: ";
		cin >> x;
	}

	int* p = new int[x];

	for(int i = 0; i < x; i++){
		cout << "Enter p[" << i << "]: ";
		cin >> p[i];
	}

	cout << "Thank you!" << endl;

	for(i = 0; i < x; i++)
		cout << p[i] << " " << endl;

	return 0;
}