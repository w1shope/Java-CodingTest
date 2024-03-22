#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    int n;
    (cin >> n).ignore();

    for(int i = 0; i < n; i++) {
        int count;
        string str;
        (cin >> count >> str).ignore();
        for(int j = 0; j < str.length(); j++) {
            for(int k = 0; k < count; k++) {
                cout << str.at(j);
            }
        }
        cout << "\n";
    }
}