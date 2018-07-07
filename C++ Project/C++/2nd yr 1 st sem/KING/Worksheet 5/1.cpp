#include<iostream.h>
int cube(int x);
void main()
{
	int num;
	cout<<"Enter a number: \t";
	cin>>num;
	cout<<"\nThe cube is "<<cube(num);
}
int cube(int x)
{
	return (x*x*x);
}
