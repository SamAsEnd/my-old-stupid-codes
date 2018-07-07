#include <iostream.h>
void main()
{
	int num[10];
	for(int i=0;i<10;i++)
	{
		cout<<"Enter a number : ";
		cin>>num[i];
	}
	for(i=0;i<10;i++)
	{
		for(int j=i+1;j<10;j++)
		{
			if(num[i]<num[j])
			{
				int temp=num[j];
				num[j]=num[i];
				num[i]=temp;
			}
		}
	}
	for(i=0;i<10;i++)
	  	cout<<num[i]<<"  ";
}
