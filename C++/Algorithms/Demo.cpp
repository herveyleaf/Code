#include <iostream>
#include "InsertionSort.h"
using namespace std;

int main(){
    vector<double> test = {5, 2, 4, 6, 1, 3};
    insertion_sort(test);
    for(double x : test)
        cout << x << ' ';
    return 0;
}