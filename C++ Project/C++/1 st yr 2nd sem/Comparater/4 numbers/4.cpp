#include <iostream.h>
void main ()
{
	double a,b,c,d;

	cout<<"Enter the first numbers: \n";
	cin>>a;
	cout<<"Enter the second numbers: \n";
	cin>>b;
	cout<<"Enter the third numbers: \n";
	cin>>c;
	cout<<"Enter the fourth numbers: \n";
	cin>>d;

	a=(a>d?a:d);

	if (a>b)
	{
		  if (a>c)
		  cout<<"The LARGER number is: \n"<<a;
		  else
		  cout<<"The LARGER number is: \n"<<c;
		 }
	else
	{
		  if (b>c)
		  cout<<"The LARGER number is: \n"<<b;
		  else
		  cout<<"The LARGER number is: \n"<<c;
		  }
}
