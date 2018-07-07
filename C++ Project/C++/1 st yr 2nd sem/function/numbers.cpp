#include <iostream>
using namespace std;

void dbl(int& a, int& b){
	a*= 2;
	b*= 2;
}

void trip(int a, int b){
	a*=3;
	b*=3;
}

int main(){

int x = 4, y = 6;

cout << "AT START:" << endl;
cout << "x= " << x << " y= " << y << endl;

//call the dbl functon:
dbl(x,y);

cout << "AFTER DBL CALL:" << endl;
cout << "x= " << x << " y= " << y << endl;

//call the trip functon:
trip(x,y);

cout << "AFTER TRIP CALL:" << endl;
cout << "x= " << x << " y= " << y << endl;
cin.get();
return 0;
}
