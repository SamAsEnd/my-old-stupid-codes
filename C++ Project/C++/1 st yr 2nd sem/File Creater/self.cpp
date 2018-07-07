//   Don't rename the src file
#include <iostream.h>
#include <fstream.h>
void main()
{
	ifstream sami;
	char ch[100];
	sami.open("self.cpp");
	while(!sami.eof())
	{
		sami.getline(ch,100);
		cout<<ch<<endl;
	}
	sami.close();
}