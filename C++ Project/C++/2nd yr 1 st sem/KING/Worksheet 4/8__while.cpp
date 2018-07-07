#include<iostream.h>
void main()
{
	int sum=0,x=0;
	int j=2;
  while(j<100)
	{
		int i=2;
		while(i<j)
		{
			if (j%i==0) x=1;
			i++;
		}
		if(x==0)
		{
			sum+=j;
	//    Uncomment the below comment 2 c the prime numbers 
	// 	cout<<j<<"    ";
		}
		else x=0;
		j++;
	}
	cout<<"\nThe sum is "<<sum;
}