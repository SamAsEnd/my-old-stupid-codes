#include<iostream.h>
#include<conio.h>
void main()
{
	for (int i=100;i>0;i--)
	{
			double c,f;
			cout<<"Enter a temperature in degrees celsius:    ";
			cin>>c;
			f=((double)9/5)*c+32;
			cout<<endl<<"In fahrenheit that is:                     "<<f<<endl;

			cout<<"Press Enter to continue"<<endl;
			getch();
			clrscr();
	 }
}
