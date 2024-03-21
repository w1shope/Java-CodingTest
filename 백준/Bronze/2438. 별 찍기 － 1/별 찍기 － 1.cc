#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;

    string buffer;
    for(int i = 0; i < n; i++) {
        buffer += '*';
        cout << buffer << endl;
    }
}