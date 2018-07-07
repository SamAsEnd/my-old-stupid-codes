#include<iostream.h>
void main()
{
	for(int x=1,sum=0;x<=100;x++)
	{
		sum+=x;
		cout<<x<<" + ";
	}
	cout<<"\b\b = "<<sum; // \b is back space 2 remove z last +
}
