#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> vector;
    while (true) {
        int n;
        cin >> n;
        if (n == -1) {
            break;
        }
        vector.push_back(n);
    }

    sort(vector.begin(), vector.end());

    for (int i = 0; i < vector.size(); i++) {
        int num = vector[i];
        string buffer = to_string(num) + " = ";
        int sum = 0;
        for (int j = 1; j < num; j++) {
            if (num % j == 0) {
                sum += j;
                buffer += to_string(j) + " + ";
            }
        }
        if (num == sum) {
            cout << buffer.substr(0, buffer.length() - 3) << endl;
        } else {
            printf("%d is NOT perfect.\n", num);
        }
    }
}