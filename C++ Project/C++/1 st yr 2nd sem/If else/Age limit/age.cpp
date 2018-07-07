/*

This is tut for if else

	 Samson Endale
	 CSED

*/
#include<iostream.h>
#include<conio.h>
void main()
{
	for (int i=100;i>0;i--)
	{
		 int age;

		 cout<<"What is your age: \n";
		 cin>>age;

		 if (age<18)
				cout << "You are not allowed!!!" << endl;
		 else
				cout << "You passed." << endl;

		 cout<<"Press Enter to continue"<<endl;
		 getch();
		 clrscr();
	 }
}

