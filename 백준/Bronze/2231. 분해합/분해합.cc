#include <iostream>

using namespace std;

int calculate(int num) {
    int sum = num;
    string str = to_string(num);
    for (int i = 0; i < str.length(); i++) {
        sum += str.at(i) - '0';
    }
    return sum;
}

int main() {
    int n;
    cin >> n;

    int constructor = 0;
    for (int i = 1; i < n; i++) {
        int result = calculate(i);
        if (result == n) {
            constructor = i;
            break;
        }
    }

    cout << constructor;
}