#include <iostream>
#include <stack>
#include <string>
#include <sstream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    (cin >> n).ignore();

    stack<int> st;
    for (int i = 0; i < n; i++) {
        string s;
        getline(cin, s);
        switch (s.at(0)) {
            case '1': {
                istringstream iss(s);
                int a, b;
                iss >> a >> b;
                st.push(b);
            }
                break;
            case '2':
                if (!st.empty()) {
                    cout << st.top() << '\n';
                    st.pop();
                } else {
                    cout << -1 << '\n';
                }
                break;
            case '3':
                cout << st.size() << '\n';
                break;
            case '4':
                if (st.empty()) {
                    cout << 1 << '\n';
                } else {
                    cout << 0 << '\n';
                }
                break;
            default:
                if (!st.empty()) {
                    cout << st.top() << '\n';
                } else {
                    cout << -1 << '\n';
                }
                break;
        }
    }
}