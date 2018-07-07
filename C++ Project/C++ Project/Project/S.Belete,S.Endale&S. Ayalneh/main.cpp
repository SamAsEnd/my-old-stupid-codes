/****************************************************************************************************
|	Samson Belete  ------  0401364																	|
|	Samson Endale  ------  0401365																	|
|	Samuel Ayalneh ------  0401375																	|
|																									|
|	Title																							|
|		:->	  Telephone Directory																	|
|																									|
|	Activities and explanations																		|
|																									|
|		:->	  your program allows user to create a file consisting of list of names with their		|
|			  corresponding telephone number. The user can update names and telephone numbers.		|
|			  Name must be unique. if users tries to input the same name more than one time, your	|
|			  program must display a message saying "The name is used by an other customer" and let |
|			  user input approprite name.															|
|	concepts used																					|
|																									|
|		:->   FILE I/O																				|
*****************************************************************************************************/

/**********************************    Header files    *********************************************/
#include <iostream.h>
#include <conio.h>
#include <fstream.h>
#include <string.h>
/**********************************    Struct    ***************************************************/
struct Contact_Struct
{
	char Name[25];
	unsigned long Number;
	};
/**********************************    Global Variables    *****************************************/
Contact_Struct Contact[1000];
unsigned int Number_Of_Contact=0;
char temp[25];
int t;
/**********************************    Function Prototype    ***************************************/
void Main_Manu();
void Add_Contact();
void View_All_Contact();
void Update_Contact();
void Delete_Contact();
void Load_Contact_From_File();
void Save_Contact_To_File();
int Check_Name_4_Duplication (char temp[25]);
/**********************************    Main function    *********************************************/
void main()
{
	Main_Manu();
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                                                           ##\n";
	cout<<"##                      WELCOME TO TELEPHONE DIRECTORY                       ##\n";
	cout<<"##                                                                           ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                                                           ##\n";
	cout<<"##                        *  PROGRAM TERMINETED  *                           ##\n";
	cout<<"##                               GOOD BYE                                    ##\n";
	}
/**********************************    Main Manu    ***************************************************/
void Main_Manu()
{
	char Main_Menu_Choose;
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                      WELCOME TO TELEPHONE DIRECTORY                       ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                MAIN MENU                                  ##\n";
	cout<<"##                   EXIT            >>>            PRESS  0  or  E          ##\n";
	cout<<"##                 ADD CONTACT       >>>            PESSS  1  or  A          ##\n";
	cout<<"##            VIEW ALL CONTACT       >>>            PRESS  2  or  V          ##\n";
	cout<<"##               UPDATE CONTACT      >>>            PRESS  3  or  U          ##\n";
	cout<<"##              DELETE CONTACT       >>>            PRESS  4  or  D          ##\n";
	cout<<"##       LOAD CONTACT FROM FILE      >>>            PRESS  5  or  L          ##\n";
	cout<<"##         SAVE CONTACT TO FILE      >>>            PRESS  6  or  S          ##\n";
	cout<<"##    VIEW NUMBER OF CONTACTS SAVE   >>>            PRESS  7                 ##\n";
	cout<<"##                                                                           ##\n";
	cout<<"##             Enter your choose    ----> ";

	cin>>Main_Menu_Choose;
	cin.ignore();
	switch (Main_Menu_Choose)
	{
		case '0':
		case 'E':
		case 'e':
			break;
		case '1':
		case 'A':
		case 'a':
			Add_Contact();
			break;
		case '2':
		case 'V':
		case 'v':
			View_All_Contact();
			break;
		case '3':
		case 'U':
		case 'u':
			Update_Contact();
			break;
		case '4':
		case 'D':
		case 'd':
			Delete_Contact();
			break;
		case '5':
		case 'L':
		case 'l':
			Load_Contact_From_File();
			break;
		case '6':
		case 'S':
		case 's':
			Save_Contact_To_File();
			break;
		case '7':
			if(Number_Of_Contact==0)
				cout<<"##                   NO CONTACT AVALABLE\n";
			else
				cout<<"##                   NUMBER OF CONTACT SAVED ARE "<<Number_Of_Contact<<endl;
			cout<<"##                   Press any key to continue . . . ";
			getch();
			Main_Manu();
			break;
		default:
			cout<<"\n##        Incorrect choose\n";
			cout<<"##        Press any key to continue . . . ";
			getch();
			Main_Manu();
		}
	}
/**********************************    Add Contact    *************************************************/
void Add_Contact()
{
	char ch;
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                ADD CONTACT                                ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	if(Number_Of_Contact>999)
	{
		cout<<"##                                                                           ##\n";
		cout<<"##               Contact is full                                             ##\n";
		cout<<"##         Press any key to continue . . . ";
		getch();
		Main_Manu();
	}
	cout<<"##  Enter the full name of the Contact:   ";

	cin.getline(Contact[Number_Of_Contact].Name,25);

	while (strcmp(Contact[Number_Of_Contact].Name,"")==0)
	{
		cout<<"##  Enter again:   ";
		cin.getline(Contact[Number_Of_Contact].Name,25);
		}

	while(Check_Name_4_Duplication(Contact[Number_Of_Contact].Name)!=-1)
	{
		cout<<"\n##  Name is used by another customer\n";
		cout<<"##   Enter again:   ";
		cin.getline(Contact[Number_Of_Contact].Name,25);
		while (strcmp(Contact[Number_Of_Contact].Name,"")==0)
		{
			cout<<"##  Enter again:   ";
			cin.getline(Contact[Number_Of_Contact].Name,25);
		}
	}

	cout<<"\n##  Enter the Number for \""<<Contact[Number_Of_Contact].Name<<"\":    ";
	cin>>Contact[Number_Of_Contact].Number;
	cin.ignore();
	cout<<"\n##    "<<Contact[Number_Of_Contact].Name<<" is added successfully";
	Number_Of_Contact++;
	cout<<"\n##    Do you want to add another contact?\n##  press   \"Y\" for YES or \"N\" for NO\n##      ";
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
	{
		clrscr();
		Add_Contact();
		}
	else
		Main_Manu();
	}
/**********************************    View All Contact    ********************************************/
void View_All_Contact()
{
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                VIEW CONTACT                               ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##   Contact Name -> PHONE NUMBER\n";
	cout<<"##   ============ -> ============\n";
	if(Number_Of_Contact>0)
	{
		for(int i=0;i<Number_Of_Contact;i++)
		{
			cout<<"##   "<<Contact[i].Name<<"     -> "<<Contact[i].Number<<endl;
			if(i%15==14)
			{
				cout<<"##   press any key to see more . . . ";
				getch();
			}
		}
	}
	else
		cout<<"##                   NO CONTACT AVALABLE\n";
	cout<<"##   Press any key to continue . . . ";

		getch();
	Main_Manu();
	}
/**********************************    Update Contact    **********************************************/
void Update_Contact()
{
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                UPDATE CONTACT                             ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	if(Number_Of_Contact==0)
	{
		cout<<"##                   NO CONTACT AVALABLE\n";
		cout<<"##               Press any key to continue . . . ";
		getch();
		Main_Manu();
	}
	else
	{
		for(int i=0;i<Number_Of_Contact;i++)
		{
			cout<<"##   --> "<<Contact[i].Name<<endl;
			}

		cout<<"##  Enter the contact name from above list you want to update:    ";
		cin.getline(temp,25);
		while (strcmp(temp,"")==0)
		{
			cout<<"##  Enter again:   ";
			cin.getline(temp,25);
			}

		t=Check_Name_4_Duplication(temp);
		if(t==-1)
		{
			cout<<"##     NO CONTACT AVALABLE WITH THIS NAME\n";
			}
		else
		{
			cout<<"\n##   Contact Name,PHONE NUMBER\n";
			cout<<"##   ============,============\n";
			cout<<"##   "<<Contact[t].Name<<"     -> "<<Contact[t].Number<<endl;
			strcpy(Contact[t].Name,"");
			Contact[t].Number=0;
			cout<<"##  Enter the \"NEW\" full name of the Contact:   ";
			cin.getline(temp,25);
			while (strcmp(temp,"")==0)
			{
				cout<<"##  Enter again:   ";
				cin.getline(temp,25);
				}
			while(Check_Name_4_Duplication(temp)!=-1)
			{
				cout<<"\n##   Name is used by another customer\n";
				cout<<"##   Enter again:   ";
				cin.getline(temp,25);
				while (strcmp(temp,"")==0)
				{
					cout<<"##  Enter again:   ";
					cin.getline(temp,25);
				}
			}
			strcpy(Contact[t].Name,temp);
			cout<<"\n##    Enter the Number for \""<<Contact[t].Name<<"\":    ";
			cin>>Contact[t].Number;
			cin.ignore();

			cout<<"\n##    "<<Contact[t].Name<<" is added successfully";
			cout<<"\n##    Successfully UPDATED!!!\n";
		}
		cout<<"##  Do you want to UPDATED another?\n\t\tpress   \"Y\" for YES or \"N\" for NO\n##    -->  ";
		char ch;
		cin>>ch;
		cin.ignore();
		if(ch=='Y'||ch=='y')
		{
			clrscr();
			Update_Contact();
			}
		else
			Main_Manu();
	}
}
/**********************************    Delete Contact    **********************************************/
void Delete_Contact()
{
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                                DELETE CONTACT                             ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	for(int i=0;i<Number_Of_Contact;i++)
	{
		cout<<"##   --> "<<Contact[i].Name<<endl;
		}

	cout<<"##  Enter the contact name from above list you want to delete:    ";
	cin.getline(temp,25);

	while (strcmp(temp,"")==0)
	{
		cout<<"##  Enter again:   ";
		cin.getline(temp,25);
		}

	t=Check_Name_4_Duplication(temp);
	if(t==-1)
	{
		cout<<"\t\tNO CONTACT AVALABLE WITH THIS NAME\n";
		}
	else
	{
		for(int i=t;i<Number_Of_Contact;i++)
		{
			strcpy(Contact[i].Name,Contact[i+1].Name);
			Contact[i].Number=Contact[i+1].Number;
		}
		Number_Of_Contact--;
		cout<<"\n##    Successfully DELETED!!!\n";
	}
	cout<<"##    Do you want to DELETE another?\n\t\tpress   \"Y\" for YES or \"N\" for NO\n##    -->  ";
	char ch;
	cin>>ch;
	cin.ignore();
	if(ch=='Y'||ch=='y')
	{
		clrscr();
		Delete_Contact();
		}
	else
		Main_Manu();
}
/**********************************    Load Contact From File    **************************************/
void Load_Contact_From_File()
{
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                         LOAD CONTACT FROM FILE                            ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	ifstream IN;
	IN.open("Contact.txt");
	t=0;
	if(IN.fail())
	{
		cout<<"##      NO file recorded yet . . . ";
		getch();
		Main_Manu();
		}
	else
	{
		while(!IN.eof())
		{
			IN.getline(Contact[Number_Of_Contact].Name,25,',');
			IN>>Contact[Number_Of_Contact].Number;
			IN.ignore();
			if(Check_Name_4_Duplication (Contact[Number_Of_Contact].Name)==-1)
			{
				Number_Of_Contact++;
				t++;
			}
		}
		IN.close();
		Number_Of_Contact--;
		t--;
		cout<<"##\t\tDONE LOADING  "<<t<<" CONTACT"<<endl;
		cout<<"##\t\tPress any key to continue . . . ";
		getch();
		Main_Manu();
	}
}
/**********************************    Save Contact From File    **************************************/
void Save_Contact_To_File()
{
	clrscr();
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";
	cout<<"##                         SAVE CONTACT TO FILE                              ##\n";
	cout<<"##~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~##\n";

	if (Number_Of_Contact==0)
	{
		cout<<"##                   NO CONTACT AVALABLE\n";
		cout<<"##               Press any key to continue . . . ";
		getch();
		Main_Manu();
	}
	else
	{
		ofstream OUT;
		OUT.open("Contact.txt");
		if(OUT.fail())
		{
			cout<<"##      Failed to Save to file . . . ";
			getch();
			Main_Manu();
		}
		else
		{
			for(int i=0;i<Number_Of_Contact;i++)
			{
				OUT<<Contact[i].Name<<","<<Contact[i].Number<<endl;
			}
			cout<<"##  \tDONE";
		}
		cout<<"\n##  Press any key to continue . . . ";
		getch();
		Main_Manu();
	}
}
/**********************************    Check_Name_4_Duplication    ************************************/
int Check_Name_4_Duplication (char temp[25])
{
	for(int i=0;i<Number_Of_Contact;i++)
	{
		if(strcmp(Contact[i].Name,temp)==0)
			return i;
	}
	return -1;
}

/****************************************************************************************************
|	Samson Belete  ------  0401364																	|
|	Samson Endale  ------  0401365																	|
|	Samuel Ayalneh ------  0401375																	|
|																									|
|	Title																							|
|		:->	  Telephone Directory																	|
|																									|
|	Activities and explanations																		|
|																									|
|		:->	  your program allows user to create a file consisting of list of names with their		|
|			  corresponding telephone number. The user can update names and telephone numbers.		|
|			  Name must be unique. if users tries to input the same name more than one time, your	|
|			  program must display a message saying "The name is used by an other customer" and let |
|			  user input approprite name.															|
|	concepts used																					|
|																									|
|		:->   FILE I/O																				|
*****************************************************************************************************/








