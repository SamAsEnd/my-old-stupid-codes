#include <iostream.h>
#include <fstream.h>
#include <string.h>
void main()
{
	ofstream sami;               //Open the file stream
	char file[25],ch[100];
	cout<<"Enter the file name";
	cin.getline(file,25);
	strcat(file,".txt");
	sami.open(file);		//Connect to a file
	if(sami.good())
	{
		cout<<"Enter the txt below:\npress 'X' and enter to stop typing:\n";
		while( ch[0]!='X' || ch[0]=='x' )
		{
			cin.getline(ch,100);
			sami<<ch<<endl;
		}
		cout<<"\n\nDone   saved on "<<file;
	}
	else
	{
		cout<<"Error saving file";
	}
	sami.close();							   //   close the connection to FREE the file
}