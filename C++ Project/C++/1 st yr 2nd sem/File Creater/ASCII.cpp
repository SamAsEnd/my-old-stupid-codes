#include <iostream.h>
#include <fstream.h>
void main()
{
	ofstream sami;               //Open the file stream
	sami.open("ASCII.txt");		//Connect to a file
	sami<<"Number  Character\n"
		<<"======  =========\n";
		
	for(int i=-128;i<128;i++)
		sami<<"  "<<i<<"  -  "<<char (i)<<endl; //  Casting || char ch=i; cout<<ch;
	sami.close();							   //   close the connection to FREE the file
	cout<<"Done   saved on ASCII.txt";
}