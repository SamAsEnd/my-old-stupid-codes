#include<iostream.h>
void main()
{	 double pro=1;
	for(int x=1;x<=20;x++)
	{
		pro*=x;
		cout<<x<<" * ";
	}
	cout<<"\b\b = "<<pro; // \b is back space 2 remove z last +
}

