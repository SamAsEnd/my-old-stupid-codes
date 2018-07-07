#include<iostream.h>
void main ()
{
int score;
char grade;
cout<<"enter ur score";
cin>>score;
switch (score/10)
{
case 10:
case 9:
grade='A';
break;
case 8:
case 7:
grade='B';
break;
case 6:
case 5:
grade='C';
break;
default:
grade='F';
}
cout<<grade;
}