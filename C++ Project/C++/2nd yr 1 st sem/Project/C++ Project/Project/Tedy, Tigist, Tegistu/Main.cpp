/*******************************************************************

	Question :  add goods, borrow goods, view report.

	Group members :     TEWODROS  ADUGNA   ABERA   
						TIGIST ADMASU AWEKE		   
						TEGISTU BIYADG SEWNNET     
								
*******************************************************************/
#include <iostream.h>
#include <conio.h>
#include <fstream.h>
#include <string.h>
struct Goods
{
	char Name[25];
	unsigned long Avalable_Item;
	int Borrow;
	char User_Name[25];
	int User_Borrow;
	};

Goods Item[100];
Goods Empty;
unsigned int Number_Of_Item=0;

void Interface();
void Add_Good();
void View_All_Good();
void Borrow_Good();
void Load_Good_From_File();
void Save_Good_To_File();
int Check_Name (char temp[25],int Index_Of_Array);

void main()
{
	Interface();
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                                                           ##\n";
	cout<<"##                      WELCOME TO GOODS MANAGEMENT                          ##\n";
	cout<<"##                                                                           ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                                                           ##\n";
	cout<<"##                               GOOD BYE                                    ##\n";
	}

void Interface()
{
	char Main_Menu_Choose;
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                      WELCOME TO GOODS MANAGEMENT                          ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                            MAIN MENU                                      ##\n";
	cout<<"##                   EXIT        ~~~            PRESS  0                     ##\n";
	cout<<"##                 ADD GOOD      ~~~            PESSS  1                     ##\n";
	cout<<"##            VIEW ALL GOOD      ~~~            PRESS  2                     ##\n";
	cout<<"##              BORROW GOOD      ~~~            PRESS  3                     ##\n";
	cout<<"##       LOAD GOOD FROM FILE     ~~~            PRESS  4                     ##\n";
	cout<<"##         SAVE GOOD TO FILE     ~~~            PRESS  5                     ##\n";
	cout<<"##                                                                           ##\n";
	cout<<"               Enter your choose    ----> ";

	cin>>Main_Menu_Choose;
	cin.ignore();

	switch (Main_Menu_Choose)
	{
		case '0':
			break;
		case '1':
			Add_Good();
			break;
		case '2':
			View_All_Good();
			break;
		case '3':
			Borrow_Good();
			break;
		case '4':
			Load_Good_From_File();
			break;
		case '5':
			Save_Good_To_File();
			break;

		default:
			cout<<"\n##        Incorrect choose\n##        ";
			cout<<"Press any key to continue . . . ";
			getch();
			Interface();
		}
	}
void Add_Good()
{
	char ch;
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                ADD Good                                ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##  Enter the full name of the Good:   ";

	cin.getline(Item[Number_Of_Item].Name,25);
	while (strcmp(Empty.Name,Item[Number_Of_Item].Name)==0)
	{
		cout<<"##  Enter again:   ";
		cin.getline(Item[Number_Of_Item].Name,25);
		}

	cout<<"\n##  Enter the number of avalable item \""<<Item[Number_Of_Item].Name<<"\":    ";
	cin>>Item[Number_Of_Item].Avalable_Item;
	cin.ignore();
	Item[Number_Of_Item].Borrow=0;
	cout<<"\n##    "<<Item[Number_Of_Item].Name<<" is added successfully";
	Number_Of_Item++;
	cout<<"\n##    Do you want to add another Good?\n##  press   \"Y\" for YES or \"N\" for NO\n##      ";
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
	{
		clrscr();
		Add_Good();
		}
	else
		Interface();
	}
void View_All_Good()
{
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                VIEW Good                               ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##   Good Name   NUMBER   Borrow   Borrow by  Number of good Borrow\n";
	cout<<"##   =========  ========  ======   =========  =====================\n";
	if(Number_Of_Item>0)
	{
		for(int i=0;i<Number_Of_Item;i++)
		{
			cout<<"##   "<<Item[i].Name<<"\t"<<Item[i].Avalable_Item<<"\t";
			if(Item[i].Borrow)
				cout<<"TRUE"<<"\t"<<Item[i].User_Name<<"\t"<<Item[i].User_Borrow<<endl;
			else
				cout<<"FALSE"<<endl;
			if(i%10==9)
			{
				cout<<"##   press any key to see more . . . ";
				getch();
				}
			}
		}
	else
		cout<<"##   NO Good AVALABLE!!\n";
	cout<<"##   Press any key to continue . . . ";
	getch();
	Interface();
	}
void Borrow_Good()
{
	char temp[25];
	int t;
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                Borrow Good                                ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"## Choose from below list\n";
	for(int i=0;i<Number_Of_Item;i++)
	{
		cout<<"##   --> "<<Item[i].Name<<endl;
		}

	cout<<"##  Enter the name you want to borrow:    ";
	cin.getline(temp,25);
	while (strcmp(Empty.Name,temp)==0)
	{
		cout<<"##  Enter again:   ";
		cin.getline(Item[Number_Of_Item].Name,25);
		}

	t=Check_Name(temp,Number_Of_Item);
	if(t==-1)
	{
		cout<<"\t\tNO Good AVALABLE WITH THIS NAME\n";
		}
	else
	{
		Item[t].Borrow=1;
		cout<<"\n## Enter the name of the borrower:   ";
		cin.getline(Item[t].User_Name,25);

		while (strcmp(Empty.Name,Item[t].User_Name)==0)
		{
			cout<<"##  Enter again:   ";
			cin.getline(Item[t].User_Name,25);
			}

		cout<<"##  How much do you want to borrow!\n##  "<<Item[t].Avalable_Item<<" items are avalable\n##  ";
		cin>>Item[t].User_Borrow;
		while(Item[t].User_Borrow>Item[t].Avalable_Item)
		{
			cout<<"##  Must be less than Avalable Items\n##   TRY AGAIN:    ";
			cin>>Item[t].User_Borrow;
			}
		Item[t].Avalable_Item-=Item[t].User_Borrow;
		cout<<"\n##  Successfully borrowed!!!\n";
	}
	cout<<"##  Do you want to Borrow another?\n\t\tpress   \"Y\" for YES or \"N\" for NO\n##    -->  ";
	char ch;
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
	{
		clrscr();
		Borrow_Good();
		}
	else
		Interface();
}
void Load_Good_From_File()
{
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                        Load Good from file                                ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	ifstream in;
	in.open("Good.txt");
	if(in.fail())
	{
		cout<<"##      NO file recorded yet . . . ";
		getch();
		Interface();
	}
	while(!in.eof())
	{
		in.getline(Item[Number_Of_Item].Name,25,'.');
		in>>Item[Number_Of_Item].Avalable_Item;
		in.ignore();
		in>>Item[Number_Of_Item].Borrow;
		in.ignore();
		if(Item[Number_Of_Item].Borrow==1)
		{
			in.getline(Item[Number_Of_Item].User_Name,25,'.');
			in>>Item[Number_Of_Item].User_Borrow;
			in.ignore();
		}
		Number_Of_Item++;
	}
	Number_Of_Item--;
	cout<<"##      DONE LOADING";
	getch();
	Interface();
	}
void Save_Good_To_File()
{
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                          Save Good to file                                ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	ofstream out;
	out.open("Good.txt");
	if(out.fail())
	{
		cout<<"##      File can't be accessed  . . . ";
		getch();
		Interface();
	}
	if(Number_Of_Item>0)
	{
		for(int i=0;i<Number_Of_Item;i++)
		{
			out<<Item[i].Name<<"."<<Item[i].Avalable_Item<<"."<<Item[i].Borrow;
			if(Item[i].Borrow)
				out<<"."<<Item[i].User_Name<<"."<<Item[i].User_Borrow<<endl;
			else
				out<<endl;
		}
		cout<<"##     DONE SAVING\n";
	}
	else
		cout<<"##   NO Good AVALABLE!!\n";
	cout<<"##   Press any key to continue . . . ";
	getch();
	Interface();
}
int Check_Name (char temp[25],int Index_Of_Array)
{
	for(int i=0;i<=Index_Of_Array-1;i++)
	{
		if(strcmp(Item[i].Name,temp)==0)
			return i;
		}
	return -1;
}