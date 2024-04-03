#include <iostream>

#define MAX 9

using namespace std;

int graph[MAX];
bool visited[MAX];
int n, m;

void traverse(int depth) {
    if (depth == m) {
        for (int i = 0; i < m; i++)
            cout << graph[i] << ' ';
        cout << "\n";
        return;
    }
    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            visited[i] = true;
            graph[depth] = i;
            traverse(depth + 1);
            visited[i] = false;
        }
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;
    traverse(0);
}