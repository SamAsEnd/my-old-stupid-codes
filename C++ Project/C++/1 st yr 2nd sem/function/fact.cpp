#include <iostream>
#include <conio.h>
using namespace std;

int fact( int n ){

	//base case:
	if( n == 1 || n == 0 ) return 1;

	return n * fact(n-1);
}

int main(){
	int n = 0;
	cout << "Enter a number to find the factorial: ";
	cin >> n;

        cout << fact(n) << endl;
	getch();
    return 0;
}
