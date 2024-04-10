#include <bits/stdc++.h>

using namespace std;

void init(bool *arr) {
    for (int i = 123; i <= 987; i++)
        arr[i] = true;
    for (int i = 123; i <= 987; i++) {
        string str = to_string(i);
        if ((str[0] == str[1] || str[0] == str[2] || str[1] == str[2]) ||
            str[0] - '0' == 0 || str[1] - '0' == 0 || str[2] - '0' == 0)
            arr[i] = false;
    }
}

int main() {
    int n;
    cin >> n;

    bool arr[1000];
    init(arr);

    for (int i = 0; i < n; i++) {
        int num, strike, ball;
        cin >> num >> strike >> ball;

        for (int s = 123; s <= 987; s++) {
            int s_cnt = 0, b_cnt = 0;

            if(arr[s]) {
                string s1 = to_string(num);
                string s2 = to_string(s);

                for (int w = 0; w < 3; w++) {
                    for (int q = 0; q < 3; q++) {
                        if(w == q && s1[w] == s2[q])
                            s_cnt++;
                        if(w != q && s1[w] == s2[q])
                            b_cnt++;
                    }
                }
                if(s_cnt != strike || b_cnt != ball)
                    arr[s] = false;
            }
        }
    }

    int cnt = 0;
    for(int i = 123; i <= 987; i++) {
        if(arr[i])
            cnt++;
    }

    cout << cnt;
}