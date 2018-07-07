#include<iostream.h>
void main(){
	float r, v, sA ;
	const double Pi=3.14159265;
	cout<<"Enter the radius:\t";
	cin>>r;
	
	v=(0.75)*Pi*r*r*r;
	sA=4*Pi*r*r;
	
	cout<<"Volume = "<<v<<"\nSurface Area = "<<sA;
	}