#include <iostream.h>
void main()
{
	int max=-32000,num,i;
	cout<<"How many numbers u want to compare:  ";
	A:
	cin>>i;
	if(i<2)
	{
		cout<<"Number must be atleast 2\nEnter again:  ";
		goto A;
	}
	cout<<"Enter the numbers:  \n";

	while(i>0)
	{
		cout<<i--<<"  numbers left:  -  ";
		cin>>num;
		if(max<num)
			max=num;	
	}
	cout<<"\nThe max is   "<<max;
}