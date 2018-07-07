#include <iostream>
using namespace std;

int f(int n){

	int ans = 1;

	for(int i = 2; i <= n; i++){
		ans *= i;
	}

	return ans;
}

int main(){

	int n = 0;
	cout << "Enter a number less than 10: " << endl;
	cin >> n;

	while( n >= 10){
		cout << "Try again: ";
		cin >> n;
	}

	cout << f(n) << endl;

	return 0;
}