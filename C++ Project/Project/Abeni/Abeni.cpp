#include <iostream.h>
#include <time.h>
#include <conio.h>
#include <stdlib.h>
#include <fstream.h>
#include <string.h>
void main()
{
	unsigned long Starting_Time,Current_Time;
	char Answer[10];
	strcpy(Answer,"ABCDABCDAB");
	int No_Of_Q=1;
	char User_Answer[10];
	int Correct_Ansewed=0;
	char temp[50];
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"                        C++ testing software                                   \n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"\nYou have 10 sec to answer each question\npress any key to start the test . . .  ";
	ifstream fin;
	fin.open("Q.txt");
	if(fin.fail())
	{
		cerr<<"      Failed to load file\n";
		exit(1);
	}
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
		fin.getline(temp,25,'~');
		cout<<temp;
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
	fin.close();
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




