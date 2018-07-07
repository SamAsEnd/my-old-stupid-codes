#include<iostream.h>
void main()
{
	char ch;
	for(int i=0, j=65;i<=5;i++)
	{
		for(int x=i;x>=0;x--,j++)
		{
			ch=j;
			cout<<ch;
		}
		cout<<endl;
	}
}

