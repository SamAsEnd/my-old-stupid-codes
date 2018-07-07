#include<iostream.h>
int c=0;
void test(int test){
	if(test>=2)
		cout<<" , ";
	if(test==1)
		cout<<" and ";
	c--;
	}
void S(int x){
	if(x==1)
	cout<<"  ";
	else
	cout<<"s ";
	}
void main(){
	int y, m, w, d, n, Or;
	/*
		y stands 4 Year
		m stands 4 Month
		w stands 4 Weeek
		d stands 4 Day
		
		n is the number of days the user enterd!!!
	*/

	cout<<"Enter the day:\t";
	cin>>n;
	Or=n;
	y=n/365;
	n%=365;
	if(y!=0)
	c++;
	
	m=n/30;
	n%=30;
	if(m!=0)
	c++;
	
	w=n/7;
	n%=7;
	if(w!=0)
	c++;
	
	d=n;
	
	cout<<Or<<" days is equal to ";
	if(y!=0){
	cout<<y<<" year";
	S(y);
	test(c);
	}
	if(m!=0){
	cout<<m<<" month";
	S(m);
	test(c);
	}
	if(w!=0){
	cout<<w<<" week";
	S(w);
	test(c);
	}
	if(d!=0){
	cout<<d<<" day";
	S(d);
	test(c);
	}
}