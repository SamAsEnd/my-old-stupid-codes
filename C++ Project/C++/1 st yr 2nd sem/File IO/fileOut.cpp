#include <iostream>
#include <fstream>
using namespace std;

int main () {

  //declare the variable of type ostream
  //since you are dealing with output:
  ofstream myfile;
  
  //function to open the file which includes
  //the file name:
  myfile.open ("example.txt");
  
  //check if the file is open with the is_open() 
  //function:
  if(myfile.is_open()){

      //preform the operation(s):
      myfile << "Hello world!  This is output!" << endl;

      //function to close the file:
      myfile.close();
  }else{

      //is_open() returned false and there is a problem:
      cout << "Can't open the file!" << endl;
  }

  return 0;
}