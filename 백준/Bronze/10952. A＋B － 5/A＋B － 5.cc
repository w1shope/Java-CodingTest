#include <iostream>

using namespace std;

int main() {

    ios_base::sync_with_stdio(false);

    while(true) {
        int a, b;
        scanf("%d %d", &a, &b);
        if(a == 0 && b == 0)
            break;
        cout << a + b << endl;
    }
}