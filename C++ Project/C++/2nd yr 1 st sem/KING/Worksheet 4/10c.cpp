#include<iostream.h>
void main()
{
	double sum=0;
	for(int x=1;x<=15;x++)
	{
		double y=(1.0/x);
		sum+=y;
		cout<<y<<" + ";
	}
	cout<<"\b\b = "<<sum; // \b is back space 2 remove z last +
}
