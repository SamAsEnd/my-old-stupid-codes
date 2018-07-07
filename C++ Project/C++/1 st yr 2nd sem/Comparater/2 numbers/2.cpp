#include <iostream.h>
int main ()
{
	double a,b,c;

	cout<<"Enter the first numbers: \n";
	cin>>a;
	cout<<"Enter the other numbers: \n";
	cin>>b;
	cout<<"The LARGER number is: \n"<<(c = (a>b) ? a : b);
	return 0;
}          
