#include <iostream>

using namespace std;

void swap(int *p1, int *p2) {
    int tmp = *p1;
    *p1 = *p2;
    *p2 = tmp;
}

int main() {
    int n, m;
    cin >> n >> m;

    int nums[n];
    for (int i = 0; i < n; i++) {
        nums[i] = i + 1;
    }

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        a -= 1, b -= 1;

        int count = 0;
        for (int j = a; j < b; j++) {
            if (j > (b - count)) {
                break;
            }
            swap(&nums[j], &nums[b - count++]);
        }
    }
    
    for (int i = 0; i < n; i++) {
        cout << nums[i] << endl;
    }
}