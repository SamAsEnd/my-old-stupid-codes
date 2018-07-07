#include <iostream>
#include <string>
using namespace std;

int main(){

	string str = "Welcome Sam As End";

	/*
		1. The length() function OR the size()
		function return an integer which is
		the size of the string.
	*/
	cout << "Calling length(): " << str.length() << endl;
	cout << "Calling size(): " << str.size() << endl;

	/*
		2. The find function will return an integer
		representing the FIRST OCCURANCE of a certain
		string, here the functions argument.
    */
	cout << "Calling find(\"to\"):" << str.find("to") << endl;

	/*
		3. The substr() function "substring" will return a string
		which starts and ends at a determined index(es), the
		arguments of the function.  If only 1 argument is given,
		it will begin at that index and continue all the way to the end.
	*/
	cout << "Calling substr(0,2): " << str.substr(0,2) << endl;
	cout << "Calling substr(4): " << str.substr(4) << endl;

	/*
		4. The insert() function will look at a designated index
		and insert the string, as the second parameter, in that
		place.
    */
	cout << str.insert(0,"HHH") << endl;

	/*
		5. The append() function will add the string argument
		to the END of the string.
	*/
	str.append("----");
	cout << str << endl;
	cin.get();
	return 0;
}
