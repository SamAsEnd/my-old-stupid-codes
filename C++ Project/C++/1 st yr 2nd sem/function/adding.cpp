#include <iostream>
using namespace std;

int add( int a, int b);

int main(){
	int n1 = 5, n2 = 6;
	cout << add(n1,n2) << endl;
	cout << n1 << endl;
	return 0;
}

int add( int a, int b ){
	int sum = a+b;
	a = 7;
	return a+b;
}