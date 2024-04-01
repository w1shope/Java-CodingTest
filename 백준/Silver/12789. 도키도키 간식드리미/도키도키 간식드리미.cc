#include <iostream>
#include <deque>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    deque<int> dq1;
    deque<int> dq2;

    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        dq1.push_back(num);
    }

    int curNum = 1;
    while (!dq1.empty() || !dq2.empty()) {
        if (curNum == dq1.front()) {
            curNum += 1;
            dq1.pop_front();
        } else {
            if (!dq2.empty()) {
                if (dq2.back() == curNum) {
                    dq1.push_front(dq2.back());
                    dq2.pop_back();
                } else {
                    if (!dq1.empty()) {
                        dq2.push_back(dq1.front());
                        dq1.pop_front();
                    } else {
                        cout << "Sad";
                        return 0;
                    }
                }
            } else {
                if (!dq1.empty()) {
                    dq2.push_back(dq1.front());
                    dq1.pop_front();
                }
            }
        }
    }
    cout << "Nice";
}