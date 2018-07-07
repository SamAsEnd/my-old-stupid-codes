#include <iostream.h>
#include <conio.h>
#include <string.h>
struct Course_Struct
{
	char Title[20];
	int Credit_Hour;
	int Result;
	};
struct STUDENT
{
	char Name[25];
	float GPA;
	float Tota_Grade;
	char Grade;
	int Total_Credit_Hour;
	Course_Struct course[6];
	};
STUDENT Student[100];
int Student_Entered=0;

void Intarface();
void Menu();
void Add_New_Student();
void View_Promoted_Student();
void View_Dismiss_Student();
void View_Warned_Student();
char Grade(int Result);
void main()
{
	Menu();
	clrscr();
	cout<<"...............................................................................\n";
	cout<<".                            STUDENT GRADE CALCULATER                         .\n";
	cout<<".                           ==========================                        .\n";
	cout<<".                                      EXIT                                   .\n";
	cout<<"...............................................................................\n";
}
void Intarface()
{
	clrscr();
	cout<<"...............................................................................\n";
	cout<<".                            STUDENT GRADE CALCULATER                         .\n";
	cout<<".                           ==========================                        .\n";
	cout<<"...............................................................................\n";
	}
void Menu()
{
	char choose;
	Intarface();
	cout<<"\t\tPress  0   __    Exit\n";
	cout<<"\t\tPress  1   __    Add Student\n";
	cout<<"\t\tPress  2   __    View Promoted Students\n";
	cout<<"\t\tPress  3   __    View Dismiss Students\n";
	cout<<"\t\tPress  4   __    View Warned Students\n\t\t   --> ";
	cin>>choose;
	cin.ignore();
	if(choose=='0');
	else if(choose=='1')
		Add_New_Student();
	else if(choose=='2')
		View_Promoted_Student();
	else if(choose=='3')
		View_Dismiss_Student();
	else if(choose=='4')
		View_Warned_Student();
	else
	{
		cout<<"\tInvalid choose\n\tpress any key to try again . . . ";
		getch();
		Menu();
	}
}
void Add_New_Student()
{
	clrscr();
	Intarface();
	cout<<"\t Name --> ";
	cin.getline(Student[Student_Entered].Name,25);
	while(strcmp(Student[Student_Entered].Name,"")==0)
	{
		cout<<"\t Enter Again\n\t Name --> ";
		cin.getline(Student[Student_Entered].Name,25);
		}
	Student[Student_Entered].Tota_Grade=0;
	for(int i=0;i<6;i++)
	{
		cout<<"\t Title of course number "<<(1+i)<<" --> ";
		cin.getline(Student[Student_Entered].course[i].Title,25);
		while(strcmp(Student[Student_Entered].course[i].Title,"")==0)
		{
			cout<<"\t Enter Again\n\t Ttile of course number "<<(1+i)<<" --> ";
			cin.getline(Student[Student_Entered].course[i].Title,25);
			}
		cout<<"\t Credit Hour of course number "<<(1+i)<<" --> ";
		cin>>Student[Student_Entered].course[i].Credit_Hour;
		cin.ignore();
		while(Student[Student_Entered].course[i].Credit_Hour<=0||Student[Student_Entered].course[i].Credit_Hour>20)
		{
			cout<<"\t Credit Hour must be positive\n";
			cout<<"\t Credit Hour of course number "<<(1+i)<<" --> ";
			cin>>Student[Student_Entered].course[i].Credit_Hour;
			cin.ignore();
			}
		cout<<"\t Result out of 100 % of course number "<<(1+i)<<" --> ";
		cin>>Student[Student_Entered].course[i].Result;
		cin.ignore();
		while(Student[Student_Entered].course[i].Result>100||Student[Student_Entered].course[i].Result<0)
		{
			cout<<"\t Result must be b/n 0 - 100\n";
			cout<<"\t Credit Hour of course number "<<(1+i)<<" --> ";
			cin>>Student[Student_Entered].course[i].Result;
			cin.ignore();
			}
		Student[Student_Entered].Tota_Grade+=(Student[Student_Entered].course[i].Result*Student[Student_Entered].course[i].Credit_Hour);
	}
	Student[Student_Entered].Total_Credit_Hour=0;
	for(int k=0;k<6;k++)
		Student[Student_Entered].Total_Credit_Hour+=Student[Student_Entered].course[k].Credit_Hour;

	Student[Student_Entered].Tota_Grade/=Student[Student_Entered].Total_Credit_Hour;
	Student[Student_Entered].GPA=Student[Student_Entered].Tota_Grade/25;
	Student[Student_Entered].Grade=Grade(Student[Student_Entered].Tota_Grade);

	cout<<"\n   "<<Student[Student_Entered].Name<<" added successfully";

	cout<<"       Grade  =  "<<Student[Student_Entered].Grade<<endl;
	cout<<"         GPA  =  "<<Student[Student_Entered].GPA<<endl;
	Student_Entered++;
	char ch;
	cout<<"\n\t Do you want to add another \n\t   Press  \"Y\" for YES or \"N\" for NO  . . . ";
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
		Add_New_Student();
	else
		Menu();
}
void View_Promoted_Student()
{
	clrscr();
	Intarface();
	cout<<"         Promoted Students are\n";
	if(Student_Entered==0)
		cout<<"\t  NO STUDENT RECORD!!";
	else
	for(int i=0;i<Student_Entered;i++)
	{
		if(Student[i].Tota_Grade>=60)
		cout<<"\t"<<Student[i].Name<<"   with GPA "<<Student[i].GPA<<endl;
	}
	cout<<"\n\tPress any key to continue . . . ";
	getch();
	Menu();
}
void View_Dismiss_Student()
{
	clrscr();
	Intarface();
	cout<<"         Dismiss Students are\n";
	if(Student_Entered==0)
		cout<<"\t  NO STUDENT RECORD!!";
	else
	for(int i=0;i<Student_Entered;i++)
	{
		if(Student[i].Tota_Grade<50)
			cout<<"\t"<<Student[i].Name<<endl;
	}
	cout<<"\tPress any key to continue . . . ";
	getch();
	Menu();
}
void View_Warned_Student()
{
	clrscr();
	Intarface();
	cout<<"         Warned Students are\n";
	if(Student_Entered==0)
		cout<<"\t  NO STUDENT RECORD!!";
	else
	for(int i=0;i<Student_Entered;i++)
	{
		if(Student[i].Tota_Grade>=50&&Student[i].Tota_Grade<60)
			cout<<"\t"<<Student[i].Name<<endl;
	}
	cout<<"\tPress any key to continue . . . ";
	getch();
	Menu();
}
char Grade(int Result)
{
	if(Result>=90)
		return 'A';
	else if(Result>=80)
		return 'B';
	else if(Result>=70)
		return 'C';
	else if(Result>=60)
		return 'D';
	else if(Result>=50)
		return 'E';
	else
		return 'F';

}























