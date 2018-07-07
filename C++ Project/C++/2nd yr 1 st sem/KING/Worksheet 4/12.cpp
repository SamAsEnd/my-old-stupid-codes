#include<iostream.h>
void main()
{    A:
	int n,m,sum;
	cout<<"Enter the number:\t";
	cin>>n>>m;

	while(n>9)
		n=n/10;

	while(m>9)
		m=m/10;

	sum=n+m;

   cout<<"Sum = "<<sum<<endl;
   goto A;
}
