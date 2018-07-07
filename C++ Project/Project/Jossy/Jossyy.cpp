#include <iostream.h>
#include <fstream.h>
#include <conio.h>
#include <string.h>

struct emp
{
	char Name[25];
	unsigned Salary;
};

emp Employe[100];
char temp[25];
unsigned Users=0;

void Menu();
void Add();
void View();
void Delete();
void Load_File();
void Save_File();
void Calc();
int Duplication(char temp[25]);
void main()
{
	Menu();
	clrscr();
	cout<<"_______________________________________________________________________________\n";
	cout<<"_______________________________________________________________________________\n";
	cout<<"                        WELCOME TO  SALARY MANAGEMENT                          \n";
	cout<<"_______________________________________________________________________________\n";
	cout<<"_______________________________________________________________________________\n";
	cout<<"\n                           Program Exited                                ";
	}
void Menu()
{
	char Main_Menu_Choose;
	clrscr();
	cout<<"________________________________________________________________________________\n";
	cout<<"________________________________________________________________________________\n";
	cout<<"                        WELCOME TO  SALARY MANAGEMENT \n";
	cout<<"________________________________________________________________________________\n";
	cout<<"________________________________________________________________________________\n";
	cout<<"                     Press 0  ---  Exit\n";
	cout<<"                     Press 1  ---  Add new Employe\n";
	cout<<"                     Press 2  ---  View All Employe\n";
	cout<<"                     Press 3  ---  Delete Employe\n";
	cout<<"                     Press 4  ---  Load from file\n";
	cout<<"                     Press 5  ---  Save to file\n";
	cout<<"                     Press 6  ---  Calculate Tax, Pention & Net\n";
	cout<<"                           -> ";
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
			Load_File();
			break;
		case '5':
			Save_File();
			break;
		case '6':
			Calc();
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
	cout<<"________________________________________________________________________________\n";
	cout<<"                            Adding Employe \n";
	cout<<"________________________________________________________________________________\n";
	cout<<"\t\t  Enter the full name of the employe:    ";
	cin.getline(Employe[Users].Name,25);
	while(strcmp(Employe[Users].Name,temp)==0)
	{
		cout<<"\t\t  Enter again:   ";
		cin.getline(Employe[Users].Name,25);
		}
	if(Duplication(Employe[Users].Name)!=-1)
	{
		cout<<"\t\t The Name is used by another Employee\npress any key to enter again";
		getch();
		Add();
		}
	cout<<"\t\t  Enter the salary for \""<<Employe[Users].Name<<"\":    ";
	cin>>Employe[Users].Salary;
	cin.ignore();
	Users++;
	cout<<"\n\n\t\t"<<Employe[Users-1].Name<<" is added successfully\n\t\t";
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
	int temp=Users-1;
	clrscr();
	cout<<"________________________________________________________________________________\n";
	cout<<"                              View Employes \n";
	cout<<"________________________________________________________________________________\n";
	cout<<"   Employe Name\t\t\t\tSalary\n";
	cout<<"   ============\t\t\t\t======\n";
	if(temp>=0)
	{
		for(int i=0;i<Users;i++)
		{
			cout<<"\t"<<Employe[i].Name<<"\t\t\t\t"<<Employe[i].Salary<<"\n";
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
	int t;
	clrscr();
	cout<<"________________________________________________________________________________\n";
	cout<<"                          Delete Employes \n";
	cout<<"________________________________________________________________________________\n";
	for(int i=0;i<Users;i++)
	{
		cout<<"\n\t -=> "<<Employe[i].Name;
		}
	cout<<"\n\t\tEnter the employe name:    ";
	cin.getline(temp,25);
	while(strcmp("",temp)==0)
	{
		cout<<"\t\t  Enter again:   ";
		cin.getline(temp,25);
		}
	t=Duplication(temp);
	if(t==-1)
	{
		cout<<"\t\tNo Employe Avalable With This Name\n";
		}
	else
	{
		for(int i=t;i<=Users;i++)
		{
			if((i+1)==Users)
			{
				strcpy(Employe[i].Name,"");
				Employe[i].Salary=0;
			}
			else
			{
				strcpy(Employe[i].Name,Employe[i+1].Name);
				Employe[i].Salary=Employe[i+1].Salary;
			}
		}
		Users--;
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
void Load_File()
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
		cout<<"________________________________________________________________________________\n";
		cout<<"                               LOAD FROM FILE \n";
		cout<<"________________________________________________________________________________\n";
		while(!IN.eof())
		{
			IN.getline(Employe[Users].Name,25,'-');
			IN>>Employe[Users].Salary;
			IN.ignore();
			if(Duplication(Employe[Users].Name)==-1)
			Users++;
			}
		IN.close();
		Users--;
		cout<<"\t\tDone";
		cout<<"\nPress any key to continue . . . ";
		getch();
		Menu();
	}
}
void Save_File()
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
		cout<<"________________________________________________________________________________\n";
		cout<<"                             SAVE TO FILE\n";
		cout<<"________________________________________________________________________________\n";

		for(int i=0;i<Users;i++)
		{
			OUT<<Employe[i].Name<<"-"<<Employe[i].Salary<<endl;
		}
		cout<<"\t\tDone";
		OUT.close();
		cout<<"\nPress any key to continue . . . ";
		getch();
		Menu();
	}
}
void Calc()
{
	clrscr();
	cout<<"________________________________________________________________________________\n";
	cout<<"                    Calculating Income Tax, Pention and Net salary\n";
	cout<<"________________________________________________________________________________\n";
	cout<<"Employe Name      Salary        Tax        Pention       Net Salary\n";
	cout<<"============      ======       =====      =========     ============\n";
	if(Users>0)
	{
		for(int i=0;i<Users;i++)
		{
			cout<<Employe[i].Name<<"          "<<Employe[i].Salary<<"           ";
			float Tax=Employe[i].Salary*(0.15);
			float Pention=Employe[i].Salary*(0.1);
			float Net=Employe[i].Salary-(Tax+Pention);
			cout<<Tax<<"           "<<Pention<<"          "<<Net<<endl;
			}
		}
	else
		cout<<"\t\t No Employe Avalable!!";
	cout<<"\nPress any key to continue . . . ";
	getch();
	Menu();

}
int Duplication(char temp[25])
{
	for(int i=0;i<Users;i++)
	{
		if(strcmp(Employe[i].Name,temp)==0)
			return i;
		}
		return -1;
}


