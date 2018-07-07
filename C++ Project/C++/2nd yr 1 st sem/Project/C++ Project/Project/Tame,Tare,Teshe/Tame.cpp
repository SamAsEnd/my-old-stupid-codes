#include <iostream.h>
#include <conio.h>
#include <string.h>
struct BOOK
{
	char Title[25];
	char Author[25];
	unsigned Serial_Number;
	int Borrow;
	char Name[25];
};
BOOK book[100];
int Number_Of_Book=0;

void Add_Book();
void View_Book();
void Update_Book();
void Delete_Book();
void Borrow_Book();
void D_Borrow_Book();
void Menu();
int Test(char Temp[25]);
void main()
{
	Menu();
	clrscr();
   cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
	cout<<"                       LIBRAY MANAGEMENT                                       \n";
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n\n";
	cout<<"\t\t             GOOD BYE";
}
void Menu()
{
	int choose;
	clrscr();
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
	cout<<"                       LIBRAY MANAGEMENT                                       \n";
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n\n";
	cout<<"\t\tpress 0 --- Exit\n";
	cout<<"\t\tpress 1 --- Add Book\n";
	cout<<"\t\tpress 2 --- View Book\n";
	cout<<"\t\tpress 3 --- Update Book\n";
	cout<<"\t\tpress 4 --- Delete Book\n";
	cout<<"\t\tpress 5 --- Borrow Book\n";
   cout<<"\t\tpress 6 --- Return Borrowed Book\n";
	cout<<"\t\tEnter your choose --->  ";
	cin>>choose;
	cin.ignore();
	switch (choose)
	{
		case 0:
			break;
		case 1:
			Add_Book();
			break;
		case 2:
			View_Book();
			break;
		case 3:
			Update_Book();
			break;
		case 4:
			Delete_Book();
			break;
		case 5:
			Borrow_Book();
			break;
      case 6:
			D_Borrow_Book();
			break;
		default:
			cout<<"\t\tIncorrect choose\t\tPress any key to continue . . . ";
			getch();
			Menu();
		}
	}
void Add_Book()
{
	clrscr();
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
	cout<<"                          ADDING BOOK                                          \n";
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n\n";
	cout<<"\tEnter the title of the book:  ";
	cin.getline(book[Number_Of_Book].Title,25);
	while(strcmp(book[Number_Of_Book].Title,"")==0)
	{
		cout<<"Enter again:   ";
		cin.getline(book[Number_Of_Book].Title,25);
		}
	cout<<"\tEnter the author of the book:  ";
	cin.getline(book[Number_Of_Book].Author,25);
	while(strcmp(book[Number_Of_Book].Author,"")==0)
	{
		cout<<"Enter again:   ";
		cin.getline(book[Number_Of_Book].Author,25);
		}
	cout<<"\tEnter the serial number of the book:  ";
	cin>>book[Number_Of_Book].Serial_Number;
	book[Number_Of_Book].Borrow=0;

	Number_Of_Book++;

	cout<<"\tSuccesfully added\n\tDo you want to add another Book . . .\n\t";
	cout<<"Enter \'Y\' for YSE \'N\' for NO . . . ";
	char ch;
	cin>>ch;
	if( ch=='y' || ch=='Y' )
		Add_Book();
	Menu();
}

void View_Book()
{
	clrscr();
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
	cout<<"                            VIEW BOOK                                          \n";
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n\n";
	if(Number_Of_Book==0)
		cout<<"\t\tNO BOOK AVALABLE";
	else
	{
		cout<<"Title  Author   Serial Number   Borrow    Borrower\n";
		cout<<"=====  ======   =============   ======    ========\n";
		for(int i=0;i<Number_Of_Book;i++)
		{
			cout<<book[i].Title<<"    "<<book[i].Author<<"     "<<book[i].Serial_Number<<"         ";
			if(book[i].Borrow==0)
				cout<<"   FALSE"<<endl;
			else
			{
				cout<<"     TRUE    "<<book[i].Name<<endl;
				}
			}
		}
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
}

void Update_Book()
{
	char T[25];
	clrscr();
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
	cout<<"                       Update MANAGEMENT                                       \n";
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n\n";
	if(Number_Of_Book==0)
	{
		cout<<"\tNO BOOK AVALABLE TO UPDATE";
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
		}
	cout<<"\t\tEnter the title of the book:    ";
	cin.getline(T,25);
	while(strcmp(T,"")==0)
	{
		cout<<"Enter again:   ";
		cin.getline(T,25);
		}
	int S=Test(T);
	if(S==-1)
	{
		cout<<"\t No name is avalable with this name";
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
		}
	else
	{
		cout<<"\t"<<book[S].Title<<"  Change to ->  ";
		cout<<"\tEnter the title of the book:  ";
		cin.getline(book[S].Title,25);
		while(strcmp(book[S].Title,"")==0)
		{
			cout<<"Enter again:   ";
			cin.getline(book[S].Title,25);
			}
		cout<<"\tEnter the author of the book:  ";
		cin.getline(book[S].Author,25);
		while(strcmp(book[S].Author,"")==0)
		{
			cout<<"Enter again:   ";
			cin.getline(book[S].Author,25);
			}
		cout<<"\tEnter the serial number of the book:  ";
		cin>>book[S].Serial_Number;

		cout<<"\tSuccesfully UPDATE\n\tDo you want to UPDATE another Book . . .\n\t";
		cout<<"Enter \'Y\' for YSE \'N\' for NO . . . ";
		char ch;
		cin>>ch;
		if( ch=='y' || ch=='Y' )
			Update_Book();
		Menu();
		}
	}

void Delete_Book()
{
	char T[25];
	clrscr();
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
	cout<<"                         DELETE BOOK                                           \n";
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n\n";
	if(Number_Of_Book==0)
	{
		cout<<"\tNO BOOK AVALABLE TO DELETE";
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
		}
	cout<<"\t\tEnter the title of the book:    ";
	cin.getline(T,25);
	while(strcmp(T,"")==0)
	{
		cout<<"Enter again:   ";
		cin.getline(T,25);
		}
	int S=Test(T);
	if(S==-1)
	{
		cout<<"\t No name is avalable with this name";
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
		}
	else
	{
   	if(book[S].Borrow==1)
      {
      	cout<<"        Can't delete borrowed book";
         cout<<"\tPress any key to go to menu . . . ";
			getch();
			Menu();
		}
      else
      {
			for(int j=S;j<Number_Of_Book;j++)
			{
				strcpy(book[j].Title,book[j+1].Title);
				strcpy(book[j].Author,book[j+1].Author);
				book[j].Serial_Number=book[j+1].Serial_Number;
				book[j].Borrow=book[j+1].Borrow;
				strcpy(book[j].Name,book[j+1].Name);
			}
      }
	}
	Number_Of_Book--;
    cout<<"\tSuccesfully Deleted"<<endl;
	cout<<"\tPress any key to go to menu . . . ";
	getch();
	Menu();
}
void Borrow_Book()
{
	char T[25];
	clrscr();
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
	cout<<"                         Borrow Book                                       \n";
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n\n";
	if(Number_Of_Book==0)
	{
		cout<<"\tNO BOOK AVALABLE TO borrow";
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
		}
	cout<<"\t\tEnter the title of the book:    ";
	cin.getline(T,25);
	while(strcmp(T,"")==0)
	{
		cout<<"Enter again:   ";
		cin.getline(T,25);
		}
	int S=Test(T);
	if(S==-1)
	{
		cout<<"\t No book is avalable with this name";
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
		}
	else
	{
		cout<<"\t\tEnter the name of the borrower:    ";
		cin.getline(T,25);
		while(strcmp(T,"")==0)
		{
			cout<<"Enter again:   ";
			cin.getline(T,25);
		}
		strcpy(book[S].Name,T);
		book[S].Borrow=1;
		cout<<"\t Successfully Borrowed\n";
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
	}
}
void D_Borrow_Book()
{
	char T[25];
	clrscr();
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n";
	cout<<"                         Return Borrow Book                                       \n";
	cout<<"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n\n";
	if(Number_Of_Book==0)
	{
		cout<<"\tNO BOOK AVALABLE TO Return";
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
		}
	cout<<"\t\tEnter the title of the book:    ";
	cin.getline(T,25);
	while(strcmp(T,"")==0)
	{
		cout<<"Enter again:   ";
		cin.getline(T,25);
		}
	int S=Test(T);
	if(S==-1)
	{
		cout<<"\t No book is avalable with this name";
		cout<<"\tPress any key to go to menu . . . ";
		getch();
		Menu();
		}
	else
	{
		cout<<"\t\t  Are u "<<book[S].Name<<"?"<<endl;
      cout<<"        Enter \'Y\' for YSE \'N\' for NO . . . ";
		char ch;
		cin>>ch;
		if( ch=='y' || ch=='Y' )
      {
      	book[S].Borrow=0;
         strcpy(book[S].Name,"");
         cout<<"         Successfully RETURNED!!";
         getch();
         Menu();
      }
      else
      {
			cout<<"\t NOT RETURNED Borrowed\n";
			cout<<"\tPress any key to go to menu . . . ";
			getch();
			Menu();
      }
	}

}
int Test(char Temp[25])
{
		for(int i=0;i<Number_Of_Book;i++)
		{
			if(strcmp(book[i].Title,Temp)==0)
			{
				return i;
				}
		}
		return -1;
}



