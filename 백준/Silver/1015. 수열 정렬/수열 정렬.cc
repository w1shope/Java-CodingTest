#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<pair<int, int>, int> p1, pair<pair<int, int>, int> p2) {
    return p1.first.second < p2.first.second;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    int a[n];
    for (int i = 0; i < n; i++)
        cin >> a[i];

    vector<pair<int, int> > b;
    for (int i = 0; i < n; i++)
        b.push_back(make_pair(a[i], i));
    sort(b.begin(), b.end());

    vector<pair<pair<int, int>, int> > bp;
    for (int i = 0; i < n; i++)
        bp.push_back(make_pair(make_pair(b[i].first, b[i].second), i));
    sort(bp.begin(), bp.end(), compare);

    for (int i = 0; i < n; i++)
        cout << bp[i].second << " ";
}