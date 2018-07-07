#include<iostream.h>
void main()
{
	int sum=0,x=0;
	for (int j=2;j<100;j++)
	{
		for(int i=2;i<j;i++)
		{
			if (j%i==0) x=1;
		}
		if(x==0)
		{
			sum+=j;
	//    Uncomment the below comment 2 c the prime numbers 
	//		cout<<j<<"    ";
		}
		else x=0;
	}
	cout<<"\nThe sum is "<<sum;
}