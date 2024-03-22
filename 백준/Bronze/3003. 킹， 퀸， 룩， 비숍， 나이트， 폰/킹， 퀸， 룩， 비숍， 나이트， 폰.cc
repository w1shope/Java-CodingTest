#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

void calculate(vector<int>& vector, string str) {
    istringstream ss(str);

    string buffer;
    int idx = 0;
    while(getline(ss, buffer, ' ')) {
        cout << vector[idx++] - stoi(buffer) << ' ';
    }
}

int main() {
    vector<int> vector;
    vector.push_back(1);
    vector.push_back(1);
    vector.push_back(2);
    vector.push_back(2);
    vector.push_back(2);
    vector.push_back(8);

    string str;
    getline(cin, str);

    calculate(vector, str);
}