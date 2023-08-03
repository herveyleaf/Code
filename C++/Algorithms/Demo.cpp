#include <iostream>
#include "InsertionSort.h"
using namespace std;

int main(){
    vector<double> test = {5, 2, 4, 6, 1, 3};
    double x = 6;
    cout << "x = nums[" << insertion_sort(test, x) << "]\n";
    for(double x : test)
        cout << x << ' ';
    return 0;
}