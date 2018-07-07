#include<iostream.h>
void main(){
	long h, m, s, n;
	/*             
		h stands 4 Hour
		m stands 4 Minute
		s stands 4 Second
		
		n is the number of days the user enterd!!!
	*/
	
	cout<<"Enter the day:\t";
	cin>>n;
	
	h=n*24;
	m=h*60;
	s=m*60;
	
	cout<<"Hour = "<<h<<endl;
	cout<<"Minute = "<<m<<endl;
	cout<<"Second = "<<s<<endl;
	}