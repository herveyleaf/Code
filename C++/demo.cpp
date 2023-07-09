#include "std_lib_facilities.h"

class Name_pairs{
public:
    void read_name(vector<string>);
    void read_ages();
    void print();
    void sort();
private:
    string name;
    double age;
    vector<string> pair;
};

void Name_pairs::read_name(vector<string> names){
    pair = names;
}

void Name_pairs::read_ages(){
    string temp;
    for(int length = pair.size(), cnt = 0; length > 0; length--, cnt++){
        cin >> temp;
        pair[cnt] += (' ' + temp);
    }
}

void Name_pairs::print(){
    for(string x : pair){
        cout << x << '\n';
    }
}

int main(){
    vector<string> names;
    string temp;
    while(cin >> temp && temp != "stop"){
        names.push_back(temp);
    }
    Name_pairs test;
    test.read_name(names);
    test.read_ages();
    test.print();
    return 0;
}