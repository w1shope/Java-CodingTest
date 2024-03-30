#include <iostream>
#include <map>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    (cin >> n >> m).ignore();

    map<int, string> m1;
    map<string, int> m2;
    for (int i = 0; i < n; i++) {
        string str;
        getline(cin, str);
        m1[i + 1] = str;
        m2[str] = i + 1;
    }

    for (int i = 0; i < m; i++) {
        string str;
        getline(cin, str);
        if (atoi(str.c_str())) {
            cout << m1[stoi(str)] << '\n';
        } else {
            cout << m2[str] << '\n';
        }
    }
}