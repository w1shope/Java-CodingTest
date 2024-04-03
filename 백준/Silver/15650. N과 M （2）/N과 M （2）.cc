#include <iostream>
#include <algorithm>

#define MAX 9

int n, m;
int graph[MAX];
bool visited[MAX];

using namespace std;

void traverse(int depth, int s) {
    if (depth == m) {
        for (int i = 0; i < m; i++)
            cout << graph[i] << ' ';
        cout << "\n";
    }
    for (int i = s; i <= n; i++) {
        if (!visited[i]) {
            visited[i] = true;
            graph[depth] = i;
            traverse(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;

    traverse(0, 1);
}