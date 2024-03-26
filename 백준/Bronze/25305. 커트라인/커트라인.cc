#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    sort(arr, arr + n);

    int score = 0;
    for (int i = n - 1; i >= n - m; i--) {
        score = arr[i];
    }

    cout << score;

}