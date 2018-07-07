#include<iostream.h>
void main()
{
	int sum=0,x=0;
	int j=2;
	do
	{
		int i=2;
		do
		{
			if (j%i==0) x=1;
			if (j==2) x=0;
			i++;
		}
		while(i<j);
		if(x==0)
		{
			sum+=j;
	//    Uncomment the below comment 2 c the prime numbers 
	cout<<j<<"    ";
		}
		else x=0;
		j++;
	}
	while(j<100);
	cout<<"\nThe sum is "<<sum;
}