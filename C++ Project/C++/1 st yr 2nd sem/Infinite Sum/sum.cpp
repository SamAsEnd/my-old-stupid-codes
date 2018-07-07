#include<iostream.h>
#include<conio.h>
void main(){
float num1,num2;
cout<<"Enter the first number: \n";
cin>>num1;
float sum=num1;
int i;
for(i=2;i>0;i++){
cout<<"Enter the second number: \n";
cout<<sum<<"+";
cin>>num2;
sum+=num2;
cout<<"The sum of the "<<i<<" numbers is :    "<<sum;
cout<<"\nPress Enter to continue\n";
getch();
clrscr();
}}



