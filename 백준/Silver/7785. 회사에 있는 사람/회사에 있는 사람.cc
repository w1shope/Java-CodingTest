#include <iostream>
#include <map>
#include <sstream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    (cin >> n).ignore();

    map<string, int, greater<string> > map;
    for (int i = 0; i < n; i++) {
        string line;
        getline(cin, line);
        stringstream ss(line);
        string s1, s2;
        ss >> s1 >> s2;
        if(s2 == "enter") {
            map[s1] = 1;
        } else if(s2 == "leave") {
            map[s1] = 0;
        }
    }

    for (auto iter = map.begin(); iter != map.end(); iter++) {
        if (iter->second == 1)
            cout << iter->first << '\n';
    }
}