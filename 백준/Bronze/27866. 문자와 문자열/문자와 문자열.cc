#include <iostream>
#include <string>

using namespace std;

int main() {
    string str;
    cin >> str;
    cin.ignore();

    int idx;
    cin >> idx;
    cout << str.at(idx - 1);
}