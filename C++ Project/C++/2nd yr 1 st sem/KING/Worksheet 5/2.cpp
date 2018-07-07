#include<iostream.h>
float triangle(int h, int w);
void main()
{
	int n,m;
	cout<<"Enter the height:\t";
	cin>>n;
	cout<<"Enter the weight:\t";
	cin>>m;
	
	cout<<"\nThe Area is "<<triangle(n,m);
}
float triangle(int h, int w)
{
	return (0.5*h*w);
}
