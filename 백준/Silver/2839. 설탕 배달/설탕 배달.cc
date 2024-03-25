#include <iostream>
#include <climits>

using namespace std;

int main() {
    int n;
    cin >> n;

    int countKg5 = 0;
    int minCount = INT_MAX;
    while (n - (5 * countKg5) >= 0) {
        int m = n - (5 * countKg5);
        if (m % 3 == 0) {
            minCount = min(minCount, countKg5 + (m / 3));
        }
        countKg5++;
    }

    if (minCount == INT_MAX)
        cout << -1;
    else
        cout << minCount;
}