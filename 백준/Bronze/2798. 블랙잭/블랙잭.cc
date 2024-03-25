#include <iostream>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, m;
    (cin >> n >> m).ignore();
    vector<int> vector;
    string line;
    getline(cin, line);
    istringstream iss(line);
    int num;
    while (iss >> num)
        vector.push_back(num);

    sort(vector.begin(), vector.end());

    int maxSum = -1;
    for (int i = 0; i < vector.size(); i++) {
        for (int j = i + 1; j < vector.size(); j++) {
            for (int k = j + 1; k < vector.size(); k++) {
                int sum = vector[i] + vector[j] + vector[k];
                if(m >= sum) {
                    maxSum = max(maxSum, sum);
                }
            }
        }
    }

    cout << maxSum;
}