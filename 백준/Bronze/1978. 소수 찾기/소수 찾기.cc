#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

vector<int> split(string buffer) {
    istringstream iss(buffer);
    vector<int> result;

    string line;
    while (getline(iss, line, ' ')) {
        result.push_back(stoi(line));
    }
    return result;
}

int main() {
    int n;
    (cin >> n).ignore();

    string buffer;
    getline(cin, buffer);
    vector<int> nums = split(buffer);

    int count = 0;
    for (int i = 0; i < n; i++) {
        int num = nums[i];
        if (num <= 1)
            continue;
        bool flag = false;
        for (int j = 2; j < num; j++) {
            if (num % j == 0)
                flag = true;
        }
        if (!flag)
            count++;
    }
    cout << count;
}