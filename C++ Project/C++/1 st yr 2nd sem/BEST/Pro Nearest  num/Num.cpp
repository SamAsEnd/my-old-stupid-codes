#include<iostream.h>
#include<conio.h>
int test12(double x){
int tem=x;
double z=x-(double)tem;
if (z>0.5)
return ++x;
else
return x;
}
void main(){
double Fn;
loop:
cin>>Fn;
int te=test12(Fn);
cout<<te<<endl;
goto loop;
}
