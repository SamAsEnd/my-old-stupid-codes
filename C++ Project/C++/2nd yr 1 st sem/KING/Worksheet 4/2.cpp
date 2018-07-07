#include<iostream.h>
void main()
{
	int n;
	cout<<"Enter a number:\t";
	cin>>n;
		while(n<0){
			cout<<"\tNumber must b +ve integer\nTRY AGAIN:  ";
			cin>>n;
			}
	for(int x=0,sum=0;x<=n;x++)
	{
		if(x%2==0)
		sum+=x;
	}
	cout<<"Sum = "<<sum;
}
