#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    int house[n];
    for (int i = 0; i < n; i++)
        cin >> house[i];

    sort(house, house + n);

    cout << house[(n - 1) / 2];
}