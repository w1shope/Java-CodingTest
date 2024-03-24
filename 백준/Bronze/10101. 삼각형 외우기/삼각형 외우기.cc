#include <iostream>

using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;

    if (a == 60 && b == 60 && c == 60)
        cout << "Equilateral";
    else if (a + b + c == 180) {
        if(a != b && a != c && b != c)
            cout << "Scalene";
        else {
            cout << "Isosceles";

        }
    } else
        cout << "Error";
}