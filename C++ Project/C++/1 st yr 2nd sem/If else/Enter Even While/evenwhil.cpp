#include<iostream.h>
#include<conio.h>
void main()
{
	for (int i=100;i>0;i--)
	{
   int num;
   cout << "Give me any even number: ";
   cin >> num;

	while(num % 2 == 1)
	{
      cout << "Not even, try again: ";
      cin >> num;
   }

	cout << "Right!  You entered: " << num << endl;

		 cout<<"Press Enter to continue"<<endl;
		 getch();
		 clrscr();
	 }
}
