#include <iostream>
#include "MergeSort.h"
using namespace std;

int main(){
    int test[] = {2, 4, 5, 7, 1, 2, 3, 6, 9, 8};
    int length = sizeof(test) / sizeof(test[0]);
    merge_sort(test, 0, length - 1);
    for(int x = 0; x < length; x++)
        cout << test[x] << ' ';
    cout << '\n';
    return 0;
}