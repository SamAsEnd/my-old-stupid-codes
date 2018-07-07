#include<iostream.h>
#include<conio.h>
void main()
{
	for (int i=100;i>0;i--)
	{
			double f,c;
			cout<<"Enter a temperature in degrees fahrenheit:    ";
			cin>>f;

			c=(f-32)*5/9;

			cout<<endl<<"In celsius that is:                           "<<c<<endl;

			cout<<"Press Enter to continue"<<endl;
			getch();
			clrscr();
	 }
}
