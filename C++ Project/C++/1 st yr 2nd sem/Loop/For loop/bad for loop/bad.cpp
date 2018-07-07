#include<iostream.h>
void main(){
int sum;
cout<<"What is 2+2?\n";
cin>>sum;
for ( ;sum!=4; ){
cout<<"Incorrect answer. What is 2+2?\n";
cin>>sum;
}
cout<<"your right!";
}