#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <cstring>

using namespace std;

bool comp(string s1, string s2) {
    if (s1.length() == s2.length()) {
        return strcmp(s1.c_str(), s2.c_str()) < 0;
    }
    return s1.length() < s2.length();
}

int main() {
    int n;
    (cin >> n).ignore();

    set<string> set;
    for (int i = 0; i < n; i++) {
        string s;
        getline(cin, s);
        set.insert(s);
    }

    vector<string> vector(set.begin(), set.end());
    sort(vector.begin(), vector.end(), comp);

    for (int i = 0; i < vector.size(); i++) {
        cout << vector[i] << "\n";
    }
}