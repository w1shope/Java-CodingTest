#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    (cin >> T).ignore();

    for (int t = 0; t < T; t++) {
        stack<char> st;
        string line;
        getline(cin, line);
        bool flag = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.at(i);
            if (c == ')') {
                if(st.empty()) {
                    flag = true;
                    break;
                } else
                    st.pop();
            } else {
                st.push('(');
            }
        }
        if(!flag && st.empty())
            cout << "YES\n";
        else
            cout << "NO\n";
    }
}