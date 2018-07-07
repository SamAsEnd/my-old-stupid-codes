#include <iostream.h>
#include <conio.h>
void main()
{
	for (int i=100;i>0;i--)
	{
	int num;
	cout << "Give me any number: ";
	cin >> num;

	if (num % 2 == 0)
		 cout << "It's even!" << endl;
	else
		 cout << "It's odd!" << endl;
	cout<<"Press Enter to continue"<<endl;
	getch();
	clrscr();
}}

