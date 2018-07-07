#include<iostream.h>
void main(){
	float r1, r2, R;
	cout<<"Enter z first risistance (R1):\t";
	cin>>r1;
	cout<<"Enter z second risistance (R2):\t";
	cin>>r2;
	
	R=(r1*r2)/(r1+r2);
	
	cout<<"Resistance = "<<R;
	}