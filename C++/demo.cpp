#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
inline void keep_window_open() {char ch; cin >> ch;}

int main(){
    string kind;
    int cnt = 0;
    double sum = 0;
    double small, large;
    double num;
    double mret;
    bool ctrl = false, yes = false;
    vector<string> kinds = {"cm", "m", "in", "ft"};
    vector<double> nums;
    for(num; cin >> num >> kind;){
        for(string x : kinds){
            if(kind == x){
                yes = true;
            }
        }
        if(yes != true){
            cout << "wrong value kind";
            break;
        }
        yes = false;
        char rep = kind[0];
        switch(rep){
        case'm':
            mret = num;
            break;
        case'c':
            mret = num / 100;
            break;
        case'i':
            mret = num * 2.54 / 100;
            break;
        case'f':
            mret = num * 12 * 2.54 / 100;
            break;
        }
        if(ctrl){}
        else{
            small = large = mret;
        }
        bool judge1 = false, judge2 = false;
        if(mret > large){
            large = mret;
            judge2 = true;
        }
        if(mret < small){
            small = mret;
            judge1 = true;
        }
        cout << num << kind << '\n' << "mret = " << mret << "m" << '\n';
        if(ctrl){
            if(judge1){
                cout << "the smallest so far\n";
                judge1 = false;
            }
            if(judge2){
                cout << "the largest so far\n";
                judge2 = false;
            }    
        }
        sum += mret;
        nums.push_back(mret);
        cnt++;
        ctrl = true;
    }
    cout << "cnt = " << cnt << '\n' << "sum = " << sum << "m" << '\n';
    for(double x : nums){
        cout << x << 'm' << ' ';
    }
    return 0;
}