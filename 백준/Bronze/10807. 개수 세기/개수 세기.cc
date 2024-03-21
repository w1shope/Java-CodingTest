#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    cin.ignore();

    string str;
    getline(cin, str);

    int v;
    scanf("%d", &v);

    istringstream ss(str);
    string buffer;
    int count = 0;
    while(getline(ss, buffer, ' ')) {
        if(stoi(buffer) == v) {
            count++;
        }
    }

    cout << count;
}