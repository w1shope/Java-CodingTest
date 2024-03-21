#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> split(string str, char delimiter) {
    vector<int> result;
    istringstream ss(str);

    string buffer;
    while (getline(ss, buffer, delimiter)) {
        result.push_back(stoi(buffer));
    }

    return result;
}

int main() {
    string str;
    getline(cin, str);

    vector<int> nums = split(str, ' ');
    int a = nums[0];
    int b = nums[1];
    int c = nums[2];

    if (a == b && b == c) {
        cout << 10000 + a * 1000;
    }
    else if (a == b || a == c || b == c) {
        if (a == b || a == c) {
            cout << 1000 + a * 100;
        } else {
            cout << 1000 + b * 100;
        }
    }
    else {
        cout << max({a, b, c}) * 100;
    }
}