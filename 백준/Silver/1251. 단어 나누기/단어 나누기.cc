#include <bits/stdc++.h>

using namespace std;

int main() {
    string str;
    getline(cin, str);

    vector<string> v;
    int n = str.length();
    int idx1 = 1, idx2 = 1, idx3 = 1;
    for (int j = 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
            string s1 = str.substr(0, idx1);
            string s2 = str.substr(j, idx2);
            string s3 = str.substr(k);
            idx2++;
            
            reverse(s1.begin(), s1.end());
            reverse(s2.begin(), s2.end());
            reverse(s3.begin(), s3.end());

            v.push_back(s1 + s2 + s3);
        }
        idx1++;
        idx2 = 1;
    }

    sort(v.begin(), v.end());

    cout << v[0];
}