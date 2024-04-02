#include <iostream>

using namespace std;

long factorial(long num) {
    if (num <= 1)
        return 1;
    return num * factorial(num - 1);
}

int main() {
    int n, k;
    cin >> n >> k;

    cout << factorial(n) / (factorial(k) * factorial(n - k));
}