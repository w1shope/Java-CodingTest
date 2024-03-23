#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

vector<int> split(string line) {
    istringstream ss(line);
    vector<int> result;
    string buffer;
    while (getline(ss, buffer, ' ')) {
        result.push_back(stoi(buffer));
    }
    return result;
}

int main() {
    int n, m;
    (cin >> n >> m).ignore();

    int arr1[n][m];
    int arr2[n][m];
    for (int i = 0; i < n; i++) {
        string line;
        getline(cin, line);
        vector<int> vector = split(line);
        for (int j = 0; j < vector.size(); j++) {
            arr1[i][j] = vector[j];
        }

    }
    for (int i = 0; i < n; i++) {
        string line;
        getline(cin, line);
        vector<int> vector = split(line);
        for (int j = 0; j < vector.size(); j++) {
            arr2[i][j] = vector[j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << arr1[i][j] + arr2[i][j] << ' ';
        }
        cout << '\n';
    }
}