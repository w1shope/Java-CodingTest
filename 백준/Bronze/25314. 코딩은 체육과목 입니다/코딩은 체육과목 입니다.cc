#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    cout << "long ";

    for(int i = 0; i < (n/4) - 1; i++) {
        cout << "long ";
    }

    cout << "int";
}