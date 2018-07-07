#include <iostream>
using namespace std;
int main()
{
    long long num = 2;
    int sum = 0;
    
    for (int i = 2; i <= 50; i++)
        num += 2;
        
    cout << num << endl;
    
    while (num > 0)
    {
          sum += num % 10;
          num = num / 10;
    }
    
    cout << sum << endl;
    
    system("PAUSE");
    return 0;
}
