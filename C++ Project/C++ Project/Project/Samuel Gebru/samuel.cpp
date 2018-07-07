/*******************************************************************************
*     GROUP MEMBER		         ID NUMBER				L           ~~~~~~~~~~**
*    _____________              ___________           A       G     ~~~~~~~~~***
*    SAMUEL   GEBRU............0401379              T       N       ~~~~~~~~****
*    SEMIRA       ............                    N       I  	    ~~~~~~~*****
*	 SOFIYA HUSSEN............             	    E	    M     T     ~~~~~~******
*                                             M   F   A    C        ~~~~~*******
*                                           D   O   G    E          ~~~~********
*                                         N       O    J            ~~~*********
*                                       U       R    R              ~~**********
*                                     F       P    P                ~***********
*                                                                    i/o file  *
*******************************************************************************/
#include <iostream.h>
#include <fstream.h>
#include <conio.h>
#include <string.h>

struct employe
{
	char Name[25];
	unsigned Salary;
};

employe User[1000];
char temp[25];
unsigned Number_Of_User=0;


void Start();
void Add_Employe();
void View_All_Employe();
void Delete_Employe();
void Load_From_File();
void Save_To_File();
int Check_Name(char temp[25],int Index_Of_Array);
void main()
{ 
	Start();
	clrscr();
	cout<<"||***************************************************************************||\n";
	cout<<"||***************************************************************************||\n";
	cout<<"||********** WELCOME TO  SALARY MANAGEMENT **********************************||\n";
	cout<<"||***************************************************************************||\n";
	cout<<"||***************************************************************************||\n";
	cout<<"\n||                        * Program termineted *                             ||";
	}
void Start()
{
	char Main_Menu_Choose;
	clrscr();
	cout<<"||****************************************************************************||\n";
	cout<<"||****************************************************************************||\n";
	cout<<"||********** WELCOME TO  SALARY MANAGEMENT ***********************************||\n";
	cout<<"||****************************************************************************||\n";
	cout<<"||****************************************************************************||\n";
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
			Add_Employe();
			break;
		case '2':
			View_All_Employe();
			break;
		case '3':
			Delete_Employe();
			break;
		case '4':
			Load_From_File();
			break;
		case '5':
			Save_To_File();
			break;

		default:
			cout<<"\n\t Incorrect choose\n\t";
			cout<<"Press any key to continue . . . ";
			getch();
			Start();
		}
	}

void Add_Employe()
{
	char ch;
	clrscr();
	cout<<"||****************************************************************************||\n";
	cout<<"||******************* Adding Employe *****************************************||\n";
	cout<<"||****************************************************************************||\n";
	cout<<"\t\t  Enter the full name of the employe:    ";
	cin.getline(User[Number_Of_User].Name,25);
	while(strcmp(User[Number_Of_User].Name,temp)==0)
	{
		cout<<"\t\t  Enter again:   ";
		cin.getline(User[Number_Of_User].Name,25);
		}
	if(Check_Name(User[Number_Of_User].Name,Number_Of_User)!=-1)
	{
		cout<<"\t\t The Name is used by another Employeer\npress any key to enter again";
		getch();
		Add_Employe();
		}
	cout<<"\t\t  Enter the salary for \""<<User[Number_Of_User].Name<<"\":    ";
	cin>>User[Number_Of_User].Salary;
	cin.ignore();
	Number_Of_User++;
	cout<<"\n\n\t\t"<<User[Number_Of_User-1].Name<<" is added successfully\n\t\t";
	cout<<"do you want to add another Employe?\n\t\tpress   \"Y\" for YES or \"N\" for NO\n";
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
	{
		clrscr();
		Add_Employe();
		}
	else
		Start();
	}
void View_All_Employe()
{
	int temp=Number_Of_User-1;
	clrscr();
	cout<<"||****************************************************************************||\n";
	cout<<"||******************* View Employes ******************************************||\n";
	cout<<"||****************************************************************************||\n";
	cout<<"   Employe Name\t\t\t\tSalary\n";
	cout<<"   ============\t\t\t\t======\n";
	if(temp>=0)
	{
		for(int i=0;i<Number_Of_User;i++)
		{
			cout<<"\t"<<User[i].Name<<"\t\t\t\t"<<User[i].Salary<<"\n";
			}
		}
	else
		cout<<"\t\t No Employe Avalable!!";
	cout<<"\nPress any key to continue . . . ";
	getch();
	Start();
	}
void Delete_Employe()
{
	char empty[25];
	int t;
    clrscr();
	cout<<"||****************************************************************************||\n";
	cout<<"||******************* Delete Employes ****************************************||\n";
	cout<<"||****************************************************************************||\n";
	for(int i=0;i<Number_Of_User;i++)
	{
		cout<<"\n\t -=> "<<User[i].Name;
		}
	cout<<"\n\t\tEnter the employe name:    ";
	cin.getline(temp,25);
	while(strcmp(empty,temp)==0)
	{
		cout<<"\t\t  Enter again:   ";
		cin.getline(temp,25);
		cin.ignore();
		}
	t=Check_Name(temp,Number_Of_User);
	if(t==-1)
	{
		cout<<"\t\tNo Employe Avalable With This Name\n";
		}
	else
	{
		for(int i=t;i<=Number_Of_User;i++)
		{
        	if((i+1)==Number_Of_User)
			{
				strcpy(User[i].Name,empty);
				User[i].Salary=0;
			}
			else
			{
				strcpy(User[i].Name,User[i+1].Name);
				User[i].Salary=User[i+1].Salary;
			}
		}
		Number_Of_User--;
		cout<<"\t\tThe Employe Is Successfully DELETED!!!\n\t\t";
	}
	cout<<"Do you want to DELETE another Employe?\n\t\tpress   \"Y\" for YES or \"N\" for NO\n";
	char ch;
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
	{
		clrscr();
		Delete_Employe();
		}
	else
		Start();
}
void Load_From_File()
{
	ifstream IN;
	IN.open("Employe.txt");
	if(IN.fail())
	{
		cout<<"\t\tNO file recorded yet . . . ";
		getch();
		Start();
		}
	else if(IN.bad())
	{
		cout<<"\t\tFile could not be accessed . . . ";
		getch();
		Start();
		}
	else
	{
		clrscr();
		cout<<"||****************************************************************************||\n";
		cout<<"||******************* LOAD FROM FILE *****************************************||\n";
		cout<<"||****************************************************************************||\n";
		while(!IN.eof())
		{
			IN.getline(User[Number_Of_User].Name,25,'-');
			IN>>User[Number_Of_User].Salary;
			IN.ignore();
			if(Check_Name(User[Number_Of_User].Name,Number_Of_User)==-1)
			Number_Of_User++;
			}
		IN.close();
		Number_Of_User--;
		cout<<"\t\tDone";
		cout<<"\nPress any key to continue . . . ";
		getch();
		Start();
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
		Start();
		}
	else if(OUT.bad())
	{
		cout<<"\t\tFile could not be accessed . . . ";
		getch();
		Start();
		}
	else
	{
		clrscr();
		cout<<"||****************************************************************************||\n";
		cout<<"||******************* SAVE TO FILE *******************************************||\n";
		cout<<"||****************************************************************************||\n";

		for(int i=0;i<=Number_Of_User-1;i++)
		{
			OUT<<User[i].Name<<"-"<<User[i].Salary<<endl;
		}
		cout<<"\t\tDone";
		cout<<"\nPress any key to continue . . . ";
		getch();
		Start();
	}
}
int Check_Name(char temp[25],int Index_Of_Array)
{
	for(int i=0;i<=Index_Of_Array-1;i++)
	{
		if(strcmp(User[i].Name,temp)==0)
			return i;
		}
		return -1;
}

 /******************************************************************************
 *      @@@@@@@@@@@@@@@@                                                       *
 *      S U B M I T E D    @@@@@                                               *
 *      @@@@@@@@@@@@@@@@    TO     @@@@@@@@@@@@@@@@@                           *
 *                         @@@@@   T . M O K E N E N                           *
 *                                 @@@@@@@@@@@@@@@@@                           *
 ******************************************************************************/


