#include <iostream>
using namespace std;

class Rect{

private:
	//representing the 2 sides of the rectangle.
	int s1, s2;

public:

	//constructors:
	//default constructor:
	Rect(){
		s1 = 1;
		s2 = 1;
	}

	//non default constructor:
	Rect(int a, int b){
		s1 = a;
		s2 = b;
	}

        //accessors:
        int getS1(){ return s1; }
        int getS2(){ return s2; }

        //member functions:
	int Area(int s1, int s2){
		return(s1*s2);
	}

	int Perimeter(int s1, int s2){
		return(s1*s1 + s2*s2);
	}
};

int main(){

	Rect r(3,5);

	int s1 = r.getS1();
	int s2 = r.getS2();

	cout << "Area of sides 3, 5 is: "
             << r.Area(s1,s2) <<  endl;

	cout << "Perimeter of sides 3, 5 is: "
             << r.Perimeter(s1,s2) << endl;

	return 0;
}