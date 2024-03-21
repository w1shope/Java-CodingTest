#include <iostream>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    int balls[n];
    for(int i = 0; i < n; i++) {
        balls[i] = i + 1;
    }

    for(int t = 0; t < m; t++) {
        int i, j;
        cin >> i >> j;
        int tmp = balls[i - 1];
        balls[i - 1] = balls[j - 1];
        balls[j - 1] = tmp;
    }

    for(int i = 0; i < n; i++ ){
        cout << balls[i] << ' ';
    }
}