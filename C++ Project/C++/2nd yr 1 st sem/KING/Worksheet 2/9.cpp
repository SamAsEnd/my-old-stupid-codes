#include<iostream.h>
void main(){
	float s, u, t, a;
	cout<<"Enter \"U\":\t";
	cin>>u;
	cout<<"Enter \"T\":\t";
	cin>>t;
	cout<<"Enter \"A\":\t";
	cin>>a;
	
	s=(u*t)+((0.5)*a*t*t);
	
	cout<<"Displacement = "<<s;
	}