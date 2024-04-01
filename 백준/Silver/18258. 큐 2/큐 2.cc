#include <queue>
#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    (cin >> n).ignore();

    queue<string> que;

    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        if (str == "push") {
            string s;
            cin >> s;
            que.push(s);
        } else if (str == "size") {
            cout << que.size() << "\n";
        } else {
            if (que.empty()) {
                if (str == "pop")
                    cout << "-1" << "\n";
                else if (str == "empty")
                    cout << "1" << "\n";
                else if (str == "front")
                    cout << "-1" << "\n";
                else if (str == "back")
                    cout << "-1" << "\n";
            } else {
                if (str == "pop") {
                    cout << que.front() << "\n";
                    que.pop();
                } else if (str == "empty")
                    cout << "0" << "\n";
                else if (str == "front")
                    cout << que.front() << "\n";
                else if (str == "back")
                    cout << que.back() << "\n";
            }
        }
    }
}