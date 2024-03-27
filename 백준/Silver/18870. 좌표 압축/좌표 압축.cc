#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    vector<int> sv(v); // 2 4 -10 4 -9
    sort(sv.begin(), sv.end());

    sv.erase(unique(sv.begin(), sv.end()), sv.end()); // -10 -9 2 4

    for (int i = 0; i < n; i++) {
        auto it = lower_bound(sv.begin(), sv.end(), v[i]);
        cout << it - sv.begin() << ' ';
    }
}