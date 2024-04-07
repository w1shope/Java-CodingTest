#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    (cin >> n).ignore();

    vector<pair<pair<int, int>, pair<int, string> > > v(n);

    for (int i = 0; i < n; i++)
        cin >> v[i].second.second >> v[i].second.first
            >> v[i].first.second >> v[i].first.first;

    sort(v.begin(), v.end());

    cout << v[n - 1].second.second << "\n" << v[0].second.second;
}
