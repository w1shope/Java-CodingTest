#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

vector<string> split(string str, char delimiter) {
    vector<string> result;
    istringstream ss(str);

    string buffer;
    while(getline(ss, buffer, delimiter)) {
        result.push_back(buffer);
    }
    return result;
}

int main() {
    string str;
    getline(cin, str);
    vector<string> nums = split(str, ' ');

    long sum = 0;
    for(int i = 0; i < 3; i++) {
        sum += stol(nums[i]);
    }

    cout << sum;
}