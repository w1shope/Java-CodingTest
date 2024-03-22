#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string str;
    getline(cin, str);

    string reverse = str;
    std::reverse(reverse.begin(), reverse.end());

    if(str == reverse) {
        cout << 1;
    } else {
        cout << 0;
    }
}