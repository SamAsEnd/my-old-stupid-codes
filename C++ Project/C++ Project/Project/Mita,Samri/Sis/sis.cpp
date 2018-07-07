#include <iostream.h>
#include <fstream.h>
#include <conio.h>
#include <string.h>

struct Employe
{
	char Name[25];
	long Security_Code;
};

Employe employe[100];
int Number_Of_Employe=0;
char choose;

void Menu();
void Add_Employe();
void View_Employe();
void Load();
void Save();
long Encript(long DSC);
void Dencript(long &ESC);
void main()
{
	Menu();
	clrscr();
	cout<<"===============================================================================\n";
	cout<<"=======================            Encryption          ========================\n";
	cout<<"=======================             GOOD BYE           ========================\n";
	cout<<"===============================================================================\n";
}
void Menu()
{
	clrscr();
	cout<<"===============================================================================\n";
	cout<<"=======================            Encryption          ========================\n";
	cout<<"===============================================================================\n";
	cout<<"       What do you want to do?\n";
	cout<<"                  Exit  --  press 0\n";
	cout<<"           Add Employe  --  press 1\n";
	cout<<"      View all Employe  --  press 2\n";
	cout<<"                  Load  --  press 3\n";
	cout<<"                  Save  --  press 4\n";
	cout<<"\n    ---> ";
	cin>>choose;
	cin.ignore();
	if(choose=='0');
	else if(choose=='1')
		Add_Employe();
	else if(choose=='2')
		View_Employe();
	else if(choose=='3')
		Load();
	else if(choose=='4')
		Save();
	else
	{
		cout<<"     Invalid choose\n     press any key to try again . . . ";
		getch();
		Menu();
	}
}
void Add_Employe()
{
	clrscr();
	cout<<"===============================================================================\n";
	cout<<"=======================            Encryption          ========================\n";
	cout<<"===============================================================================\n";
	cout<<"      Enter the employe name:   ";
	cin.getline(employe[Number_Of_Employe].Name,25);
	while(strcmp(employe[Number_Of_Employe].Name,"")==0)
	{
		cout<<"      Enter again:  ";
		cin.getline(employe[Number_Of_Employe].Name,25);
	}
	cout<<"      Enter the employe security code:   ";
	cin>>employe[Number_Of_Employe].Security_Code;
	cin.ignore();
	while(employe[Number_Of_Employe].Security_Code<=999||employe[Number_Of_Employe].Security_Code>9999){
		cout<<"      Security code must be 4 digit:   ";
		cin>>employe[Number_Of_Employe].Security_Code;
		cin.ignore();
	}
	cout<<"     "<<employe[Number_Of_Employe].Name<<"  is added succesfully\n";
	Number_Of_Employe++;
	cout<<"     Do you want to add another? press \'Y\' for yes & \'N\' no       ";
	cin>>choose;
	cin.ignore();
	if(choose=='Y'||choose=='y')
		Add_Employe();
	else
		Menu();
}
void View_Employe()
{
	clrscr();
	cout<<"===============================================================================\n";
	cout<<"=======================            Encryption          ========================\n";
	cout<<"===============================================================================\n\n";
	if(Number_Of_Employe==0)
	{
		cout<<"      No employe avalable\n";
		cout<<"      Press any key to continue . . . ";
		getch();
		Menu();
	}
	cout<<"     Employe name      Security code\n";
	cout<<"     ============      =============\n";

	for(int i=0;i<Number_Of_Employe;i++)
		cout<<"     "<<employe[i].Name<<"      "<<employe[i].Security_Code<<endl;

	cout<<"      Done\n";
	cout<<"      Press any key to continue . . . ";
	getch();
	Menu();
}
void Load()
{
	clrscr();
	cout<<"===============================================================================\n";
	cout<<"=======================            Encryption          ========================\n";
	cout<<"===============================================================================\n\n";
	ifstream INPUT;
	INPUT.open("Securty.txt");
	if(INPUT.fail()||INPUT.bad())
	{
		cout<<"      Error Loading file\n";
		cout<<"      Press any key to continue . . . ";
		getch();
		Menu();
	}

	while(!INPUT.eof())
	{
		INPUT.getline(employe[Number_Of_Employe].Name,25,',');
		INPUT>>employe[Number_Of_Employe].Security_Code;
		INPUT.ignore();
		Dencript(employe[Number_Of_Employe].Security_Code);
		Number_Of_Employe++;
	}
	INPUT.close();
	Number_Of_Employe--;
	cout<<"      Done loading employes\n";
	cout<<"      Press any key to continue . . . ";
	getch();
	Menu();
}
void Save()
{
	clrscr();
	cout<<"===============================================================================\n";
	cout<<"=======================            Encryption          ========================\n";
	cout<<"===============================================================================\n\n";

	if(Number_Of_Employe==0)
	{
		cout<<"      No employe avalable\n";
		cout<<"      Press any key to continue . . . ";
		getch();
		Menu();
	}
	ofstream OUTPUT;
	OUTPUT.open("Securty.txt");
	if(OUTPUT.fail()||OUTPUT.bad())
	{
		cout<<"      Error Saving file\n";
		cout<<"      Press any key to continue . . . ";
		getch();
		Menu();
	}
	for(int j=0;j<Number_Of_Employe;j++)
	{
		OUTPUT<<employe[j].Name<<','<<Encript(employe[j].Security_Code)<<endl;
	}
	OUTPUT.close();
	cout<<"      Done saving employes\n";
	cout<<"      Press any key to continue . . . ";
	getch();
	Menu();
}
long Encript(long DSC)
{
	long ESC=DSC;
	ESC*=10;
	ESC+=456;
	ESC*=20;
	return ESC;
}
void Dencript(long &ESC)
{
	ESC/=20;
	ESC-=456;
	ESC/=10;
}