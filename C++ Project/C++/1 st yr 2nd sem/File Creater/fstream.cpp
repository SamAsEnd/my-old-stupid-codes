#include<fstream.h>
#include<string.h>
void main()
{
	  ofstream sami;
	  sami.open("Sami.sxt");
	  sami<<"Writen in c++!\nMy name is Sam As End\n";
	  sami<<"I am a Programmer!\n";
	  sami<<"S\tA\tM\tS\tO\tN";
	  sami.close();
	  cout<<"Done";
}
