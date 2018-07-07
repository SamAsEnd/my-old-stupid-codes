#include<iostream.h>
#include<conio.h>
#include<fstream.h>
#include<iomanip.h>
#include<string.h>
#include<stdio.h>
#include<dos.h>
#include<stdlib.h>
//#include<graphics.h>
void org();
void rules();
void main()
{
clrscr();

textbackground(3);
textcolor(1);
cout<<"\t\t\t\t----------";
cout<<"\n\t\t\t\tWELCOME TO\n";
cout<<"\t\t\t\t----------"<<endl;
cout<<"\t\t\t -------------------------";
cout<<"\n\t\t\t*****BANKING MANAGEMENT SYSTEM*****\n";
cout<<"\t\t\t -------------------------";
cout<<"\n\n\nDevloped in C++ using Borland 5.2 compiler";
cout<<"\n\nDevloped By:-";
cout<<"\n\nName: Ruta H."<<"\nDepartment:CSED 2nd"<<"\nID:"
<<"\nSubmitted To: Ins. Mekonnen Fanta";
cout<<"\n\t -------------------------------------------------";
cout<<"\n\t BAHIR DAR UNIVERSITY (IoT)";
cout<<"\n\t -------------------------------------------------";
cout<<"\n\n\t PRESS ANY KEY TO CONTINUE..............";
getch();
clrscr();
char id[10],id1[10],id2[10],name[30],dist[35],street[30],intro[30];
char age[5],dob[15],quali[25],phone[15],occ[20],pincode[10];
int n,i,y1,m1,d2,n1,n2;
long nid;
struct date d1;
getdate(&d1);
int y=d1.da_year;
int m=d1.da_mon;

int d=d1.da_day;
long wamount=0;
long balance;
int initial=1000;
long dep,wid;
char trf[10]="Transfer";
char csh[10]="Deposit";
do
{
clrscr();
cout<<"\n\t\t\t-----------------------";
cout<<"\n\t\t\tBANK OF POLY";
cout<<"\n\t\t\t-----------------------";
cout<<"\n\n\t MAIN MENU.......\n";
cout<<"\n\t1.ORGANIZATION";
cout<<"\n\t2.NEW USER";
cout<<"\n\t3.EXISTING USER";
cout<<"\n\t4.EXIT";
cout<<"\n\n\tSELECT : ";
cin>>n;
int n3;
if(n!=4)
{
switch(n)
{
case 1:

{
clrscr();
org();
getch();
break;
}
case 2:
{
do
{
clrscr();
cout<<"\t\t\t\tNEW USER\n";
cout<<"\t\t\t\t--------";
cout<<"\n\t1.RULES";
cout<<"\n\t2.CREATE NEW ACCOUNT";
cout<<"\n\t3.EXIT";
cout<<"\n\n\tSELECT : "; cin>>n1;
if(n1!=3)
{
switch(n1)
{
case 1:
{
clrscr();
rules();
getch();

break;
}
case 2:
{
clrscr();
cout<<"\n\t\t\tRegistration Form";
cout<<"\n\t\t\t-----------------\n";
cout<<"\tName : "; gets(name);
cout<<"\tAge : "; gets(age);
cout<<"\tDate of Birth : "; gets(dob);
cout<<"\tQualification : "; gets(quali);
cout<<"\tOccupation : "; gets(occ);
cout<<"\tPhone No. : "; gets(phone);
cout<<"\tStreet : "; gets(street);
cout<<"\tDistrict : "; gets(dist);
cout<<"\tPin Code : "; gets(pincode);
cout<<"\tIntroducer : "; gets(intro);
int count;
char nidfile[15];
ifstream reg("id.txt");
reg>>nidfile>>count;
strcat(nidfile,".txt");
reg.close();
ifstream reg11("id.txt");
reg11>>nid>>count;
reg11.close();

ofstream cus("customer.txt",ios::ate);
cus<<nid<<" "<<count<<" "<<name<<" " <<age<<" "<<street<<" "<<dist<<" "<<pincode<<" "<<dob<<" "<<quali<<" "<<occ<<" "<<phone<<" "<<intro<<" "<<endl;
cus.close();
ofstream cusdata(nidfile);
cusdata<<nid<<" "<<initial; //<<" "<<d<<" "<<m<<" "<<y<<"Deposit";
cusdata.close();
randomize();
cout<<"\n\t\t\t\t\tYOUR ACCOUNT IS CREATED\n";
cout<<"\t\t\tYOUR ACCOUNT NUMBER IS : "<<nid;
cout<<"\n\t\t\tYOUR PIN NUMBER IS : "<<count;
cout<<"\n\t\t\tYOUR BALANCE : "<<initial;
cout<<"\n\t\t\tPRESS ANY KEY TO GO BACK IN MAIN MENU";
nid=nid+1;
int a=random(10);
count=count+a+1;
reg11.close();
ofstream add("id.txt");
add<<nid<<" "<<count;
add.close();
getch();
clrscr();
break;
}
default:
{

break;
}
}
}
}while(n1!=3);
break;
}
case 3:
{
do
{
clrscr();
cout<<"\n\t\t\tExisting Users";
cout<<"\n\t\t\t--------------\n";
cout<<"\n\t1.DEPOSIT";
cout<<"\n\t2.CREDIT";
cout<<"\n\t3.DELETE";
cout<<"\n\t4.ENTRY";
cout<<"\n\t5.DETAILS";
cout<<"\n\t6.EXIT";
cout<<"\n\n\tSELECT : ";
cin>>n3;
if(n3!=6)
{
switch(n3)
{

case 1:
{
clrscr();
int ch1;
cout<<"\n\t\t\tDEPOSIT SECTION";
cout<<"\n\t\t\t---------------";
cout<<"\n\tAccount number : "; gets(id);
strcpy(id1,id);
strcat(id1,".txt");
ifstream dlch(id1);
dlch>>ch1;
if(ch1==1)
{
cout<<"\nYOUR ACCOUNT IS DELETED";
}
else
{
// cout<<"Amount Deposit : ";cin>>dep;
ifstream inout(id1);
ofstream inout1(id1,ios::ate|ios::in|ios::out|ios::binary);
inout.seekg(7);
inout1.seekp(7);
inout>>balance;
cout<<"\n\tYour Balance : "<<balance;
cout<<"\n\tAmount Deposit : ";cin>>dep;

balance=balance+dep;
inout1<<balance;
inout.close();
inout1.close();
wamount=dep;
ofstream deposit2(id1,ios::ate,ios::end);
deposit2<<endl<<balance<<" "<<y<<" "<<d<<" "<<m<<" "<<wamount<<" "<<csh;
deposit2.close();
// inout.close();
// inout1.close();
cout<<"\n\tNow Your Current Balance : "<<balance;
}
getch();
clrscr();
break;
}
case 2:
{
clrscr();
int check;
cout<<"\n\t\t\tWITH DRAW SCETION";
cout<<"\n\t\t\t-----------------";
cout<<"\n\tAccount number : "; gets(id);
strcpy(id1,id);

strcat(id1,".txt");
ifstream delcheck(id1);
delcheck>>check;
if(check==1)
{
cout<<"\nYOUR ACCOUNT IS DELETED";
}
else
{
// cout<<"Amount Withdraw : ";cin>>dep;
ifstream inout(id1);
ofstream inout1(id1,ios::ate|ios::in|ios::out|ios::binary);
inout.seekg(7);
inout1.seekp(7);
inout>>balance;
long fb;
cout<<"\tBalance : "<<balance;
if(balance<=1000)
{
cout<<"\nLESS THAN MINIMUM BALANCE -- RS 1000";
}
else
{
cout<<"\n\tAmount Withdraw : ";
cin>>dep;

fb=balance-dep;
if(balance<=dep)
{
cout<<"BALLANCE LESS THAN WITH DRAW AMOUNT";
}
else if (fb<1000)
{
cout<<"FINAL BALANCE LESS THAN1000\nSO YOU CANT WITHDRAW SPECIFIED AMOUNT";
}
else
{
balance=fb;
inout1<<balance;
inout.close();
inout1.close();
cout<<"\n\n\n\t\t\tYOUR AMOUNT WITHDRAW SUCCESSFULLY\n";
wamount=dep;
ofstream deposit2(id1,ios::ate,ios::end);
deposit2<<endl<<balance<<" "<<y<<" "<<d<<" "<<m<<" "<<wamount<<" "<<trf;
deposit2.close();
// inout.close();
// inout1.close();

cout<<"\tNow Your Balance : "<<balance;
}
}
}
getch();
clrscr();
break;
}
case 3:
{
clrscr();
char pin[10],pin1[10],idd[10],idd1[10],ans;
cout<<"\n\t\t\tDELETE SECTION\n";
cout<<"\tAccount Number :" ; gets(idd1);
cout<<"\tPin Number : "; gets(pin);
ifstream cus1("customer.txt");
cout<<"Confirm to delete "<<idd1<<" ACCOUNT :(y/n)";
cin>>ans;
if(ans=='y'||'Y')
{
strcpy(id1,idd1);
strcat(id1,".txt");
ofstream del(id1);
del<<"1"<<" "<<"ACCOUNT DELETED";
del.close();
ofstream del1("delete.txt",ios::ate);

del1<<idd1;
del1.close();
cout<<"\n\n\t\t\tYour Account Is Deleted";
}
else
{
cout<<"Go To Main Menu";
}
getch();
break;
}
case 4:
{
clrscr();
int ch2;
cout<<"\n\t\t\tENTRY SECTION\n";
cout<<"\nAccount Number : "; gets(id);
strcpy(id1,id);
strcat(id1,".txt");
ifstream edel(id1);
edel>>ch2;
if(ch2==1)
{
cout<<"YOUR ACCOUNT IS DELETED";
}

else
{
ifstream detail(id1);
int dd=0;
cout<<endl;
char type[10];
cout<<"Date Amount Tpye Balance\n";
cout<<"-----------------------------------------\n";
while(!detail.eof())
{
if(dd!=0)
{
detail>>balance>>y>>d>>m>>wamount>>type;
cout<<d<<"-"<<m<<"-"<<y<<" "<<wamount<<" "<<type<<" "<<balance<<endl;
}
else
{
detail>>id>>balance;//>>y>>d>>m>>wamount>>type;
dd++;
}
}
}
getch();

break;
}
case 5:
{
clrscr();
long d1;
int pp1,count;
cout<<"\t\t\tDETAILS";
cout<<"\n\tAccount Number : "; cin>>d1;
cout<<"\n\tPin Number : "; cin>>pp1;
//cus<<nid<<" "<<count<<" "<<name<<" " <<age<<" "<<street<<" "<<dist<<" "<<pincode<<" "<<dob<<" "<<quali<<" "<<occ<<" "<<phone<<" "<<intro<<" "<<endl;
ifstream cus("customer.txt");
int aa=0;
while(!cus.eof())
{
cus>>nid>>count>>name>>age>>street>>dist>>pincode>>dob>>quali>>occ>>phone>>intro;
aa=0;
if(d1==nid && pp1==count)
{
cout<<"\nNAME : "<<name;
cout<<"\nAGE : "<<age ;
cout<<"\nDATE OF BIRTH : "<<dob ;

cout<<"\nADDRESS : "<<street<<",";
cout<<"\n "<<dist<<",";
cout<<"\n "<<pincode<<".";
cout<<"\nPHONE NUMBER : "<<phone;
cout<<"\nQUALIFICATION : "<<quali;
cout<<"\nOCCUPATION : "<<occ;
cout<<"\nINTRODUCER : "<<intro;
break;
}
else
{
aa=1;
}
}
if(aa==1)
{
cout<<"TRY AGAIN " ;
}
getch();
break;
}
default:
{
break;
}

}
}
}while(n3!=6);
break;
}
default:
{
break;
}
}
}
}while(n!=4);
}
void org()
{
cout<<"\n\t\t\t\t----------------------";
cout<<"\n\t\t\t\tBANK OF POLY";
cout<<"\n\t\t\t\t----------------------";
cout<<"\n\n\n\t\t\t\tABOUT ORGANIZTION";
cout<<"\n\n\tFOUNDED AT SINCE 14/1/2013";
cout<<"\n\n\tFOUNDED BY :THE SOCIETY OF BDU, POLY Email: bankofpolly@yahoo.com ";
cout<<"\n\t\t\t CITY: BAHIR DAR"<<"\n\t\t\t KEBELE: 10";
cout<<"\----------------------------------------------";
cout<<"\n\n\nPRESS ANY KEY TO GO BACK IN MAIN MENU.........";

}
void rules()
{
clrscr();
cout<<"\n\t\t\t\t---------------------------------------";
cout<<"\n\t\t\t\BANK OF POLY";
cout<<"\n\t\t\t\t---------------------------------------";
cout<<"\n\t Rules To Create New Account:\n";
cout<<"\n\t Your Minimum balance should be Rs.1000";
cout<<"\n\t Your Account is cancelled when you cannot transaction";
cout<<"\n\t within 3 months";
}