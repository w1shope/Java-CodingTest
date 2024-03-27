#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string str;
    getline(cin, str);

    int nums[str.length()];
    for (int i = 0; i < str.length(); i++) {
        nums[i] = str.at(i) - '0';
    }

    sort(nums, nums + str.length());

    for (int i = str.length() - 1; i >= 0; i--) {
        cout << nums[i];
    }

}