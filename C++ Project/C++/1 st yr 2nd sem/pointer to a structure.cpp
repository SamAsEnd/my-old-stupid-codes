#include <iostream>

using namespace std;

struct xampl {
  int x;
};

int main()
{
  xampl structure;
  xampl *ptr;

  structure.x = 12;
  ptr = &structure; // Yes, you need the & when dealing with structures
                    //  and using pointers to them
  cout<< ptr->x;    // The -> acts somewhat like the * when used with pointers
                    //  It says, get whatever is at that memory address
                    //  Not "get what that memory address is"
  cin.get();
}
