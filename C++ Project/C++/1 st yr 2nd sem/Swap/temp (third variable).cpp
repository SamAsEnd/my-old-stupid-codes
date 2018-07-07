#include<iostream.h>
void main ()
{
	 int a,b;

	 cout<<"Enter the first:    ";
	 cin>>a;
	 cout<<"Enter the second:    ";
	 cin>>b;

	 int temp=a;
	 a=b;
	 b=temp;

	 cout<<"First number is:    "<<a<<endl;
	 cout<<"Second number is:    "<<b<<endl;
}

