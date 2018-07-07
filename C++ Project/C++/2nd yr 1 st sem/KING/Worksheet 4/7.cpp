#include<iostream.h>
void main()
{
	int n,x=0;
	cout<<"Enter the number:\t";
	cin>>n;
	for(int i=2;n>i;i++)
	{
		if(n%i==0) x=1;
	}
	cout<<"The number is";

	if(x==1)
		cout<<" NOT";

	cout<<" PRIME!";
}


