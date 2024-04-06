#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    (cin >> n).ignore();
    for(int i = 0; i < n; i++) {
        string line;
        getline(cin, line);
        stringstream ss(line);
        int sum = 0;
        while(getline(ss, line, ',')) {
            sum += stoi(line);
        }
        cout << sum << '\n';
    }
}