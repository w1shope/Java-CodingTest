#include <algorithm>
#include <string>
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    (cin >> n >> m).ignore();

    string str[n];
    for (int i = 0; i < n; i++) {
        getline(cin, str[i]);
    }

    sort(str, str + n);

    int total = 0;
    for (int i = 0; i < m; i++) {
        string input;
        getline(cin, input);
        if (binary_search(str, str + n, input)) {
            total++;
        }
    }

    printf("%d", total);
}