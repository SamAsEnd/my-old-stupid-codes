#include <iostream>
#include <cstdlib>
using namespace std;

bool isPrime(int n){

	if(n % 2 == 0 || n == 2 || n >= 10000)
		return false;
	
	for(int i = 3; i < n; i++){
		if(n % i == 0) 
			return true;
	}
		
	return false;
}

int main(){

	int n = 0;
	cout << "Enter a number less than 10,000: " << endl;
	cin >> n;

	while( n >= 10000){
		cout << "Try again: ";
		cin >> n;
	}

	cout << isPrime(n) << endl;
	system("PAUSE");
	return 0;
}
