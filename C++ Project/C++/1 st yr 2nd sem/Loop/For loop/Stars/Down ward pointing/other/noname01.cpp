#include<iostream.h>
void main()
{
	 int j,i,max;
	 cout<<"Enter the raw!";
	 cin>>max;
	 for(i=max;i>=1;i--)
	 {
			for(j=max;j>=1+5-i;j--)
			cout<<"* ";
	 cout<<endl;
	 }
}