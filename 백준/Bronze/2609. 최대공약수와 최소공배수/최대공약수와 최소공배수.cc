#include <iostream>

using namespace std;

void swap(int *a, int *b) {
    if(*a > *b) {
        int tmp = *a;
        *a = *b;
        *b = tmp;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int a, b;
    cin >> a >> b;

    swap(&a, &b);

    int divide = 2;
    int gcd = 1, lcm = 1; // 최대공약수, 최소공배수
    while(a >= divide) {
        if(a % divide == 0 && b % divide == 0) {
            a /= divide; b /= divide;
            gcd *= divide;
        } else {
            divide++;
        }
    }
    lcm *= a; lcm *= b;
    lcm *= gcd;

    cout << gcd << "\n" << lcm;
}