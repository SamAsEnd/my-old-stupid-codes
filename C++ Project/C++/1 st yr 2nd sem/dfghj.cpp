#include <iostream>
#include <conio>
int main()
{
int a, b, c, sum;
double avg;

cout<< "Enter the number: "<<endl;
cout<< "First number: "<<endl;
cin>> a;
cout<< "Second number: "<<endl;
cin>> b;
cout<< "Third number: "<<endl;
cin>> c;

sum = a + b + c;
avg = sum / 3;

if (a>b) && (a>c) && (b>c)
{
cout<< "The Maximum is: "<<a <<endl;
cout<< "The minimum is: "<<c <<endl;
}
else if (a>b) && (a>c) && (c>b)
{
cout<< "The Maximum is: "<<a <<endl;
cout<< "The minimum is: "<<b <<endl;
}
else if (c>a>b)
{
cout<< "The Maximum is: "<<c <<endl;
cout<< "The minimum is: "<<b <<endl;
}
else if (c>b>a)
{
cout<< "The Maximum is: "<< c<<endl;
cout<< "The minimum is: "<< a<<endl;
}
else if (b>a)&&(b>c)&&(a>c)
{
cout<< "The Maximum is: "<< b<<endl;
cout<< "The minimum is: "<< c<<endl;
}
else (b>a)&&(b>c)&&(c>a)
{
cout<< "The Maximum is: "<< b<<endl;
cout<< "The minimum is: "<< c<<endl;
}
cout << "The sum is: "<< sum <<endl;
cout << "The averege is: "<< avg <<endl;
}
