#include <iostream.h>
#include <time.h>
#include <conio.h>
void Q(int x)
{
	switch (x)
	{
		case 1:
			cout<<"int x=0;\nx+=x++;\nx= ";
			break;
		case 2:
			cout<<"int x=5;\nx/=5;\nx+=++x;\nx= ";
			break;
		case 3:
			cout<<"int x=4;\nx+=x--;\nx= ";
			break;
		case 4:
			cout<<"int x=9;\nx=x%5;\nx= ";
			break;
		case 5:
			cout<<"int x=65;\nx=x%10;\nx= ";
			break;
		case 6:
			cout<<"int x=13;\nx=x%10;\nx+=x++;\nx+=x++;\nx+=x++;\nx= ";
			break;
		case 7:
			cout<<"int x=65;\nx=x%9;\nx+=5= ";
			break;
		case 8:
			cout<<"int x=7;\nx+=x++;\nx= ";
			break;
		case 9:
			cout<<"int x=3;\nx*=3;\nx= ";
			break;
		case 10:
			cout<<"int x=10,y=10,z;\nif(x>y)\n{\n\tz=2*y;\n}\nelse\n{\n\tz=3*x;\n}\nz= ";
			break;
		}
}
void main()
{
	unsigned long Starting_Time,Current_Time;
	const int Answer[10]={1,2,3,4,5,6,7,8,9,30};
	int No_Of_Q=1;
	int User_Answer[10];
	int Correct_Ansewed=0;
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"                        C++ testing software                                   \n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"\nYou have 10 sec to answer each question\npress any key to start the test . . .  ";
	getch();
	Starting_Time=Current_Time=time(0);
	int y=0;

	while(Current_Time-Starting_Time<100)
	{
		clrscr();
		cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
		cout<<"                        C++ testing software                                   \n";
		cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
		cout<<"Questin number "<<No_Of_Q<<":"<<endl;
		Q(No_Of_Q);
		cin>>User_Answer[No_Of_Q-1];
		if(User_Answer[No_Of_Q-1]==Answer[No_Of_Q-1])
			Correct_Ansewed++;

		if(No_Of_Q>=10)
		{
			cout<<"Done\nPress any key to continue . . . ";
			getch();
			y=1;
			break;
			}
		No_Of_Q++;
		Current_Time=time(0);
	}
	clrscr();
    cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"                        C++ testing software                                   \n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n\t";
	if(y==0){
		cout<<"Time up!!!!!";
		--No_Of_Q;
		}
	else
		cout<<"Good timing!!!!";
		cout<<"\n";
	cout<<"\n You answerd "<<Correct_Ansewed<<" out of "<<No_Of_Q;
	}




