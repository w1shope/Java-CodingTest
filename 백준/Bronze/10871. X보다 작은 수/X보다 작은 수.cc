#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main() {
    int n, x;
    scanf("%d %d", &n, &x);
    cin.ignore();

    string str;
    getline(cin, str);

    istringstream ss(str);
    string buffer;
    while(getline(ss, buffer, ' ')) {
        if(stoi(buffer) < x) {
            cout << buffer << ' ';
        }
    }
}