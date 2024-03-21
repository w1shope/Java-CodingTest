#include <iostream>

using namespace std;

int main() {
    int t;
    cin >> t;

    for(int i = 0; i < t; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        cout << a + b <<endl;
    }
}