#include <iostream>

using namespace std;

void printer(int x, int y, int z);

int main()
{
    int n = 1;
    cout << "\nn is first parameter, n++ is second parameter, n++ is third parameter" << endl;
    printer(n,n++, n++);

    n = 1;
    cout << "\nn++ is first parameter, n is second parameter, n++ is third parameter" << endl;
    printer(n++,n, n++);

    n = 1;
    cout << "\nn++ is first parameter, n++ is second parameter, n is third parameter" << endl;
    printer(n++,n++, n);

    return 0;
}

void printer(int x, int y, int z){
    cout << "First parameter: " << x << endl;
    cout << "Second parameter: " << y << endl;
    cout << "Third parameter: " << z <<endl;
}

