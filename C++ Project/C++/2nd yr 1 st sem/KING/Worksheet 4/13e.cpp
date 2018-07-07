#include<iostream.h>
void main()
{
	for(int i=0;i<=5;i++)
	{
   	for(int j=i;j<=5;j++)
		{
			cout<<" ";
		}
		for(int k=(i*2+1);k>0;k--)
		{
			cout<<"*";
		}
		cout<<endl;
	}
}

