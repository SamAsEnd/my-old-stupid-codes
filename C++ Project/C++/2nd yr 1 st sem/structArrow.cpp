#include <iostream>
using namespace std;

struct Point{
	int x;
	int y;
};

int main(){

	Point* p = new Point;

	p->x = 9;
	p->y = 4;

	cout << p->x << " " << p->y << endl;

	return 0;
}