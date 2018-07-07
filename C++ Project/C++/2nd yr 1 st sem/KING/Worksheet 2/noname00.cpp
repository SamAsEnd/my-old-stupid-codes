#include<iostream.h>
void main()
{
	int n,x=0;
	cout<<"Enter the number:\t";
	cin>>n;
	for(int i=2;n>=i;i++)
	{
		for(int j=2;n>=j;j++)
		{
			if(n/j==0)
				x=1;
		}
	}
	cout<<"The number is";
	if(x!=0)cout<<" NOT";
	cout<<" PRIME!";
}
