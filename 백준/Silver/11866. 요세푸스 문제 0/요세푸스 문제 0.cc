#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, k;
    cin >> n >> k;

    if (n == 1 && k == 1) {
        cout << "<" << 1 << ">";
        return 0;
    }
    queue<int> que;
    for (int i = 1; i <= n; i++) que.push(i);

    cout << "<";
    while (!que.empty()) {
        for (int i = 0; i < k - 1; i++) {
            que.push(que.front()); que.pop();
        }
        cout << que.front();
        if(que.size() != 1)
            cout << ", ";
        que.pop();
    }
    cout << ">";
}