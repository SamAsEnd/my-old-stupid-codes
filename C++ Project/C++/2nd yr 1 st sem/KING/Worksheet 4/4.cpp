#include<iostream.h>
void main()
{
	int n;
	long fact=1;
	cout<<"Enter the number:\t";
	cin>>n;
			while(n<0) cin>>n;  //Error preventetion
	if (n==0);
	else if (n==1);
	else for(;n>1;n--)fact*=n;
	cout<<"Factorial = "<<fact;
}