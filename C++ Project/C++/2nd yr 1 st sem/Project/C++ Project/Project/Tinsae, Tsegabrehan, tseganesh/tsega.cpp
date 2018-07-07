#include <iostream.h>
#include <conio.h>
#include <string.h>
#include <fstream.h>
struct Event_Date
{
	int day;
	int month;
	int year;
};
struct Event_Struct
{
	char Name_Of_Event[25];
	char Place[25];
	char Cause_Of_Event[50];
	Event_Date Date;
};
Event_Struct Event[100];
int Number_Of_Event=0;
Event_Date date;
char Temp[25];
int t;
void Welcome();
void Menu();
void Add();
void View();
void Search();
void Update();
void Delete();
void Load();
void Save();
int check(char x[25],int n);
void main()
{
	clrscr();
	Menu();
	Welcome();
	cout<<"                                End";
	}
void Welcome()
{
	clrscr();
	cout<<"===============================================================================\n";
	cout<<"================         Dairy Management System               ================\n";
	cout<<"===============================================================================\n";
}
void Menu()
{
	char ch;
	Welcome();
	cout<<"        Press 0      -     Exit\n";
	cout<<"        Press 1      -     Add\n";
	cout<<"        Press 2      -     View\n";
	cout<<"        Press 3      -     Search\n";
	cout<<"        Press 4      -     Update\n";
	cout<<"        Press 5      -     Delete\n";
	cout<<"        Press 6      -     Load\n";
	cout<<"        Press 7      -     Save\n            -> ";
	cin>>ch;
	cin.ignore();
	switch(ch)
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
			Search();
			break;
		case '4':
			Update();
			break;
		case '5':
			Delete();
			break;
		case '6':
			Load();
			break;
		case '7':
			Save();
			break;
		default:
			cout<<"     Incorrect choose . . .";
			getch();
			Menu();
	}
}
void Add()
{
	Welcome();
	cout<<"\tEnter the name of the event:  ";
	cin.getline(Event[Number_Of_Event].Name_Of_Event,25);
	while(strcmp(Event[Number_Of_Event].Name_Of_Event,"")==0)
	{
		cout<<"\t Try Again:   ";
		cin.getline(Event[Number_Of_Event].Name_Of_Event,25);
	}
	cout<<"\tEnter the place of the event:  ";
	cin.getline(Event[Number_Of_Event].Place,25);
	while(strcmp(Event[Number_Of_Event].Place,"")==0)
	{
		cout<<"\t Try Again:   ";
		cin.getline(Event[Number_Of_Event].Place,25);
	}
	cout<<"\twhy?   ";
	cin.getline(Event[Number_Of_Event].Cause_Of_Event,25);
	while(strcmp(Event[Number_Of_Event].Cause_Of_Event,"")==0)
	{
		cout<<"\t Try Again:   ";
		cin.getline(Event[Number_Of_Event].Cause_Of_Event,25);
	}
	cout<<"\tEnter the date:\n";
	cout<<"       day  =  ";
	cin>>Event[Number_Of_Event].Date.day;
	while(Event[Number_Of_Event].Date.day>30||Event[Number_Of_Event].Date.day<=0)
	{
		cout<<"       day must be b/n 1-30\n";
		cout<<"       day  =  ";
		cin>>Event[Number_Of_Event].Date.day;
	}
	cout<<"     month  =  ";
	cin>>Event[Number_Of_Event].Date.month;
	while(Event[Number_Of_Event].Date.month>12||Event[Number_Of_Event].Date.month<=0)
	{
		cout<<"       month must be b/n 1-12\n";
		cout<<"       day  =  ";
		cin>>Event[Number_Of_Event].Date.month;
	}
	cout<<"      year  =  ";
	cin>>Event[Number_Of_Event].Date.year;
	cin.ignore();
	while(Event[Number_Of_Event].Date.year>2050||Event[Number_Of_Event].Date.year<=2012)
	{
		cout<<"       month must be b/n 2012-2050\n";
		cout<<"      year  =  ";
		cin>>Event[Number_Of_Event].Date.year;
		cin.ignore();
	}
	cout<<"           ADDED SUCCESSFUL . . . ";
	Number_Of_Event++;
	getch();
	Menu();
}
void View()
{
	Welcome();
	if(Number_Of_Event==0)
		cout<<"             NO EVENT AVALABLE";
	else
	{
		for(int i=0;i<Number_Of_Event;i++)
		{
			clrscr();
			cout<<"Event   ---> "<<Event[i].Name_Of_Event<<endl;
			cout<<"   where   @ "<<Event[i].Place<<endl;
			cout<<"   why?  --> "<<Event[i].Cause_Of_Event<<endl;
			cout<<"   when  --> "<<Event[i].Date.day<<" - "<<Event[i].Date.month<<" - "<<Event[i].Date.year<<endl;
			cout<<"\n";

			cout<<"     press any key to see next";
			getch();
		}
	}
	cout<<"\n     press any key to go to main menu . . ";
	getch();
	Menu();
}
void Search()
{
	char by;
	Welcome();
	cout<<"             Search by\n";
	cout<<"        press 1      for    Name of event\n";
	cout<<"        press 2      for    place\n";
	cout<<"        press 3      for    cause of event\n";
	cout<<"        press 4      for    date\n";
	cout<<"\n          ->  ";
	cin>>by;
	cin.ignore();
	switch(by)
	{
		case '1':
			cout<<"Enter the name of the event:   ";
			cin.getline(Temp,25);
			t=check(Temp,1);
			if(t==-1)
				cout<<"NO EVENT AVALABLE with this name";
			else
			{
				Welcome();
				cout<<"Event   ---> "<<Event[t].Name_Of_Event<<endl;
				cout<<"   where   @ "<<Event[t].Place<<endl;
				cout<<"   why?  --> "<<Event[t].Cause_Of_Event<<endl;
				cout<<"   where --> "<<Event[t].Date.day<<" - "<<Event[t].Date.month<<" - "<<Event[t].Date.year<<endl;
				cout<<"\n";
			}
			break;
		case '2':
			cout<<"Enter the place of the event:   ";
			cin.getline(Temp,25);
			t=check(Temp,2);
			if(t==-1)
				cout<<"NO EVENT AVALABLE with this place";
			else
			{
				Welcome();
				cout<<"Event   ---> "<<Event[t].Name_Of_Event<<endl;
				cout<<"   where   @ "<<Event[t].Place<<endl;
				cout<<"   why?  --> "<<Event[t].Cause_Of_Event<<endl;
				cout<<"   where --> "<<Event[t].Date.day<<" - "<<Event[t].Date.month<<" - "<<Event[t].Date.year<<endl;
				cout<<"\n";
			}
			break;
		case '3':
			cout<<"Enter the cause of the event:   ";
			cin.getline(Temp,25);
			t=check(Temp,3);
			if(t==-1)
				cout<<"NO EVENT AVALABLE with this cause";
			else
			{
				Welcome();
				cout<<"Event   ---> "<<Event[t].Name_Of_Event<<endl;
				cout<<"   where   @ "<<Event[t].Place<<endl;
				cout<<"   why?  --> "<<Event[t].Cause_Of_Event<<endl;
				cout<<"   where --> "<<Event[t].Date.day<<" - "<<Event[t].Date.month<<" - "<<Event[t].Date.year<<endl;
				cout<<"\n";
			}
			break;
		case '4':
			cout<<"Enter the date of the event:   ";
				cout<<"Enter the date:\n";
				cout<<"       day  =  ";
				cin>>date.day;
				cout<<"     month  =  ";
				cin>>date.month;
				cout<<"      year  =  ";
				cin>>date.year;
				cin.ignore();
				strcpy(Temp,"date");
			t=check(Temp,4);
			if(t==-1)
				cout<<"NO EVENT AVALABLE with this date";
			else
			{
				Welcome();
				cout<<"Event   ---> "<<Event[t].Name_Of_Event<<endl;
				cout<<"   where   @ "<<Event[t].Place<<endl;
				cout<<"   why?  --> "<<Event[t].Cause_Of_Event<<endl;
				cout<<"   where --> "<<Event[t].Date.day<<" - "<<Event[t].Date.month<<" - "<<Event[t].Date.year<<endl;
				cout<<"\n";
			}
			break;
		default:
			cout<<"     Incorrect choose\n";
		}
	getch();
	Menu();
}
void Update()
{
	Welcome();
	cout<<"Enter the name of the event:   ";
	cin.getline(Temp,25);
	t=check(Temp,1);
	if(t==-1)
		cout<<"NO EVENT AVALABLE with this name . . . ";
	else
	{
		cout<<"\tEnter the new name of the event:  ";
		cin.getline(Event[t].Name_Of_Event,25);
		while(strcmp(Event[t].Name_Of_Event,"")==0)
		{
			cout<<"\t Try Again:   ";
			cin.getline(Event[t].Name_Of_Event,25);
		}
		cout<<"\tEnter the place of the event:  ";
		cin.getline(Event[t].Place,25);
		while(strcmp(Event[t].Place,"")==0)
		{
			cout<<"\t Try Again:   ";
			cin.getline(Event[t].Place,25);
		}
		cout<<"\twhy?   ";
		cin.getline(Event[t].Cause_Of_Event,25);
		while(strcmp(Event[t].Cause_Of_Event,"")==0)
		{
			cout<<"\t Try Again:   ";
			cin.getline(Event[t].Cause_Of_Event,25);
		}
		cout<<"\tEnter the date:\n";
		cout<<"       day  =  ";
		cin>>Event[t].Date.day;
		while(Event[t].Date.day>30||Event[t].Date.day<=0)
		{
			cout<<"       day must be b/n 1-30\n";
			cout<<"       day  =  ";
			cin>>Event[t].Date.day;
		}
		cout<<"     month  =  ";
		cin>>Event[t].Date.month;
		while(Event[t].Date.month>12||Event[t].Date.month<=0)
		{
			cout<<"       month must be b/n 1-12\n";
			cout<<"       day  =  ";
			cin>>Event[t].Date.month;
		}
		cout<<"      year  =  ";
		cin>>Event[t].Date.year;
		cin.ignore();
		while(Event[t].Date.year>2050||Event[t].Date.year<=2012)
		{
			cout<<"       month must be b/n 2012-2050\n";
			cout<<"      year  =  ";
			cin>>Event[t].Date.year;
			cin.ignore();
		}
		cout<<"UPDATED SUCCESSFUL . . . ";
	}
	getch();
	Menu();
}
void Delete()
{
	Welcome();
	cout<<"Enter the name of the event:   ";
	cin.getline(Temp,25);
	t=check(Temp,1);
	if(t==-1)
		cout<<"NO EVENT AVALABLE with this name";
	else
	{
		for(int i=t;i<Number_Of_Event;i++)
		{
			strcpy(Event[i].Name_Of_Event,Event[i+1].Name_Of_Event);
			strcpy(Event[i].Place,Event[i+1].Place);
			strcpy(Event[i].Cause_Of_Event,Event[i+1].Cause_Of_Event);
			Event[i].Date=Event[i+1].Date;
		}
		Number_Of_Event--;
	cout<<"DELETED SUCCESSFUL . . . ";
	}
	getch();
	Menu();
}
void Load()
{
	Welcome();
	ifstream Diary;
	Diary.open("Diary.txt");
	if(Diary.fail())
	{
		cout<<"      Can't load the file\n      ";
		getch();
		Menu();
	}
	while(!Diary.eof())
	{
		Diary.getline(Event[Number_Of_Event].Name_Of_Event,25,',');
		Diary.getline(Event[Number_Of_Event].Place,25,',');
		Diary.getline(Event[Number_Of_Event].Cause_Of_Event,25,',');
		Diary>>Event[Number_Of_Event].Date.day;
			Diary.ignore();
		Diary>>Event[Number_Of_Event].Date.month;
			Diary.ignore();
		Diary>>Event[Number_Of_Event].Date.year;
			Diary.ignore();
		Number_Of_Event++;
	}
    Number_Of_Event--;
	cout<<"        Done loading . . . ";
	getch();
	Menu();
}
void Save()
{
	Welcome();
	ofstream Out;
	Out.open("Diary.txt");
	if(Out.fail())
	{
		cout<<"      Can't save the file\n      ";
		getch();
		Menu();
	}
	for(int i=0;i<Number_Of_Event;i++)
	{
		Out<<Event[i].Name_Of_Event<<","
		   <<Event[i].Place<<","
		   <<Event[i].Cause_Of_Event<<","
		   <<Event[i].Date.day<<","
		   <<Event[i].Date.month<<","
		   <<Event[i].Date.year<<endl;
	}
	cout<<"       Press any key to continue . . . ";
	getch();
	Menu();
}
int check(char x[25],int n)
{
	if(n==1)
		for(int i=0;i<Number_Of_Event;i++)
		{
			if(strcmp(Event[i].Name_Of_Event,x)==0)
				return i;
		}
	else if(n==2)
		for(int i=0;i<Number_Of_Event;i++)
		{
			if(strcmp(Event[i].Place,x)==0)
				return i;
		}
	else if(n==3)
		for(int i=0;i<Number_Of_Event;i++)
		{
			if(strcmp(Event[i].Cause_Of_Event,x)==0)
				return i;
		}
	else
		for(int i=0;i<Number_Of_Event;i++)
		{
			if((Event[i].Date.day==date.day)&&(Event[i].Date.month==date.month)&&(Event[i].Date.year==date.year))
				return i;
		}
	return -1;
}








