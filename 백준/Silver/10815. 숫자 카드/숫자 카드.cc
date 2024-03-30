#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n, m;
    scanf("%d", &n);
    int nArr[n];
    for (int i = 0; i < n; i++)
        scanf("%d", &nArr[i]);

    sort(nArr, nArr + n);

    scanf("%d", &m);
    int mArr[m];
    for (int i = 0; i < m; i++) {
        int num;
        scanf("%d", &num);
        if (binary_search(nArr, nArr + n, num)) {
            printf("1 ");
        } else {
            printf("0 ");
        }
    }

    return 0;
}