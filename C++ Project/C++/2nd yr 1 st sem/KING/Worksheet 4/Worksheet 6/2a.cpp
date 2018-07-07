#include <iostream.h>
void main()
{
	int num[10],min,max;
	for(int i=0;i<10;i++)
	{
		cout<<"Enter a number : ";
		cin>>num[i];
		if(i==0) min=max=num[i];
		if(min>num[i]) min=num[i];
		if(max<num[i]) max=num[i];
	}
	cout<<"The largest number is:  "<<max<<endl;
	cout<<"The smallest number is:  "<<min;
}
	