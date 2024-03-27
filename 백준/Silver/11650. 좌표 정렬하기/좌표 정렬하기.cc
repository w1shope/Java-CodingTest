#include <iostream>
#include <utility>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);

    vector<pair<int, int> > vector;

    for (int i = 0; i < n; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        vector.push_back(make_pair(a, b));
    }

    sort(vector.begin(), vector.end());

    for (int i = 0; i < n; i++) {
        cout << vector[i].first << ' ' << vector[i].second << '\n';
    }

}