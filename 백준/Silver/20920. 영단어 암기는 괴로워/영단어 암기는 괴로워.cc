#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

bool compare(pair<string, int> p1, pair<string, int> p2) {
    if (p1.second != p2.second)
        return p1.second > p2.second;
    if (p1.first.length() != p2.first.length())
        return p1.first.length() > p2.first.length();
    return p1 < p2;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, m;
    (cin >> n >> m).ignore();

    map<string, int> map;
    for (int i = 0; i < n; i++) {
        string word;
        getline(cin, word);
        if (word.length() >= m) {
            if (map.count(word) == 1) { // 이미 존재
                map[word] += 1;
            } else {
                map[word] = 1;
            }
        }
    }

    vector<pair<string, int> > v(map.begin(), map.end());
    sort(v.begin(), v.end(), compare);

    for (int i = 0; i < v.size(); i++)
        cout << v[i].first << "\n";
}