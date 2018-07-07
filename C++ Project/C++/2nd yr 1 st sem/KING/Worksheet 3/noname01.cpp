#include <iostream.h>
void main(){
	float mid, final,total;

	cout<<"enter the \mid\";
	cin>>mid;
	cout<<"enter the \final\";
	cin>>final;

	total= mid + final;


	if (total>100)
	cout<<"error";
	else if(total>85)
	cout<<"A";
	else if(total>75)
	cout<<"B";
	else if(total>65)
	cout<<"C";
	else if(total>57)
	cout<<"D";
	else if (total>50)
	cout<<"E";
	else
	cout<<"F";
	}