#include <iostream>

using namespace std;

int main() {
    int n;
    (cin >> n).ignore();
    string buffer;
    for (int i = 2; i <= n;) {
        if(n == 1) {
            break;
        }
        if(n % i == 0) {
            n /= i;
            cout << i << endl;
        } else {
            i++;
        }
    }

    cout << buffer;
}