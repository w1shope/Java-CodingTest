#include <iostream>

#define MAX 9

using namespace std;

int graph[MAX];

bool isBreak(int m) {
    for (int i = 1; i <= m - 1; i++) {
        if (graph[i - 1] > graph[i]) {
            return true;
        }
    }
    return false;
}

void dfs(int depth, int n, int m) {
    if (depth == m) {
        if (isBreak(m))
            return;
        for (int i = 0; i < m; i++) {
            cout << graph[i] << ' ';
        }
        cout << "\n";
        return;
    }

    for (int i = 1; i <= n; i++) {
        graph[depth] = i;
        dfs(depth + 1, n, m);
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, m;
    cin >> n >> m;

    dfs(0, n, m);
}