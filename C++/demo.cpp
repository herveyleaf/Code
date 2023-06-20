#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
inline void keep_window_open() {char ch; cin >> ch;}

int main(){
    double small, large;
    double num;
    cin >> num;
    cout << num << '\n';
    small = large = num;
    for(num; cin >> num;){
        bool judge1 = false, judge2 = false;
        if(num > large){
            large = num;
            judge2 = true;
        }
        if(num < small){
            small = num;
            judge1 = true;
        }
        cout << num << '\n';
        if(judge1){
            cout << "the smallest so far\n";
            judge1 = false;
        }
        if(judge2){
            cout << "the largest so far\n";
            judge2 = false;
        }
    }
    return 0;
}