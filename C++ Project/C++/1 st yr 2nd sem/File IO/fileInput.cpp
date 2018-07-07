// reading a text file
#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>

using namespace std;

int main () {
  string line;
  
  //the variable of type ifstream:
  ifstream myfile ("example.txt");
  
  //check to see if the file is opened:
  if (myfile.is_open())
  {
    //while there are still lines in the
    //file, keep reading:
    while (! myfile.eof() )
    {
      //place the line from myfile into the
      //line variable:
      getline (myfile,line);

      //display the line we gathered:
      cout << line << endl;
    }

    //close the stream:
    myfile.close();
  }

  else cout << "Unable to open file";
	system("pause");
  return 0;
}
