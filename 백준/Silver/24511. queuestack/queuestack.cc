#include <iostream>
#include <deque>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    int flag[n];
    for (int i = 0; i < n; i++)
        cin >> flag[i];

    deque<int> dq;

    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        if (flag[i] == 0)
            dq.push_back(num);
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;
        dq.push_front(num);
        cout << dq.back() << ' ';
        dq.pop_back();
    }
}