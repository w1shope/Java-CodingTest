#include <iostream>

using namespace std;

int main() {

    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;

    for(int i = 1; i <= n; i++) {
        for(int j = i; j < n; j++) {
            cout << ' ';
        }
        for(int j = 0; j < i; j++) {
            cout << '*';
        }
        cout << endl;
    }
}