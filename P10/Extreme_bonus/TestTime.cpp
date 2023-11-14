#include "Time.h"
#include <iostream>

void normalizeTime(Time& time) {
    // Normalize seconds
    if (time[2] >= 60) {
        time[1] += time[2] / 60;
        time[2] %= 60;
    }

    // Normalize minutes
    if (time[1] >= 60) {
        time[0] += time[1] / 60;
        time[1] %= 60;
    }

    if (time[0] >= 24) {
        time[0] %= 24;
    }

}

int main() {
    Time time(9, 30, 0);
    std::cout << "\nInitial time: " << time << std::endl;
    
    int hour = time[0];
    int minute = time[1];
    int second = time[2];
    std::cout << "Hour: " << hour << ", Minute: " << minute << ", Second: " << second << std::endl;
    
    int addHours, addMinutes, addSeconds;
    std::cout << "Enter the number of hours to add: ";
    std::cin >> addHours;
    std::cout << "Enter the number of minutes to add: ";
    std::cin >> addMinutes;
    std::cout << "Enter the number of seconds to add: ";
    std::cin >> addSeconds;
    
    time[0] += addHours;
    time[1] += addMinutes;
    time[2] += addSeconds;

    normalizeTime(time);

    std::cout << "Modified time: " << time << std::endl;

    return 0;
}

