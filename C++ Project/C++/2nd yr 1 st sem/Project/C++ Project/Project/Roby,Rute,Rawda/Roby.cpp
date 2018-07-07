#include <iostream.h>
#include <conio.h>
#include <string.h>
struct ACCOUNT_STRUCTURE
{
	char Name[20];
	unsigned int Age;
	unsigned long Phone;
	unsigned int Pin;
	unsigned long Account_Number;
	unsigned long Balance;
};
const int SSS=10000;
ACCOUNT_STRUCTURE Account[100];
int Account_Used=0;
void Menu();
void Creat_Account();
void Existing_Account();
	void Deposit_Account(int Index);
	void Withdraw_Account(int Index);
	void View_Account(int Index);
	void Close_Account(int Index);
char temp[20];
unsigned int choose;
void main()
{
	clrscr();
	Menu();
	clrscr();
	cout<<"\n                                BANKING\n";
	cout<<"                               =========\n";
	cout<<"                              ===========\n";
	cout<<"\n                                EXITED\n";
}
void Menu()
{
	clrscr();
	cout<<"\n                                BANKING\n";
	cout<<"                               =========\n";
	cout<<"                              ===========\n";
	cout<<"    0   ->   Exit\n";
	cout<<"    1   ->   New User\n";
	cout<<"    2   ->   Existing User\n";
	cout<<"   Enter your choose --->  ";
	cin>>choose;
	cin.ignore();
	if(choose==0);
	else if(choose==1)
		Creat_Account();
	else if(choose==2)
	{
		if(Account_Used==0)
		{
			cout<<"   No Accout AVALABLE NOW!!";
			cout<<"   Press any key to go to Menu . . . ";
			getch();
			Menu();
			}
		else
		{
			Existing_Account();
		}
	}
	else
	{
		cout<<"\n     Invalid choose\n";
		cout<<"   Press any key to try again . . . ";
		getch();
		Menu();
		}
}
void Creat_Account()
{
	clrscr();
	cout<<"\n                                Creat Account\n";
	cout<<"                               ===============\n";
	cout<<"                              =================\n";
	if(Account_Used>99)
	{
		cout<<"          Account full\n   ";
		getch();
		Menu();
	}
	cout<<"      Name:   ";
	cin.getline(temp,20);
	while(strcmp(temp,"")==0)
	{
		cout<<"    Try Again:   ";
		cin.getline(temp,20);
		}
	strcpy(Account[Account_Used].Name,temp);
	cout<<"      Age:   ";
	cin>>Account[Account_Used].Age;

	cout<<"      Phone number:   ";
	cin>>Account[Account_Used].Phone;
	cout<<"      Choose your pin number:   ";
	cin>>Account[Account_Used].Pin;
	while(Account[Account_Used].Pin<1000)
	{
		cout<<"     Pin must be atleast 4 digit:    ";
		cin>>Account[Account_Used].Pin;
		}
	Account[Account_Used].Account_Number=SSS+Account_Used;
	cout<<"     your account number is "<<Account[Account_Used].Account_Number;
	Account[Account_Used].Balance=0;
	View_Account(Account_Used);
	Account_Used++;
	Menu();
}
void Existing_Account()
{
	unsigned int tt,t;
	clrscr();
	cout<<"\n                             Existing Account\n";
	cout<<"                             ================\n";
	cout<<"                            ==================\n";
	cout<<"          Enter your Account number:    ";
	cin>>tt;
	cin.ignore();
	tt-=10000;
	if(tt>Account_Used)
	{
		cout<<"      Invalid Account number\n     press any key to Enter again . . . ";
		getch();
		Existing_Account();
		}
	cout<<"          Enter your Name:    ";
	cin.getline(temp,20);
	while(strcmp(temp,"")==0)
	{
		cout<<"    Try Again:   ";
		cin.getline(temp,20);
		}
	if(strcmp(Account[tt].Name,temp)!=0)
	{
		cout<<"     Name and Account number doesn't match\n     press any key to Enter again . . . ";
		getch();
		Existing_Account();
		}
	int i=0;
	while(1)
	{

		cout<<"          Enter your pin number:    ";
		cin>>t;
		if(Account[tt].Pin==t)
			break;
		else
			cout<<"           Incorrect PIN\n";
		if(i>=2)
		{
			cout<<"          you entered Incorrect PIN for 3 times";
			cout<<"\n        press any key to Enter again . . . ";
			getch();
			Existing_Account();
		}
		i++;
	}
	Enter_Again:
	clrscr();
	cout<<"\n                            Welcome "<<Account[tt].Name<<endl;
	cout<<"                            ================\n";
	cout<<"                           ==================\n";
	cout<<"     choose\n";
	cout<<"    1   ->   Deposit Account\n";
	cout<<"    2   ->   Withdraw Account\n";
	cout<<"    3   ->   View Account\n";
	cout<<"    4   ->   Close Account\n";
	cout<<"    5   ->   Back to Menu\n";
	cout<<"   Enter your choose --->  ";
	cin>>choose;
	cin.ignore();
	switch (choose)
	{
		case 1:
			Deposit_Account(tt);
			break;
		case 2:
			Withdraw_Account(tt);
			break;
		case 3:
			View_Account(tt);
			break;
		case 4:
			Close_Account(tt);
			break;
		case 5:
			Menu();
			break;
		default:
			cout<<"      Incorrect choose\n      Press any key . . . ";
			getch();
			goto Enter_Again;
	}
	goto Enter_Again;
}
void Deposit_Account(int Index)
{

	int cash;
	clrscr();
	cout<<"\n                            Welcome "<<Account[Index].Name<<"\n";
	cout<<"                            ================\n";
	cout<<"                           ==================\n";
	cout<<"     How much do you want to deposit:    ";
	cin>>cash;
	cin.ignore();
	Account[Index].Balance+=cash;
	cout<<"     New Account balance = "<<Account[Index].Balance<<" ETB";
	cout<<"\n      Press any key . . . ";
	getch();
}
void Withdraw_Account(int Index)
{
	int cash;
	clrscr();
	cout<<"\n                            Welcome "<<Account[Index].Name<<"\n";
	cout<<"                            ================\n";
	cout<<"                           ==================\n";
	cout<<"     How much do you want to withdraw:    ";
	cin>>cash;
	while(Account[Index].Balance<cash)
	{
		cout<<"     You only have  "<<Account[Index].Balance<<"\n     Enter again:  ";
		cin>>cash;
		}
	Account[Index].Balance-=cash;
	cout<<"     New Account balance = "<<Account[Index].Balance<<" ETB";
	cout<<"\n      Press any key . . . ";
	getch();
}
void View_Account(int Index)
{
	clrscr();
	cout<<"\n                               VIEW Account\n";
	cout<<"                               ============\n";
	cout<<"                              ==============\n";
	cout<<"\t\tName            ->   "<<Account[Index].Name<<endl;
	cout<<"\t\tAge             ->   "<<Account[Index].Age<<endl;
	cout<<"\t\tPhone number    ->   "<<Account[Index].Phone<<endl;
	cout<<"\t\tPIN number      ->   "<<Account[Index].Pin<<endl;
	cout<<"\t\tAccount_Number  ->   "<<Account[Index].Account_Number<<endl;
	cout<<"\t\tBalance         ->   "<<Account[Index].Balance<<endl;
	cout<<"\n      Press any key . . . ";
	getch();
}
void Close_Account(int Index)
{
	for(int i=Index;i<Account_Used;i++)
	{
		strcpy(Account[i].Name,Account[i+1].Name);
		Account[i].Age=Account[i+1].Age;
		Account[i].Phone=Account[i+1].Phone;
		Account[i].Pin=Account[i+1].Pin;
		Account[i].Account_Number=Account[i+1].Account_Number;
		Account[i].Balance=Account[i+1].Balance;
		}
	Account_Used--;
	clrscr();
	cout<<"     Succesfully Deleted!";
	cout<<"\n      Press any key . . . ";
	getch();
	Menu();
}












			
			
			
			
			
			
			
			
