#include<iostream.h>
#include<conio.h>
void main(){
float Fn;
int In;
loop:
cin>>Fn;
In=Fn;
if(float (In)==Fn)
cout<<In;
else{
In++;
cout<<In<<endl;
}
goto loop;
}
