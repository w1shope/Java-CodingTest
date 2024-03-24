#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int minX = 100001;
    int minY = 100001;
    int maxX = -100001;
    int maxY = -100001;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        minX = min(x, minX);
        maxX = max(x, maxX);
        minY = min(y, minY);
        maxY = max(y, maxY);
    }

    cout << (maxX - minX) * (maxY - minY);
}