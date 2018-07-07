#include <iostream>

using namespace std;

struct Sami_struct {
  int member_no_1;
  int member_no_2;
};

int main()
{
  Sami_struct sami_structure_tag;
  Sami_struct *ptr;

  sami_structure_tag.member_no_1 = 12;
  sami_structure_tag.member_no_2 = 24;
  ptr = &sami_structure_tag;							// Yes, you need the & when dealing with sami_structure_tags
                    									//  and using pointers to them
  cout<< "\nThe value of X : " << ptr->member_no_1;     // The -> acts somewhat like the * when used with pointers
  cout<< "\nThe value of Y : " << ptr->member_no_2;		//  It says, get whatever is at that memory address
                    										//  Not "get what that memory address is"
  cin.get();
}
