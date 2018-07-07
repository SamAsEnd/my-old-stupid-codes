#include<iostream.h>
void main(){
	float m, h, v, PE, KE;
	const float g=9.81;
	cout<<"Enter \"Mass\":\t";
	cin>>m;
	cout<<"Enter \"Velosity\":\t";
	cin>>v;
	cout<<"Enter \"Height\":\t";
	cin>>h;
	
	PE=m*g*h;
	KE=(0.5)*m*v*v;
	cout<<"PE = "<<PE<<endl;
	cout<<"KE = "<<KE;
	}