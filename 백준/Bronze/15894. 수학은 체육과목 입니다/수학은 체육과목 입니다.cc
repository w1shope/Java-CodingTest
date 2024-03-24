#include <iostream>

using namespace std;

int main() {
    long n;
    cin >> n;

    long sum = 0;
    sum += (1 + n);
    sum += (2 * n);
    sum += (n - 1);

    cout << sum;
}