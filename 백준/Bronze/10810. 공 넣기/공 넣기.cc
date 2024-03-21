#include <iostream>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    int balls[n];
    for(int i = 0; i < n; i++) {
        balls[i] = 0;
    }

    for(int t = 0; t < m; t++) {
        int i, j, k;
        cin >> i >> j >>k;
        for(int w = i - 1; w <= j - 1; w++) {
            balls[w] = k;
        }
    }

    for(int i = 0; i < n; i++) {
        cout << balls[i] << ' ';
    }
}