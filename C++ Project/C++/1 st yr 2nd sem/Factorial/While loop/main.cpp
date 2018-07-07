#include <iostream>
#include <conio.h>
using namespace std;
int main()
{
    for(int i=1; i>0; i++)
    { 
			clrscr();
			double fact=1, n;
			cout << "                             Factorial calculator\n\n";
			cout << "********************************************************************************\n\n";
			cout << "       Enter the number you want:     ";
			cin >> n;
			while (n>1)
			{
				 fact=fact*n;
				 --n;
			}
			cout << "                                      "<<fact<<endl;
	}
    system("PAUSE");
    return EXIT_SUCCESS;
}
