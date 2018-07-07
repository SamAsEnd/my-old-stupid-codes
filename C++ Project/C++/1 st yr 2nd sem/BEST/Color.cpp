#include <cstdlib>
#include <iostream>

using namespace std;

int main()
{
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
		{
            system("pause");
			system("COLOR "+i+""+j+"");
		}
	}
	system("pause");
	return 0;
}
