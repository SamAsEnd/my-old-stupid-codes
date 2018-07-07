//  decides whether input is even or odd
#include <iostream>
void main()
{
   int num;
   cout << "Give me any number: ";
   cin >> num;

	if (num % 2 == 0)
	{
       cout << "It's even!" << endl;
	}
	else
	{
       cout << "It's odd!" << endl;
	}
}

