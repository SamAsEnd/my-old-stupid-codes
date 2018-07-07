#include<iostream.h>
#include<math.h>
void main(){
	int x, y, z, result;
	cout<<"Enter X:   ";
	cin>>x;
	cout<<"Enter Y:   ";
	cin>>y;
	cout<<"Enter Z:   ";
	cin>>z;
	
	result=((2*x)+sqrt((y*y)+(4*x*y)))/(2*z);
	
	cout<<"Result = "<<result;
	}