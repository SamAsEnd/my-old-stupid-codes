#include<iostream.h>
void main()
{
	int n,sum=0;
	cout<<"Enter the number:\t";
	cin>>n;
	for(;n>0;n/=10) sum+=(n%10);
	cout<<"Sum of ze digit = "<<sum;
}