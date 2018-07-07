#include <iostream>
using namespace std;

int main() {

int myarr[2][3];

	for(int r = 0; r < 2; r++){
		for(int c = 0; c < 3; c++){
			myarr[r][c] = r*c+1;
		}
	}

	for(r = 0; r < 2; r++){
		for(int c = 0; c < 3; c++){
			cout << myarr[r][c] << " ";
		}
		cout << endl;
	}

return 0;

}