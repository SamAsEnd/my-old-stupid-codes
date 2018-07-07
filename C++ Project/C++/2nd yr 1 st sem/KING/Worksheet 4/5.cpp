#include<iostream.h>
void main()
{
	int n;
	cout<<"Enter the number:\t";
	cin>>n;
	cout<<"   Reverse digit:\t";
	for(;n>0;)
	{
		cout<<(n%10);
		n/=10;
	}
}