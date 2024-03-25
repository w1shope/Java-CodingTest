#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int count = 0;
    for (int i = 1;; i++) {
        if (to_string(i).find("666") != string::npos) {
            count++;
        }
        if (count == n) {
            cout << i;
            break;
        }
    }
}