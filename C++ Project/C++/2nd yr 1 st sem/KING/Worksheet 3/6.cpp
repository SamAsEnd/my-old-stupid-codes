#include <iostream.h>
void main(){
	float w,h,normal;

	cout<<"Enter weight:\t";
		cin>>w;
	cout<<"Enter height:\t";
		cin>>h;

	normal=w/(h*h);

	cout<<"You are ";

	if(normal>25)
		cout<<"OVER WEIGHT!";
	else if(normal<18)
		cout<<"BELOW WEIGHT!";
	else
		cout<<"Normal!";
}