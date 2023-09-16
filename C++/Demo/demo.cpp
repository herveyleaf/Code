#include <iostream>
using namespace std;

int getPower(int x, int y){
    int ret = 1;
    if(x == 1){
        return ret;
    }
    else{
        for(y; y > 0; y--)
        ret *= x;
    }
    return ret;
}

double getPower(double x, int y){
    double ret = 1;
    if(x == 1){
        return ret;
    }
    else{
        for(y; y > 0; y--)
        ret *= x;
    }
    return ret;
}

int main(){
    int a, c;
    double b;
    cout << "input:";
    cin >> a >> b >> c;
    cout << "int:" << getPower(a, c) << endl;
    cout << "double:" << getPower(b, c) << endl;
    return 0;
}