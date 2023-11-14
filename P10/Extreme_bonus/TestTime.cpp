#include "Time.h"
#include <iostream>

int main() {
    Time time(9, 30, 0);
    int hour = time[0]; // hour is 9
    int minute = time[1]; // minute is 30
    int second = time[2]; // second is 0

    std::cout << "Hour: " << hour << ", Minute: " << minute << ", Second: " << second << std::endl;

    // Let's test the non-const version of the operator
    time[0] = 10; // changing hour to 10
    time[1] = 20; // changing minute to 20
    time[2] = 30; // changing second to 30

    std::cout << "Updated Time: " << time << std::endl;

    return 0;
}

