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

	//mutators:
	void setS1(int s){
		if(s <= 0)
			return;

		s1 = s;
	}
	void setS2(int s){
		if(s <= 0)
			return;

		s2 = s;
	}

	//member functions:
	int Area(int s1, int s2){
		return(s1*s2);
	}

	int Perimeter(int s1, int s2){
		return(s1*s1 + s2*s2);
	}

	void triple(){
		s1 *= 3;
		s2 *= 3;
	}

	void operator=(const Rect r){
		s1 = r.s1;
		s2 = r.s2;
	}

	int operator+(Rect r){

		int sum = 0;

		sum = sum + Perimeter(s1,s2);
		sum = sum + Perimeter(r.getS1(), r.getS2());

		return sum;
	}

};

int main(){

	Rect r(3,5), s(2,4);
	
	int s1 = r.getS1();
	int s2 = r.getS2();

	cout << "Area of sides 3, 5 is: " 
		 << r.Area(s1,s2) << endl;

	cout << "Perimeter of sides 3, 5 is: " 
		 << r.Perimeter(s1,s2) << endl;

	r.triple();

	cout << "Tripled sides: s1= " << r.getS1() 
		 << " s2 =" << r.getS2() << endl;

	int sum = r + s;

	cout << "The sum is: " << sum << endl;

	r = s;

	cout << r.getS1() << "  " << r.getS2() << endl;
	return 0;
}



