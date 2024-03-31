#include <iostream>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    stack<int> st;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        if (num == 0)
            st.pop();
        else
            st.push(num);
    }

    int sum = 0;
    while(!st.empty()) {
        sum += st.top();
        st.pop();
    }

    cout << sum;
}