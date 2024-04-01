#include <deque>
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    deque<int> dq;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        if (a == 1) {
            int b;
            cin >> b;
            dq.push_front(b);
        } else if (a == 2) {
            int b;
            cin >> b;
            dq.push_back(b);
        } else if (a == 5)
            cout << dq.size() << "\n";
        else {
            if (dq.empty()) {
                if (a == 3 || a == 4 || a == 7 || a == 8)
                    cout << "-1\n";
                else if (a == 6)
                    cout << "1\n";
            } else {
                if (a == 3) {
                    cout << dq.front() << "\n";
                    dq.pop_front();
                } else if (a == 4) {
                    cout << dq.back() << "\n";
                    dq.pop_back();
                } else if (a == 6)
                    cout << "0\n";
                else if (a == 7)
                    cout << dq.front() << "\n";
                else if (a == 8)
                    cout << dq.back() << "\n";
            }
        }
    }
}