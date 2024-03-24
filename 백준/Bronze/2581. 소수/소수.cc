#include <iostream>

using namespace std;

bool prime_num(int num) {
    for (int i = 2; i < num; i++) {
        if (num % i == 0)
            return true;
    }
    return false;
}

int main() {
    int m, n;
    cin >> m;
    cin >> n;

    int sum = 0;
    int minPrimeNum = 0;
    bool firstPrimeNum = false;
    for (int i = m; i <= n; i++) {
        if(i <= 1)
            continue;
        bool isPrime = prime_num(i);
        if (!isPrime && !firstPrimeNum) {
            firstPrimeNum = true;
            minPrimeNum = i;
        }
        if (!isPrime) {
            sum += i;
        }
    }

    if (sum == 0)
        cout << -1;
    else
        printf("%d\n%d", sum, minPrimeNum);
}