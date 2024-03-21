#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> split(string str, char delimiter) {
    vector<string> nums;
    istringstream ss(str);

    string buffer;
    while(getline(ss, buffer, delimiter)) {
        nums.push_back(buffer);
    }
    return nums;
}

int main() {
    string str;
    getline(cin, str);

    vector<string> nums = split(str, ' ');

    int a = stoi(nums[0]);
    int b = stoi(nums[1]);

    if(a > b) {
        cout << '>';
    } else if(b > a) {
        cout << '<';
    } else {
        cout << "==";
    }
}