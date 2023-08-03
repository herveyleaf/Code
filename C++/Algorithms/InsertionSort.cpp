#include <vector>
#include "InsertionSort.h"
using namespace std;

int insertion_sort(vector<double> &nums, double x){
    int length = nums.size();
    for(int j = 1; j < length; j++){
        int key = nums[j];
        int i = j - 1;
        while(i >= 0 && nums[i] > key){
            nums[i + 1] = nums[i];
            i -= 1;
        }
        nums[i + 1] = key;
    }
    int k = 0;
    while(nums[k] != x && k < length)
        k++;
    if(k == length)
        return -1;
    else
        return k;
}