#include <iostream>

using namespace std;

int main() {
    int x, n;
    cin >> x;
    cin >> n;

    for(int i = 0; i < n; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        x -= (a * b);
    }

    if(x == 0) {
        cout << "Yes";
    } else {
        cout << "No";
    }
}