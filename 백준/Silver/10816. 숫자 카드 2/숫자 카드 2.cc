#include <map>
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n;
    map<int, int> map;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        if (map.find(num) == map.end()) {
            map[num] = 1;
        } else {
            map[num] += 1;
        }
    }

    cin >> m;
    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;
        cout << map[num] << ' ';
    }
}