#include <iostream>

using namespace std;

int reverse(int num) {
    return (num % 100 % 10 * 100) + (num % 100 / 10 * 10) + (num / 100);
}

int main() {
    int num1, num2;
    cin >> num1 >> num2;

    int reverseNum1 = reverse(num1);
    int reverseNum2 = reverse(num2);

    if(reverseNum1 > reverseNum2) {
        cout << reverseNum1;
    } else {
        cout << reverseNum2;
    }
}