#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    string input;
    map<string, int> map;
    int cnt = 0;
    while(!getline(cin, input).eof()) {
        if(map.count(input) == 0) {
            map[input] = 1;
        } else {
            map[input] += 1;
        }
        cnt++;
    }

    cout << fixed;
    cout.precision(4);
    for(auto iter = map.begin(); iter != map.end(); iter++) {
        cout << iter->first << " " << ((float) iter->second) / cnt * 100 << "\n";
    }
}