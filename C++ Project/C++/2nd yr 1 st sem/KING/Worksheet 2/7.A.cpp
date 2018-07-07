#include<iostream.h>
void main(){
	int y, m, w, d, n;
	/*             
		y stands 4 Year
		m stands 4 Month
		w stands 4 Weeek
		d stands 4 Day
		
		n is the number of days the user enterd!!!
	*/
	
	cout<<"Enter the day:\t";
	cin>>n;
	
	y=n/365;
	n%=365;
	
	m=n/30;
	n%=30;
	
	w=n/7;
	n%=7;
	
	d=n;
	
	cout<<"Year = "<<y<<endl;
	cout<<"Month = "<<m<<endl;
	cout<<"Week = "<<w<<endl;
	cout<<"Day = "<<d;
	}