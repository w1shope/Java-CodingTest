#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool comp(pair<int, int> p1, pair<int, int> p2) {
    if (p1.second == p2.second) {
        return p1.first < p2.first;
    }
    return p1.second < p2.second;
}

int main() {
    int n;
    scanf("%d", &n);

    vector<pair<int, int> > vector;

    for (int i = 0; i < n; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        vector.push_back(make_pair(a, b));
    }

    sort(vector.begin(), vector.end(), comp);

    for (int i = 0; i < n; i++) {
        printf("%d %d\n", vector[i].first, vector[i].second);
    }
}