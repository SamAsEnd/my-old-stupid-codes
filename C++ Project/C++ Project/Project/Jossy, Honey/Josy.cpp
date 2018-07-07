#include <iostream.h>
#include <conio.h>
#include <string.h>
#include <fstream.h>

struct EMP
{
	char Name[25];
	unsigned Salary;
};
EMP employe[1000];
char temp[25];
unsigned Number_Of_employe=0;


void Menu();
void Add();
void View();
void Delete();
void Load();
void Save_To_File();
int Check_Name(char temp[25],int Index_Of_Array);
void main()
{ 
	Menu();
	clrscr();
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"||********** WELCOME TO  SALARY MANAGEMENT **********************************||\n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"\n||                        * Program termineted *                             ||";
	}
void Menu()
{
	char Main_Menu_Choose;
	clrscr();
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"||********** WELCOME TO  SALARY MANAGEMENT ***********************************||\n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"\n\t\t\tPress 0  ---  To Exit\n";
	cout<<"\n\t\t\tPress 1  ---  To Add new Employe\n";
	cout<<"\n\t\t\tPress 2  ---  To View All Employe with salary\n";
	cout<<"\n\t\t\tPress 3  ---  To Delete Employe\n";
	cout<<"\n\t\t\tPress 4  ---  To Load from file\n";
	cout<<"\n\t\t\tPress 5  ---  To Save to file\n";
	cout<<"\n\t\t\t    -----> ";
	cin>>Main_Menu_Choose;
	cin.ignore();
	switch (Main_Menu_Choose)
	{
		case '0':
			break;
		case '1':
			Add();
			break;
		case '2':
			View();
			break;
		case '3':
			Delete();
			break;
		case '4':
			Load();
			break;
		case '5':
			Save_To_File();
			break;

		default:
			cout<<"\n\t Incorrect choose\n\t";
			cout<<"Press any key to continue . . . ";
			getch();
			Menu();
		}
	}

void Add()
{
	char ch;
	clrscr();
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"||******************* Adding Employe *****************************************||\n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"\t\t  Enter the full name of the employe:    ";
	cin.getline(employe[Number_Of_employe].Name,25);
	while(strcmp(employe[Number_Of_employe].Name,temp)==0)
	{
		cout<<"\t\t  Enter again:   ";
		cin.getline(employe[Number_Of_employe].Name,25);
		}
	if(Check_Name(employe[Number_Of_employe].Name,Number_Of_employe)!=-1)
	{
		cout<<"\t\t The Name is used by another Employeer\npress any key to enter again";
		getch();
		Add();
		}
	cout<<"\t\t  Enter the salary for \""<<employe[Number_Of_employe].Name<<"\":    ";
	cin>>employe[Number_Of_employe].Salary;
	cin.ignore();
	Number_Of_employe++;
	cout<<"\n\n\t\t"<<employe[Number_Of_employe-1].Name<<" is added successfully\n\t\t";
	cout<<"do you want to add another Employe?\n\t\tpress   \"Y\" for YES or \"N\" for NO\n";
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
	{
		clrscr();
		Add();
		}
	else
		Menu();
	}
void View()
{
	int temp=Number_Of_employe-1;
	clrscr();
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"||******************* View Employes ******************************************||\n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"   Employe Name\t\t\t\tSalary\n";
	cout<<"   ============\t\t\t\t======\n";
	if(temp>=0)
	{
		for(int i=0;i<Number_Of_employe;i++)
		{
			cout<<"\t"<<employe[i].Name<<"\t\t\t\t"<<employe[i].Salary<<"\n";
			}
		}
	else
		cout<<"\t\t No Employe Avalable!!";
	cout<<"\nPress any key to continue . . . ";
	getch();
	Menu();
	}
void Delete()
{
	char empty[25];
	int t;
    clrscr();
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	cout<<"||******************* Delete Employes ****************************************||\n";
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
	for(int i=0;i<Number_Of_employe;i++)
	{
		cout<<"\n\t -=> "<<employe[i].Name;
		}
	cout<<"\n\t\tEnter the employe name:    ";
	cin.getline(temp,25);
	while(strcmp(empty,temp)==0)
	{
		cout<<"\t\t  Enter again:   ";
		cin.getline(temp,25);
		cin.ignore();
		}
	t=Check_Name(temp,Number_Of_employe);
	if(t==-1)
	{
		cout<<"\t\tNo Employe Avalable With This Name\n";
		}
	else
	{
		for(int i=t;i<=Number_Of_employe;i++)
		{
        	if((i+1)==Number_Of_employe)
			{
				strcpy(employe[i].Name,empty);
				employe[i].Salary=0;
			}
			else
			{
				strcpy(employe[i].Name,employe[i+1].Name);
				employe[i].Salary=employe[i+1].Salary;
			}
		}
		Number_Of_employe--;
		cout<<"\t\tThe Employe Is Successfully DELETED!!!\n\t\t";
	}
	cout<<"Do you want to DELETE another Employe?\n\t\tpress   \"Y\" for YES or \"N\" for NO\n";
	char ch;
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
	{
		clrscr();
		Delete();
		}
	else
		Menu();
}
void Load()
{
	ifstream IN;
	IN.open("Employe.txt");
	if(IN.fail())
	{
		cout<<"\t\tNO file recorded yet . . . ";
		getch();
		Menu();
		}
	else if(IN.bad())
	{
		cout<<"\t\tFile could not be accessed . . . ";
		getch();
		Menu();
		}
	else
	{
		clrscr();
		cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
		cout<<"||******************* LOAD FROM FILE *****************************************||\n";
		cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
		while(!IN.eof())
		{
			IN.getline(employe[Number_Of_employe].Name,25,'-');
			IN>>employe[Number_Of_employe].Salary;
			IN.ignore();
			if(Check_Name(employe[Number_Of_employe].Name,Number_Of_employe)==-1)
			Number_Of_employe++;
			}
		IN.close();
		Number_Of_employe--;
		cout<<"\t\tDone";
		cout<<"\nPress any key to continue . . . ";
		getch();
		Menu();
	}
}
void Save_To_File()
{
	ofstream OUT;
	OUT.open("Employe.txt");
	if(OUT.fail())
	{
		cout<<"\t\tFailed To Save to file . . . ";
		getch();
		Menu();
		}
	else if(OUT.bad())
	{
		cout<<"\t\tFile could not be accessed . . . ";
		getch();
		Menu();
		}
	else
	{
		clrscr();
		cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
		cout<<"||******************* SAVE TO FILE *******************************************||\n";
		cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";

		for(int i=0;i<=Number_Of_employe-1;i++)
		{
			OUT<<employe[i].Name<<"-"<<employe[i].Salary<<endl;
		}
		cout<<"\t\tDone";
		cout<<"\nPress any key to continue . . . ";
		getch();
		Menu();
	}
}
int Check_Name(char temp[25],int Index_Of_Array)
{
	for(int i=0;i<=Index_Of_Array-1;i++)
	{
		if(strcmp(employe[i].Name,temp)==0)
			return i;
		}
		return -1;
}










