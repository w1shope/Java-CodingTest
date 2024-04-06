#include <iostream>

using namespace std;

long gcd(long a, long b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    long n, m;
    cin >> n >> m;

    long result = gcd(n, m);
    for (int i = 0; i < result; i++)
        cout << "1";
}