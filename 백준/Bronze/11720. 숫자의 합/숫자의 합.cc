#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    (cin >> n).ignore();

    string str;
    cin >> str;

    int sum = 0;
    for(int i = 0; i < n; i++) {
        sum += str.at(i) - '0';
    }

    cout << sum;
}