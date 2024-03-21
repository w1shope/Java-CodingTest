#include <iostream>

using namespace std;

int main() {

    ios_base::sync_with_stdio(false);

    int a, b;
    while(!(cin >> a >> b).eof()) {
        cout << a + b <<endl;
    }
}