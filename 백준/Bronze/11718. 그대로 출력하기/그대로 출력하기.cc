#include <iostream>
#include <string>

using namespace std;

int main() {

    string str;
    while(!getline(cin, str).eof()) {
        cout << str << endl;
    }
}