#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

vector<int> split(string str) {
    vector<int> result;
    istringstream ss(str);

    string buffer;
    while(getline(ss, buffer, ' ')) {
        result.push_back(stoi(buffer));
    }

    return result;
}

int maxNum(vector<int> vector) {
    sort(vector.begin(), vector.end());
    return vector[vector.size() -1];
}

int main() {
    int n;
    cin >> n;
    cin.ignore();

    string str;
    getline(cin, str);
    vector<int> vector = split(str);

    int max = maxNum(vector);

    float sum = 0;
    for(int i = 0; i < vector.size(); i++) {
        sum += (float) vector[i] / max * 100;
    }

    printf("%f", sum / n);
}