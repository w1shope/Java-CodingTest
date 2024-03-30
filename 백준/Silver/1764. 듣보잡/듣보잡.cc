#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m;
    (cin >> n >> m).ignore();

    map<string, int> map;
    for (int i = 0; i < n; i++) {
        string name;
        getline(cin, name);
        map[name] = 1;
    }

    int total = 0;
    for (int i = 0; i < m; i++) {
        string name;
        getline(cin, name);
        if (map.find(name) != map.end()) {
            total++;
            map[name] = 0;
        }
    }

    cout << total << '\n';
    for (auto iter = map.begin(); iter != map.end(); iter++) {
        if (iter->second == 0) {
            cout << iter->first << '\n';
        }
    }
}