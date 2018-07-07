#include <iostream>
using namespace std;

int factorial(int) , n;

int main()
{
    cout << "Enter The Number: " << endl;
    cin >> n;
    cout << factorial(n)<< endl;
    
    system("PAUSE");
    return 1;
}

int factorial(int n)
{
    if(n == 0)
    {
         return 1;
    }
    return n* factorial(n-1);
}
