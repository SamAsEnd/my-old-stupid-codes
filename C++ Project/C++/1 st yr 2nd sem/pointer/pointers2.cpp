#include <iostream>
using namespace std;

int main(){

double arr[] = {5.0, 6.0, 7.0, 8.0};

double *p = (arr+2);

cout << *p << endl;   // 1
cout << arr << endl;    // 2
cout << *(arr+3) << endl;  // 3
cout << *(arr) << endl;  // 4
cout << *arr+9 << endl;  // 5
cin>>arr[2];
return 0;
}
