#include <iostream>
using namespace std;

int main(){

//regular int variables:
int x=0, y=5;

//pointers to those variables:
int *a, *b;

//assign the addresses:
a = &x;
b = &y;

//dereference the pointers to get the values:
cout << *a << "  " << *b << endl;
system("PAUSE");
return 0;
}
