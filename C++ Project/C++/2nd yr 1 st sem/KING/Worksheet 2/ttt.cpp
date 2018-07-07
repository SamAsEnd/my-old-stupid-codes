#include<iostream.h>
#include<math.h>
void main ()
{
int x,y,z,result;
cout<<"enter the first number   :";
cin>>x;
cout<<"enter the second number  :";
cin>>y;
cout<<"enter the thired number  :";
cin>>z;
result=(2*x)+sqrt(y*y+4*x*y)/(2*x);
cout<<"result="<<result;
}

