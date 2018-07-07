#include<iostream.h>
void main()
{

	for(int n,c=0,x=1,sum=0;x<=10;x++)
	{
			cout<<"Enter the "<<x;
			if(x==1)cout<<"st";
			else if(x==2)cout<<"nd";
			else if(x==3)cout<<"rd";
			else cout<<"th";
			cout<<" number:\t";
			cin>>n;
			while(n<0 || n>100){
				cout<<"\tERROR number must b b/n 0 nd 100:\t";
				cin>>n;
				}

			if(n>50) c++;
	}
	cout<<endl<<c<<" numbers are g8ter dan 50";
}