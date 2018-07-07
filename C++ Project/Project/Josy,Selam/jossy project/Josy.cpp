#include <iostream.h>
#include <conio.h>
#include <string.h>
struct COURSE
{
	char Title[20];
	int CH;
	int Result;
	char CGrade;
	};
struct STUDENT
{
	char Name[25];
	float GPA;
	float Total;
	char Grade;
	float AVG;
	COURSE course[5];
	};

STUDENT student[100];
int Number_Of_Student=0;

void Welcome();
void Start();
void Add_Student();
void View_Promoted();
void View_Dismiss();
void View_Warned();
char Grade(int Index);
void main()
{
	Start();
	clrscr();
	cout<<"*******************************************************************************\n";
	cout<<"*                            STUDENT GRADE CALCULATER                         *\n";
	cout<<"*                           __________________________                        *\n";
	cout<<"*                                      EXIT                                   *\n";
	cout<<"*******************************************************************************\n";
}
void Welcome()
{
	clrscr();
	cout<<"*******************************************************************************\n";
	cout<<"*                            STUDENT GRADE CALCULATER                         *\n";
	cout<<"*                           __________________________                        *\n";
	cout<<"*******************************************************************************\n";
	}
void Start()
{
	char choose;
	Welcome();
	cout<<"\t\tPress  E   __    Exit\n";
	cout<<"\t\tPress  A   __    Add Student\n";
	cout<<"\t\tPress  P   __    View Promoted Students\n";
	cout<<"\t\tPress  D   __    View Dismiss Students\n";
	cout<<"\t\tPress  W   __    View Warned Students\n\t\t   --> ";
	cin>>choose;
	cin.ignore();
	switch (choose)
	{
		case 'E':
		case 'e':
			break;
		case 'A':
		case 'a':
			Add_Student();
			break;
		case 'P':
		case 'p':
			View_Promoted();
			break;
		case 'D':
		case 'd':
			View_Dismiss();
			break;
		case 'W':
		case 'w':
			View_Warned();
			break;
		default:
			cout<<"\tInvalid choose\n\tpress any key to try again . . . ";
			getch();
			Start();
	}
}
void Add_Student()
{
	clrscr();
	Welcome();
	cout<<"\t Name --> ";
	cin.getline(student[Number_Of_Student].Name,25);
	while(strcmp(student[Number_Of_Student].Name,"")==0)
	{
		cout<<"\t Enter Again\n\t Name --> ";
		cin.getline(student[Number_Of_Student].Name,25);
		}
	for(int i=0;i<5;i++)
	{
		cout<<"\t Ttile of course number "<<(1+i)<<" --> ";
		cin.getline(student[Number_Of_Student].course[i].Title,25);
		while(strcmp(student[Number_Of_Student].course[i].Title,"")==0)
		{
			cout<<"\t Enter Again\n\t Ttile of course number "<<(1+i)<<" --> ";
			cin.getline(student[Number_Of_Student].course[i].Title,25);
			}
		cout<<"\t Credit Hour of course number "<<(1+i)<<" --> ";
		cin>>student[Number_Of_Student].course[i].CH;
		cin.ignore();
		while(student[Number_Of_Student].course[i].CH<=0)
		{
			cout<<"\t Credit Hour must be positive\n";
			cout<<"\t Credit Hour of course number "<<(1+i)<<" --> ";
			cin>>student[Number_Of_Student].course[i].CH;
			cin.ignore();
			}
		cout<<"\t Result (out of 100) of course number "<<(1+i)<<" --> ";
		cin>>student[Number_Of_Student].course[i].Result;
		cin.ignore();
		while(student[Number_Of_Student].course[i].Result>100||student[Number_Of_Student].course[i].Result<0)
		{
			cout<<"\t Result must be b/n 0 - 100\n";
			cout<<"\t Credit Hour of course number "<<(1+i)<<" --> ";
			cin>>student[Number_Of_Student].course[i].Result;
			cin.ignore();
			}
		student[Number_Of_Student].course[i].CGrade=Grade(student[Number_Of_Student].course[i].Result);
	}
	student[Number_Of_Student].Total=0;
	for(int j=0;j<5;j++)
	{
		student[Number_Of_Student].Total+=student[Number_Of_Student].course[j].Result;
	}
	student[Number_Of_Student].AVG=student[Number_Of_Student].Total/5;
	student[Number_Of_Student].GPA=student[Number_Of_Student].AVG/25;
	student[Number_Of_Student].Grade=Grade(student[Number_Of_Student].AVG);

	cout<<"   "<<student[Number_Of_Student].Name<<" added successfully";
	cout<<"     Avarage = "<<student[Number_Of_Student].AVG<<endl;
	cout<<"       Grade = "<<student[Number_Of_Student].Grade<<endl;
	cout<<"                  COURSES\n";
	cout<<"                 =========\n";
	for(int k=0;k<5;k++)
	{
		cout<<"                 "<<student[Number_Of_Student].course[k].Title<<"    "<<student[Number_Of_Student].course[k].CGrade<<endl;
		}
	Number_Of_Student++;
	char ch;
	cout<<"\n\t Press  any key to add another \"Y\" for YES or \"N\" for NO\n    . . . ";
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
		Add_Student();
	else
		Start();
}
void View_Promoted()
{
	clrscr();
	Welcome();
	cout<<"         Promoted students are\n";
	if(Number_Of_Student==0)
		cout<<"\t  NO STUDENT RECORD!!";
	else
	for(int i=0;i<Number_Of_Student;i++)
	{
		if(student[i].AVG>=60)
			cout<<"\t"<<student[i].Name<<" with GPA "<<student[i].GPA<<endl;
	}
	cout<<"\n\tPress any key to continue . . . ";
	getch();
	Start();
}
void View_Dismiss()
{
	clrscr();
	Welcome();
	cout<<"         Dismiss students are\n";
	if(Number_Of_Student==0)
		cout<<"\t  NO STUDENT RECORD!!";
	else
	for(int i=0;i<Number_Of_Student;i++)
	{
		if(student[i].AVG<50)
			cout<<"\t"<<student[i].Name<<endl;
	}
	cout<<"\tPress any key to continue . . . ";
	getch();
	Start();
}
void View_Warned()
{
	clrscr();
	Welcome();
	cout<<"         Warned students are\n";
	if(Number_Of_Student==0)
		cout<<"\t  NO STUDENT RECORD!!";
	else
	for(int i=0;i<Number_Of_Student;i++)
	{
		if(student[i].AVG<60&&student[i].AVG>=50)
			cout<<"\t"<<student[i].Name<<endl;
	}
	cout<<"\tPress any key to continue . . . ";
	getch();
	Start();
}
char Grade(int Index)
{
	if(Index>=90)
		return 'A';
	else if(Index>=80)
		return 'B';
	else if(Index>=70)
		return 'C';
	else if(Index>=60)
		return 'D';
	else if(Index>=50)
		return 'E';
	else
		return 'F';
}























