#include<iostream.h>
void main()
{
	char ch;
	for(int i=0;i<=5;i++)
	{
		for(int j=65;j<=(i+65);j++)
		{
			ch=j;
			cout<<ch;
		}
		cout<<endl;
	}
}

