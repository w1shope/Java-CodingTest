#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

bool comp(pair<int, string> p1, pair<int, string> p2) {
    return p1.first < p2.first;
}

int main() {
    int n;
    (cin >> n).ignore();

    vector<pair<int, string> > vector;
    for (int i = 0; i < n; i++) {
        string line;
        getline(cin, line);
        stringstream ss(line);
        int age;
        string name;
        ss >> age >> name;
        vector.push_back(make_pair(age, name));
    }

    stable_sort(vector.begin(), vector.end(), comp);

    for (int i = 0; i < n; i++) {
        cout << vector[i].first << ' ' << vector[i].second << '\n';
    }
}