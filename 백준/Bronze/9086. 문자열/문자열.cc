#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;
    cin.ignore();

    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        cin.ignore();
        printf("%c%c\n", str.at(0), str.at(str.length() - 1));
    }
}