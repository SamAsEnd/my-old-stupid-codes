#include<iostream.h>
void main()
{
	for(int x=5,sum=0;x<=50;x+=5)
	{
		sum+=x;
		cout<<x<<" + ";
	}
	cout<<"\b\b = "<<sum; // \b is back space 2 remove z last +
}
